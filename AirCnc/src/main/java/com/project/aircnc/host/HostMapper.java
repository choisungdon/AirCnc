package com.project.aircnc.host;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;

import com.project.aircnc.common.BuildTypeVO;
import com.project.aircnc.common.CheckHostingVO;
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

@Mapper
public interface HostMapper {
	// select
	public List<CheckHostingVO> selHosting(CheckHostingVO param);
	public List<CheckHostingVO> selComplHosting(CheckHostingVO param);
	public HostingPkVO getDuplicate(HostingPkVO param);
	public HostUserVO selHostUserVO(HostUserVO param);
	public int getI_Host(HostUserVO param);
	public BuildTypeVO selBuildType(BuildTypeVO param);
	public FaciliteVO selFacilite(FaciliteVO param);
	public SafePlantVO selSafePlant(SafePlantVO param);
	public GestSpaceVO selGestSpace(GestSpaceVO param);
	public SpaceInfoVO selSpaceInfo(SpaceInfoVO param);
	public List<DTLRuleVO> selDTLRule(DTLRuleVO param);
	public RoomRuleVO selRoomRule(RoomRuleVO param);
	public Room_Dt_RuleVO selRoom_Dt_Rule(Room_Dt_RuleVO param);
	public CheckInOutVO selCheckInOut(CheckInOutVO param);
	public RoomFeeVO selRoomFee(RoomFeeVO param);
	public WorkplacePhVO selWorkplacePh(WorkplacePhVO param);
	public List<RoomIMGVO> selRoomIMG(RoomIMGVO param);
	// insert 
	public int insHostSaveOne(HostUserVO param);
	public int insHostSaveTwo(BuildTypeVO param);
	public int insHostSaveThree(FaciliteVO param);
	public int insHostSaveThree1(SafePlantVO param);
	public int insHostSaveFour(GestSpaceVO param);
	public int insHostSaveFive(SpaceInfoVO param);
	public int insRoomRule(RoomRuleVO param);
	public int insRoom_Dt_Rule(Room_Dt_RuleVO param); 
	public int insCheckInOut(CheckInOutVO param);
	public int insRoomFee(RoomFeeVO param);
	public int inWorkplacePh(WorkplacePhVO param);
	
	//update 
	public int upHostSaveOne(HostUserVO param);
	public int upBuildType(BuildTypeVO param);
	public int upFacilite(FaciliteVO param);
	public int upSafePlant(SafePlantVO param);
	public int upGestSpace(GestSpaceVO param);
	public int upSpaceInfo(SpaceInfoVO param);
	public int upRoomRule(RoomRuleVO param);
	public int upRoom_Dt_Rule(Room_Dt_RuleVO param);
	public int upCheckInOut(CheckInOutVO param);
	public int upRoomFee(RoomFeeVO param);
	public int upWorkplacePh(WorkplacePhVO param);
	// delete 
	public int delHost(RoomIMGVO param);
	// 숙소 사진
	public int insRoomImg(RoomIMGVO param); // 숙소 이미지  저장 
	public RoomIMGVO getRoomImg(RoomIMGVO param); // 최근 업로드 이미지 출력 
	public RoomIMGVO delGetImg(RoomIMGVO param);
	public int delRoomImg(RoomIMGVO param);// 해당 숙소 이미지 삭제 
	// 추가 규칙 
	public int insDtlRule(DTLRuleVO param); 
	public DTLRuleVO lastDtlRule(DTLRuleVO param);
	public int delDtlRule(DTLRuleVO param);
	
	// 저장 이미지 하나 출력 
	public RoomIMGVO selRoomOne(int i_img);
}
