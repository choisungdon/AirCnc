package com.project.aircnc.host;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.aircnc.common.BuildTypeVO;
import com.project.aircnc.common.CheckHostingVO;
import com.project.aircnc.common.CheckInOutVO;
import com.project.aircnc.common.DTLRuleVO;
import com.project.aircnc.common.FaciliteVO;
import com.project.aircnc.common.GestSpaceVO;
import com.project.aircnc.common.HostUserVO;
import com.project.aircnc.common.HostingPkVO;
import com.project.aircnc.common.MyUtils;
import com.project.aircnc.common.RoomFeeVO;
import com.project.aircnc.common.RoomIMGVO;
import com.project.aircnc.common.RoomRuleVO;
import com.project.aircnc.common.Room_Dt_RuleVO;
import com.project.aircnc.common.SafePlantVO;
import com.project.aircnc.common.SpaceInfoVO;
import com.project.aircnc.common.TUserVO;
import com.project.aircnc.common.WorkplacePhVO;

@Service
public class HostService {
	@Autowired
	HostMapper mapper;

	// select
	// 숙소 등록된 pk들 출력
	public HostingPkVO getDuplicate(HttpSession hs,int i_host) {
		//로그인 정보 출력 
		TUserVO loginUser = (TUserVO) hs.getAttribute("loginUser");
		// 숙소 pk i_host, 유저 pk i_user 삽입 
		HostingPkVO param = new HostingPkVO();
		param.setI_host(i_host);
		param.setI_user(loginUser.getI_user());
		
//		HostingPkVO tset = mapper.getDuplicate(param);
//		System.out.println("-> "+tset.toString());

		return mapper.getDuplicate(param);
	}

	// 등록중 숙소 select
	public List<CheckHostingVO> selHosting(HttpSession hs) {
		// user pk 받아오기
		CheckHostingVO param = new CheckHostingVO();
		param.setI_user(MyUtils.getSesstion(hs));
		// 숙소 이미지 경로 변경
		List<CheckHostingVO> list = mapper.selHosting(param);
		for (CheckHostingVO checkHostingVO : list) {
			checkHostingVO.setImg_url(imgUrlChange(checkHostingVO.getImg_url(), checkHostingVO.getI_host()));

		}

		return list;
	}

	// 등록 완료 숙소 select
	public List<CheckHostingVO> selComplHosting(HttpSession hs) {
		// user pk 받아오기
		CheckHostingVO param = new CheckHostingVO();
		param.setI_user(MyUtils.getSesstion(hs));

		// 숙소 이미지 경로 변경
		List<CheckHostingVO> list = mapper.selComplHosting(param);
		for (CheckHostingVO checkHostingVO : list) {
			checkHostingVO.setImg_url(imgUrlChange(checkHostingVO.getImg_url(), checkHostingVO.getI_host()));

		}

		return list;
	}

	public HostUserVO selHostUserVO(HostUserVO param) {
		HostUserVO vo = mapper.selHostUserVO(param);
		// add 국가이름 지우기
		if (vo != null) {
			String addr = vo.getAddr();
			addr = addr.replaceAll(vo.getCountry() + " ", "");
			vo.setAddr(addr);
		}
		return vo;
	}

	public BuildTypeVO selBuildType(BuildTypeVO param) {
		return mapper.selBuildType(param);
	}

	public FaciliteVO selFacilite(FaciliteVO param) {
		return mapper.selFacilite(param);
	}

	public SafePlantVO selSafePlant(SafePlantVO param) {
		return mapper.selSafePlant(param);
	}

	public GestSpaceVO selGestSpace(GestSpaceVO param) {
		return mapper.selGestSpace(param);
	}

	public SpaceInfoVO selSpaceInfo(SpaceInfoVO param) {
		return mapper.selSpaceInfo(param);
	}

	public List<DTLRuleVO> selDTLRule(DTLRuleVO param) {
		return mapper.selDTLRule(param);
	}

	public RoomRuleVO selRoomRule(RoomRuleVO param) {
		return mapper.selRoomRule(param);
	}

	public Room_Dt_RuleVO selRoom_Dt_Rule(Room_Dt_RuleVO param) {
		return mapper.selRoom_Dt_Rule(param);
	}

	public CheckInOutVO selCheckInOut(CheckInOutVO param) {
		return mapper.selCheckInOut(param);
	}

	public RoomFeeVO selRoomFee(RoomFeeVO param) {
		return mapper.selRoomFee(param);
	}

	public WorkplacePhVO selWorkplacePh(WorkplacePhVO param) {
		return mapper.selWorkplacePh(param);
	}

	public List<RoomIMGVO> selRoomIMG(RoomIMGVO param, HttpSession hs) {

		TUserVO loginUser = (TUserVO) hs.getAttribute("loginUser");
		param.setI_user(loginUser.getI_user());

		List<RoomIMGVO> vo = mapper.selRoomIMG(param);
		// URL 수정
		for (RoomIMGVO roomIMGVO : vo) {
			String img_url = "/resources/room_img/host" + param.getI_host() + "/" + roomIMGVO.getImg_url();
			roomIMGVO.setImg_url(img_url);
		}
		return vo;
	}

/// insert
	public int insHostSaveOne(HostUserVO param, HttpSession hs) {
		// 국가 + 주소 숙소 전체 주소 수정
		param.setAddr(param.getCountry() + " " + param.getAddr());
		// insert 성공 , 실패 유무 확인
		int result = mapper.insHostSaveOne(param);
		if (result > 0) {
			// 숙소 정보 등록 성공시 숙소 정보 pk들 세션에 갱신
			HostingPkVO hostingPkVo = getDuplicate(hs,param.getI_host());
			hs.setAttribute("hostingPkVo", hostingPkVo);
		}
		return mapper.getI_Host(param);
	}

	public int insHostSaveTwo(BuildTypeVO param, HttpSession hs) {
		// 숙소 정보 등록 성공시 숙소 정보 pk들 세션에 갱신
		HostingPkVO hostingPkVo = getDuplicate(hs,param.getI_host());
		hs.setAttribute("hostingPkVo", hostingPkVo);
		return mapper.insHostSaveTwo(param);
	}

	public int insHostSaveThree(FaciliteVO param, HttpSession hs) {
		// 숙소 정보 등록 성공시 숙소 정보 pk들 세션에 갱신
		HostingPkVO hostingPkVo = getDuplicate(hs,param.getI_host());
		hs.setAttribute("hostingPkVo", hostingPkVo);
		return mapper.insHostSaveThree(param);
	}

	public int insHostSaveThree1(SafePlantVO param, HttpSession hs) {
		// 숙소 정보 등록 성공시 숙소 정보 pk들 세션에 갱신
		HostingPkVO hostingPkVo = getDuplicate(hs,param.getI_host());
		hs.setAttribute("hostingPkVo", hostingPkVo);
		return mapper.insHostSaveThree1(param);
	}

	public int insHostSaveFour(GestSpaceVO param, HttpSession hs) {
		// 숙소 정보 등록 성공시 숙소 정보 pk들 세션에 갱신
		HostingPkVO hostingPkVo = getDuplicate(hs,param.getI_host());
		hs.setAttribute("hostingPkVo", hostingPkVo);
		return mapper.insHostSaveFour(param);
	}

	public int insHostSaveFive(SpaceInfoVO param, HttpSession hs) {

		// 문자열 치환
		param.setExpa(MyUtils.getSTRFilter(param.getExpa()));
		param.setLoca_info(MyUtils.getSTRFilter(param.getLoca_info()));
		param.setRoom_info(MyUtils.getSTRFilter(param.getRoom_info()));
		param.setTraf_info(MyUtils.getSTRFilter(param.getTraf_info()));

		// 숙소 정보 등록 성공시 숙소 정보 pk들 세션에 갱신
		HostingPkVO hostingPkVo = getDuplicate(hs,param.getI_host());
		hs.setAttribute("hostingPkVo", hostingPkVo);

		return mapper.insHostSaveFive(param);
	}

	public int insRoomRule(RoomRuleVO param, HttpSession hs) {
		// 숙소 정보 등록 성공시 숙소 정보 pk들 세션에 갱신
		HostingPkVO hostingPkVo = getDuplicate(hs,param.getI_host());
		hs.setAttribute("hostingPkVo", hostingPkVo);
		return mapper.insRoomRule(param);
	}

	public int insRoom_Dt_Rule(Room_Dt_RuleVO param, HttpSession hs) {
		// 숙소 정보 등록 성공시 숙소 정보 pk들 세션에 갱신
		HostingPkVO hostingPkVo = getDuplicate(hs,param.getI_host());
		hs.setAttribute("hostingPkVo", hostingPkVo);
		return mapper.insRoom_Dt_Rule(param);
	}

	public int insCheckInOut(CheckInOutVO param, HttpSession hs) {
		// 숙소 정보 등록 성공시 숙소 정보 pk들 세션에 갱신
		HostingPkVO hostingPkVo = getDuplicate(hs,param.getI_host());
		hs.setAttribute("hostingPkVo", hostingPkVo);
		return mapper.insCheckInOut(param);
	}

	public int insRoomFee(RoomFeeVO param, HttpSession hs) {
		// 숙소 정보 등록 성공시 숙소 정보 pk들 세션에 갱신
		HostingPkVO hostingPkVo = getDuplicate(hs,param.getI_host());
		hs.setAttribute("hostingPkVo", hostingPkVo);
		return mapper.insRoomFee(param);
	}

	public int inWorkplacePh(WorkplacePhVO param, HttpSession hs) {
		// 숙소 정보 등록 성공시 숙소 정보 pk들 세션에 갱신
		HostingPkVO hostingPkVo = getDuplicate(hs,param.getI_host());
		hs.setAttribute("hostingPkVo", hostingPkVo);
		return mapper.inWorkplacePh(param);
	}

	// ******************* update ****************//
	public int upHostSaveOne(HostUserVO param) {
		param.setAddr(param.getCountry() + " " + param.getAddr());
		return mapper.upHostSaveOne(param);
	}

	public int upBuildType(BuildTypeVO param) {
		return mapper.upBuildType(param);
	}

	public int upFacilite(FaciliteVO param) {
		return mapper.upFacilite(param);
	}

	public int upSafePlant(SafePlantVO param) {
		return mapper.upSafePlant(param);
	}

	public int upGestSpace(GestSpaceVO param) {
		return mapper.upGestSpace(param);
	}

	public int upSpaceInfo(SpaceInfoVO param) {
		// 문자열 치환
		param.setExpa(MyUtils.getSTRFilter(param.getExpa()));
		param.setLoca_info(MyUtils.getSTRFilter(param.getLoca_info()));
		param.setRoom_info(MyUtils.getSTRFilter(param.getRoom_info()));
		param.setTraf_info(MyUtils.getSTRFilter(param.getTraf_info()));

		return mapper.upSpaceInfo(param);
	}

	public int upRoomRule(RoomRuleVO param) {
		return mapper.upRoomRule(param);
	}

	public int upRoom_Dt_Rule(Room_Dt_RuleVO param) {
		return mapper.upRoom_Dt_Rule(param);
	}

	public int upCheckInOut(CheckInOutVO param) {
		return mapper.upCheckInOut(param);
	}

	public int upRoomFee(RoomFeeVO param) {
		return mapper.upRoomFee(param);
	}

	public int upWorkplacePh(WorkplacePhVO param) {
		return mapper.upWorkplacePh(param);
	}
	// 숙소 delete

	public int delHost(RoomIMGVO param, HttpSession hs) {
		TUserVO loginUser = (TUserVO) hs.getAttribute("loginUser");
		param.setI_user(loginUser.getI_user());

		List<RoomIMGVO> vo = mapper.selRoomIMG(param);
		// 숙소 사진 지우기
		for (RoomIMGVO roomIMGVO : vo) {
			String realPath = hs.getServletContext().getRealPath("/");
			String imgFolder = realPath + "/resources/room_img/host" + roomIMGVO.getI_user();
			// 해당 이미지가 있으면 삭제 처리
			if (!"".equals(param.getImg_url())) {
				String imgPath = imgFolder + "/" + roomIMGVO.getImg_url();
				MyUtils.deleteFile(imgPath);
			}
		}

		return mapper.delHost(param);
	}

	// 추가 규칙 insert delete
	public DTLRuleVO insDtlRule(String rule, int i_host, HttpSession hs) {
		DTLRuleVO param = new DTLRuleVO();
		TUserVO loginUser = (TUserVO) hs.getAttribute("loginUser");
		// 저장 할 데이터
		param.setI_user(loginUser.getI_user());
		param.setI_host(i_host);
		param.setRule(rule);
		// db 저장
		mapper.insDtlRule(param);
		// 저장한 값
		return mapper.lastDtlRule(param);
	}

	public int delDtlRule(int i_drule) {
		DTLRuleVO param = new DTLRuleVO();
		param.setI_drule(i_drule);
		return mapper.delDtlRule(param);
	}
	/////////////

	// 숙소 사진 insert delete select
	public RoomIMGVO getRoomImg(int i_host, HttpSession hs) {
		RoomIMGVO param = new RoomIMGVO();// mapper로 보낼 데이터
		String profileImg = null;
		TUserVO loginUser = (TUserVO) hs.getAttribute("loginUser");// 유저 정보
		param.setI_host(i_host);// 숙소 pk
		param.setI_user(loginUser.getI_user()); // 유저 pk

		param = mapper.getRoomImg(param);// 이미지 파일 이름
		// 이미지 URL 변경
		profileImg = "/resources/room_img/host" + i_host + "/" + param.getImg_url();
		param.setImg_url(profileImg);

		return param;// 이미지 return
	}

	public RoomIMGVO insRoomImg(MultipartFile photo, int i_host, HttpSession hs) {
		RoomIMGVO param = new RoomIMGVO(); // mapper로 보낼 데이터

		TUserVO loginUser = (TUserVO) hs.getAttribute("loginUser"); // 유저 정보
		param.setI_host(i_host);// 숙소 pk
		param.setI_user(loginUser.getI_user());// 유저 pk

		String realPath = hs.getServletContext().getRealPath("/"); // 루트 절대경로 가져오기
		String imgFolder = realPath + "/resources/room_img/host" + i_host;// 서버에 저장할 파일

		String fileNm = MyUtils.saveFile(imgFolder, photo);// 이미지 저장 및 폴더 생성
		param.setImg_url(fileNm);// 파일 이름

		int result = 0;
		result = mapper.insRoomImg(param);
		if (result > 0) { // 저장 성공 했으면 해당 이미지 정보 가져오기
			param = mapper.selRoomOne(param.getI_img());
			param.setImg_url(imgUrlChange(param.getImg_url(), param.getI_host()));
		}
		return param;
	}

	public int delRoomImg(int i_host, int i_img, HttpSession hs) {

		RoomIMGVO param = new RoomIMGVO();
		param.setI_host(i_host); // 숙소 pk
		param.setI_user(MyUtils.getSesstion(hs)); // 유저 pk
		param.setI_img(i_img); // 이미지 pk
		// db 파일 이름 저장
		param = mapper.delGetImg(param);
		// 루트 절대경로 가져오기
		String realPath = hs.getServletContext().getRealPath("/");
		String imgFolder = realPath + "/resources/room_img/host" + i_host;

		// 기존 이미지가 있으면 삭제 처리
		if (!"".equals(param.getImg_url())) {
			String imgPath = imgFolder + "/" + param.getImg_url();
			MyUtils.deleteFile(imgPath);
		}
		// db 이미지 삭제
		return mapper.delRoomImg(param);
	}
	//

	// 숙소 이미지 경로 지정
	public String imgUrlChange(String url, int i_host) {

		String room_poto = "/resources/room_img/host" + i_host + "/" + url;
		if (url == null || url.equals("")) { // 이미지 파일이 없으면 기본 이미지 출력
			room_poto = "/resources/room_img/roomDfault.png";
		}
		return room_poto;
	}

}
