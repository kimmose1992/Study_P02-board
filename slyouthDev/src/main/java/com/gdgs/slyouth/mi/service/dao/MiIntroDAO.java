package com.gdgs.slyouth.mi.service.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gdgs.slyouth.cm.service.dao.AbstractDAO;
import com.gdgs.slyouth.mi.vo.MiIntroDVO;

/**
 * @title	: 교회소개(메인) 화면 DAO 클래스	
 * @author	: gypig
 * @create	: 2021.06.16
 */
@Component
@Repository("miIntroDAO")
public class MiIntroDAO extends AbstractDAO { 
	
	private static final String NAMESPACE = "mi.intro.";
	
	/**
	 * @title   : 교회소개(메인) 화면 조회   
	 * @method  : selectIntroMain()    
	 * @comment : 소개 메인 화면에 글을 조회한다.
	 * @param   : N/A
	 */
	public MiIntroDVO selectIntroMain() {
		
		return (MiIntroDVO) select(NAMESPACE+"selectMainIntro");
		
	}
	
	/**
	 * @title	: 교회소개(메인) 화면 수정 완료
	 * @method	: updateIntroMain()
	 * @comment	: 교회 소개 메인 수정을 한 뒤에 DB에 갖다옵니다.
	 * @param	: MiIntroDVO
	 */
	public int updateIntroMain(MiIntroDVO miIntroDVO) {
		
		  return (int) update(NAMESPACE+"updateMainIntro",miIntroDVO);
	}
	
	/**
	 * @title	: 인사말 메인  
	 * @method	: greeting()
	 * @comment	: 소개구분코드가 GRT(인사말)를 조회합니다.		 
	 * @param	: N/A
	 */
	public MiIntroDVO greetingView() {
		
		return (MiIntroDVO) select(NAMESPACE + "greeting");
	}
	
	/**
	 * @title	: 인사말 수정  
	 * @method	: greetingUpdate()
	 * @comment	: 인사말을 수정합니다.		 
	 * @param	: MiIntroDVO
	 */
	public int greetingUpdate(MiIntroDVO miIntroDVO) {
		
		return (int) update(NAMESPACE+"greetingUpdate",miIntroDVO);
	}
	
	/**
	 * @title	: 예배안내 정보 조회 
	 * @method	: selectWorshipInfo()
	 * @comment	: 예배안내 정보를 조회한다.	 
	 * @param	: N/A
	 */
	public MiIntroDVO selectWorshipInfo() {
		return (MiIntroDVO) select(NAMESPACE + "selectWorshipInfo");
	}
	
	/**
	 * @title	: 예배안내 수정
	 * @method	: worshipInfoUpdate()
	 * @comment	: 예배안내를 수정합니다.		 
	 * @param	: MiIntroDVO
	 */
	public int worshipInfoUpdate(MiIntroDVO miIntroDVO) {
		
		return (int) update(NAMESPACE + "worshipInfoUpdate", miIntroDVO);
	}

	/**
	 * @title	: 새가족반소개 기본정보 조회  
	 * @method	: selectNewcomerInfo
	 * @comment	: 새가족반소개 기본정보를 가져온다.
	 * @param	: miIntroDVO
	 */
	public MiIntroDVO selectNewcomerInfo(MiIntroDVO miIntroDVO) {
		return (MiIntroDVO) select(NAMESPACE + "selectNewcomerInfo", miIntroDVO);
	}
}
