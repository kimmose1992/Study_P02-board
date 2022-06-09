package com.gdgs.slyouth.mi.vo;

import java.util.List;

import com.gdgs.slyouth.nt.vo.NtNoticeDVO;

/**
 * @title    : 소개 메인 SVO 클래스      
 * @author   : 신지현
 * @create   : 2021.05.25
 */
public class MiIntroSVO {

   // 메인소개 VO
   private MiIntroDVO miIntroDVO;
   
   // 공지사항 리스트 가져오기
   private List<NtNoticeDVO> ntList;
   
public List<NtNoticeDVO> getNtList() {
	return ntList;
}

public void setNtList(List<NtNoticeDVO> ntList) {
	this.ntList = ntList;
}

public MiIntroDVO getMiIntroDVO() {
      return miIntroDVO;
   }

   public void setMiIntroDVO(MiIntroDVO miIntroDVO) {
      this.miIntroDVO = miIntroDVO;
   }
}
