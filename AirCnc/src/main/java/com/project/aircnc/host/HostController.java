package com.project.aircnc.host;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.project.aircnc.common.BuildTypeVO;
import com.project.aircnc.common.CheckInOutVO;
import com.project.aircnc.common.DTLRuleVO;
import com.project.aircnc.common.FaciliteVO;
import com.project.aircnc.common.GestSpaceVO;
import com.project.aircnc.common.HostUserVO;
import com.project.aircnc.common.HostingPkVO;
import com.project.aircnc.common.RoomFeeVO;
import com.project.aircnc.common.RoomIMGVO;
import com.project.aircnc.common.RoomRuleVO;
import com.project.aircnc.common.Room_Dt_RuleVO;
import com.project.aircnc.common.SafePlantVO;
import com.project.aircnc.common.SpaceInfoVO;
import com.project.aircnc.common.WorkplacePhVO;


@Controller
@RequestMapping("/host")
public class HostController {
	
	@Autowired
	HostService service;
	// 숙소 등록  페이지  
	@RequestMapping(value = "/hosting", method = RequestMethod.GET)
	public String hosting (HttpSession hs, Model model) {
		// 등록중 숙소 
		model.addAttribute("data1", service.selHosting(hs));
		// 등록 완료 숙소 
		model.addAttribute("data2", service.selComplHosting(hs));
		return "/host/hosting";
	}
	// 숙소 등록중 수정 페이지 
	@RequestMapping(value = "/duplicate", method = RequestMethod.GET)
	public String duplicate(HostingPkVO param,HttpSession hs, Model model) {
		
		model.addAttribute("data", service.getDuplicate(param,hs));
		return "/host/duplicate";
	}
	
	
	
	// 숙소 등록 1단계 get 방식 
	@RequestMapping(value = "/hostSave", method = RequestMethod.GET)
	public String save (HostUserVO param,HttpSession hs, Model model) {
		model.addAttribute("vo",service.selHostUserVO(param));
		return "host/hostSave";
	}
	
	@RequestMapping(value = "/hostSaveOne", method = RequestMethod.GET)
	public String saveOneGET (BuildTypeVO param,HttpSession hs, Model model) {
		model.addAttribute("vo",service.selBuildType(param));
		model.addAttribute("i_host",param.getI_host());
		return "host/hostSaveOne";
	}
	
	//등록 1단계 - > 2단계
	@RequestMapping(value = "/hostSaveOne", method = RequestMethod.POST)
	public String saveOne (HostUserVO param,HttpSession hs, Model model) {
		switch(param.getI_host()) {
		// insert
		case 0:
			model.addAttribute("i_host",service.insHostSaveOne(param));
			break;
		default : // update
			int reult = service.upHostSaveOne(param);
			model.addAttribute("i_host",param.getI_host());
			BuildTypeVO vo = new BuildTypeVO();
			vo.setI_host(param.getI_host());
			vo.setI_user(param.getI_user());
			model.addAttribute("vo",service.selBuildType(vo));
			break;
		}
		
		return "host/hostSaveOne";
	}

	//숙소 등록 2단계 - > 3단계 get 방식 
	@RequestMapping(value = "/hostSaveTwo", method = RequestMethod.GET)
	public String saveTwoGET (FaciliteVO param1,SafePlantVO param2,HttpSession hs, Model model) {
		model.addAttribute("vo1",service.selFacilite(param1));
		model.addAttribute("vo2",service.selSafePlant(param2));
		model.addAttribute("i_host",param1.getI_host());
		return "host/hostSaveTwo";
	}
	
	//등록 2단계 - > 3단계
	@RequestMapping(value = "/hostSaveTwo", method = RequestMethod.POST)
	public String saveTwo (BuildTypeVO param,HttpSession hs, Model model) {
		
		FaciliteVO param1 = new FaciliteVO();
		SafePlantVO param2 = new SafePlantVO();
		param1.setI_host(param.getI_host());
		param2.setI_host(param.getI_host());
		param1.setI_user(param.getI_user());
		param2.setI_user(param.getI_user());
		
		model.addAttribute("vo1",service.selFacilite(param1));
		model.addAttribute("vo2",service.selSafePlant(param2));
		
		int result = 0;
		switch(param.getI_build()) {
		case 0: // BuildType insert
			result = service.insHostSaveTwo(param);
			break;
		default : // BuildType update
			result = service.upBuildType(param);
			break;
		}
		model.addAttribute("i_host",param.getI_host());
		
		return "host/hostSaveTwo";
	}
	
	//숙소 등록 2단계 - > 3단계 get 방식 
	@RequestMapping(value = "/hostSaveThree", method = RequestMethod.GET)
	public String saveThreeGET (GestSpaceVO param,HttpSession hs, Model model) {
		model.addAttribute("vo",service.selGestSpace(param));
		model.addAttribute("i_host",param.getI_host());
		return "host/hostSaveThree";
	}
	
	//등록 3단계 - > 4단계
	@RequestMapping(value = "/hostSaveThree", method = RequestMethod.POST)
	public String saveThree (FaciliteVO param1,SafePlantVO param2 ,HttpSession hs, Model model) {
		
		GestSpaceVO param = new GestSpaceVO();
		param.setI_host(param1.getI_host());
		//  GestSpace 데이터 가지고 오기 
		model.addAttribute("vo",service.selGestSpace(param));
		
		int result = 0;
		if(param1.getI_fct() == 0) {
			result = service.insHostSaveThree(param1); // insert
		}else {
			result = service.upFacilite(param1); //update
		}
		if(param2.getI_spt() == 0) {
			result = service.insHostSaveThree1(param2); //insert
		}else {
			result = service.upSafePlant(param2); // update
		}
		model.addAttribute("i_host",param1.getI_host());
		return "host/hostSaveThree";
	}
	
	@RequestMapping(value = "/hostSaveFour", method = RequestMethod.GET)
	public String saveThreeGet(SpaceInfoVO param ,HttpSession hs, Model model) {
		model.addAttribute("vo",service.selSpaceInfo(param));
		model.addAttribute("i_host",param.getI_host());
		return "host/hostSaveFour";
	}
	
	// 등록 4단계 - > 5단계
	@RequestMapping(value = "/hostSaveFour", method = RequestMethod.POST)
	public String saveFour (GestSpaceVO param,HttpSession hs, Model model) {
		SpaceInfoVO param1 = new SpaceInfoVO();
		param1.setI_host(param.getI_host());
		model.addAttribute("vo",service.selSpaceInfo(param1));
		int result = 0;
		switch(param.getI_gest()) {
		case 0:
			result = service.insHostSaveFour(param); //insert
			break;
		default :
			result = service.upGestSpace(param); // update
			break;
		}
		
		model.addAttribute("i_host",param.getI_host());
		return "host/hostSaveFour";
	}
	
	//등록 5단계 - > 6단계  GET 방식 
	@RequestMapping(value = "/hostSaveFive", method = RequestMethod.GET)
	public String saveFiveGet(DTLRuleVO param1,RoomRuleVO param2,Room_Dt_RuleVO param3,
			HttpSession hs, Model model)	
	{
		model.addAttribute("vo1",service.selDTLRule(param1));
		model.addAttribute("vo2",service.selRoomRule(param2));
		model.addAttribute("vo3",service.selRoom_Dt_Rule(param3));
		model.addAttribute("i_host",param1.getI_host());
		return "host/hostSaveFive";
	}
	//등록 5단계 - > 6단계
	@RequestMapping(value = "/hostSaveFive", method = RequestMethod.POST)
	public String saveFive (SpaceInfoVO param,HttpSession hs, Model model) {
		DTLRuleVO param1 		= new DTLRuleVO();
		RoomRuleVO param2		= new RoomRuleVO();
		Room_Dt_RuleVO param3	= new Room_Dt_RuleVO();
		param1.setI_host(param.getI_host());
		param2.setI_host(param.getI_host());
		param3.setI_host(param.getI_host());
		
		model.addAttribute("vo1",service.selDTLRule(param1));
		model.addAttribute("vo2",service.selRoomRule(param2));
		model.addAttribute("vo3",service.selRoom_Dt_Rule(param3));
		
		
		int result = 0;
		switch(param.getI_sinfo()) {
		case 0:
			result = service.insHostSaveFive(param); // insert
			break;
		default :
			result = service.upSpaceInfo(param); // update
			break;
		}
		model.addAttribute("i_host",param.getI_host());
		return "host/hostSaveFive";
	}
	
	// DTLRuleVO 저장 비동기 
	@RequestMapping(value = "/insDtlRule", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> insDtlRule(@RequestParam String rule,
			@RequestParam int i_host,HttpSession hs){
		Map<String, Object> map = new HashMap();
		map.put("result", service.insDtlRule( rule,i_host,hs));
		
		return map;
	}
	// DTLRuleVO 삭제 비동기 
	@RequestMapping(value = "/delDtlRule", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> delDtlRule(@RequestParam int i_drule, HttpSession hs){
		Map<String, Object> map = new HashMap();
		map.put("result", service.delDtlRule(i_drule));
		return map;
	}
	//등록 6단계 - > 7단계 GET 방식
	@RequestMapping(value = "/hostSaveSix", method = RequestMethod.GET)
	public String saveSixGet(CheckInOutVO param, HttpSession hs, Model model) {
		
		model.addAttribute("vo",service.selCheckInOut(param));
		model.addAttribute("i_host",param.getI_host());
		
		return "host/hostSaveSix";
	}
	//등록 6단계 - > 7단계
	@RequestMapping(value = "/hostSaveSix", method = RequestMethod.POST)
	public String saveSix (RoomRuleVO param1, Room_Dt_RuleVO param2, HttpSession hs, Model model) {
		CheckInOutVO param = new CheckInOutVO();
		param.setI_host(param1.getI_host());
		model.addAttribute("vo",service.selCheckInOut(param));
		int restult =0;
		if(param1.getI_rule() == 0) {
			restult = service.insRoomRule(param1); // insert
		}else {
			restult = service.upRoomRule(param1); // update
		}
		if(param2.getI_dtr() == 0) {
			restult = service.insRoom_Dt_Rule(param2); // insert
		}else {
			restult = service.upRoom_Dt_Rule(param2); // update
		}
		model.addAttribute("i_host",param1.getI_host());
		
		return "host/hostSaveSix";
	}
	//등록 7단계 - > 8단계 GET 방식 
	@RequestMapping(value = "/hostSaveSeven", method = RequestMethod.GET)
	public String saveSevenGet (RoomFeeVO param,HttpSession hs, Model model) {
		model.addAttribute("vo",service.selRoomFee(param));
		model.addAttribute("i_host",param.getI_host());
		return "host/hostSaveSeven";
	}
	//등록 7단계 - > 8단계
	@RequestMapping(value = "/hostSaveSeven", method = RequestMethod.POST)
	public String saveSeven (CheckInOutVO param, HttpSession hs, Model model) {
		int result = 0;
		RoomFeeVO param1 = new RoomFeeVO();
		param1.setI_host(param.getI_host());
		model.addAttribute("vo",service.selRoomFee(param1));
		
		switch(param.getI_ck()) {
		case 0 :
			result = service.insCheckInOut(param); // insert
			break;
		default :
			result = service.upCheckInOut(param); // update
			break;
		}
		model.addAttribute("i_host",param.getI_host());
		
		return "host/hostSaveSeven";
	}
	//등록 8단계 - > 9단계 GET 방식
	@RequestMapping(value = "/hostSaveEight", method = RequestMethod.GET)
	public String saveEightGet (WorkplacePhVO param, HttpSession hs, Model model) {
		model.addAttribute("vo",service.selWorkplacePh(param));
		model.addAttribute("i_host",param.getI_host());
		return "host/hostSaveEight";
	}
	
	//등록 8단계 - > 9단계
	@RequestMapping(value = "/hostSaveEight", method = RequestMethod.POST)
	public String saveEight (RoomFeeVO param, HttpSession hs, Model model) {
		WorkplacePhVO param1 = new WorkplacePhVO();
		param1.setI_host(param.getI_host());
		model.addAttribute("vo",service.selWorkplacePh(param1));
		
		int result =0;
		
		switch(param.getI_fee()) {
		case 0 :
			result = service.insRoomFee(param); // insert
			break;
		default:
			result = service.upRoomFee(param); //update
			break;
		}
		
		model.addAttribute("i_host",param.getI_host());
		
		return "host/hostSaveEight";
	}
	//등록 9단계 - > 10단계(마지막 숙소 이미지) GET 방식
	@RequestMapping(value = "/hostSaveNine", method = RequestMethod.GET)
	public String saveNineGet (RoomIMGVO param, HttpSession hs, Model model) {
		model.addAttribute("vo",service.selRoomIMG(param,hs));
		model.addAttribute("i_host",param.getI_host());
		return "/host/hostSaveNine";
	}
	//등록 9단계 - > 10단계(마지막 숙소 이미지)
	@RequestMapping(value = "/hostSaveNine", method = RequestMethod.POST)
	public String saveNine (WorkplacePhVO param, HttpSession hs, Model model) {
		int result = 0;
		
		RoomIMGVO param1 = new RoomIMGVO();
		param1.setI_host(param.getI_host());
		model.addAttribute("vo",service.selRoomIMG(param1,hs));
		
		switch(param.getI_ph()) {
		case 0:
			result = service.inWorkplacePh(param); //insert
			break;
		default:
			result = service.upWorkplacePh(param); // update
			break;
		}
		
		model.addAttribute("i_host",param.getI_host());
		
		return "/host/hostSaveNine";
	}
	
	@RequestMapping(value = "/hostLast", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveLast(@RequestParam("photo")  MultipartFile photo, 
			@RequestParam("i_host") int i_host,HttpSession hs, Model model) {
		Map<String, Object> map = new HashMap();
		if(!photo.isEmpty()) {
			int reuslt = service.insRoomImg(photo,i_host ,hs);
			RoomIMGVO data = service.getRoomImg(i_host ,hs);
			map.put("result", data);
		}
		
		return map;
	}
	
	@RequestMapping(value = "/delRoomImg", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> delRoomImg(@RequestParam int i_host,
			@RequestParam int i_img, @RequestParam int i_user,  HttpSession hs, Model model) {
		
		Map<String, Object> map = new HashMap();
		map.put("result", service.delRoomImg(i_host, i_user, i_img, hs));
		
		return map;
	}
	// 숙소 지우기 
	@RequestMapping(value="/delHost", method=RequestMethod.GET)
	public String delHost(RoomIMGVO param,HttpSession hs, Model model) {
			int result = service.delHost(param,hs);
		return "redirect:/host/hosting";
	}
	
}
