package com.project.aircnc.common;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.session.SqlSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

public class MyUtils {
	
	@Autowired
	private static SqlSession sqlSession;
	
	// 암호화 salt 구하기 
	public static String gensalt() {
		return BCrypt.gensalt();
	}
	// 암호화 
	public static String hashPassword(String pw, String salt) {
		return BCrypt.hashpw(pw, salt);
	}
	// text 문자열 줄바꿈 변환  \n -> <br>
	public static String setStrFilter(String str) {
		
		String	returnStr =str.replaceAll("\n", "<br>");
				returnStr =returnStr.replaceAll(" ", "&nbsp;");
		
		return returnStr;
	}
	
	
	
	// 로그인 유저 i_user 가져오기 
	public static int getSesstion(HttpSession hs) {
		TUserVO	loginUser = (TUserVO)hs.getAttribute("loginUser");
		return loginUser.getI_user();
	}

	// 리턴값: 저장된 파일명
	//   "/resources/user/??"
	public static String saveFile(String path, MultipartFile file) {
		String fileNm = null;
		UUID uuid = UUID.randomUUID();
		
		// 확장자
		String ext = FilenameUtils.getExtension(file.getOriginalFilename());
		System.out.println("ext : " + ext);
		
		fileNm = String.format("%s.%s", uuid, ext);
		String saveFileNm = String.format("%s/%s", path, fileNm);
		
		System.out.println("saveFileNm : " + saveFileNm);
		File saveFile = new File(saveFileNm);
		saveFile.mkdirs();
		
		try {			
			file.transferTo(saveFile); // 업로드 파일에 saveFile로 위치로 저장했다.
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		return fileNm;
	}
	
	//이미지 삭제
	public static boolean deleteFile(String filePath) {
		boolean result = false;
		File file = new File(filePath);		
		if(file.exists()) {
			result = file.delete();
		}
		return result;
	}
	
	// 일수 계산 
	public static long changeDate(String chin, String chout) throws ParseException {
		// chin chout 사이 일수 계산 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse(String.valueOf(chin));
		Date endDate = sdf.parse(String.valueOf(chout));
		//두날짜 사이의 시간 차이(ms)를 하루 동안의 ms(24시*60분*60초*1000밀리초) 로 나눈다.
		long diffDay = (endDate.getTime() - startDate.getTime() ) / (24*60*60*1000);
		//System.out.println(diffDay+"일");
		return diffDay;
	}
	

	
}
