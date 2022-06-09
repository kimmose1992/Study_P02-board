package com.gdgs.slyouth.cm.service.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gdgs.slyouth.cm.vo.CmVideoDVO;

/**
 * @title   : [공통] 영상관리 DAO 클래스     
 * @author  : gypig
 * @create  : 2021.06.16
 */
@Component
@Repository("cmVideoDAO")
public class CmVideoDAO extends AbstractDAO{
	
	private static final String NAMESPACE = "cm.video.";
	
	/**
	 * @title   : 영상 등록     
	 * @method  : insertVideo()    
	 * @comment : DB에 영상을 등록합니다.  
	 * @param   : CmVideoDVO
	 */
	public int insertVideo(CmVideoDVO cmVideoDVO) {
		return (int) insert(NAMESPACE + "insertVideo", cmVideoDVO);
	}
	
	/**
	 * @title   : 영상 수정     
	 * @method  : updateVideo()    
	 * @comment : DB에 영상을 등록합니다.  
	 * @param   : CmVideoDVO
	 */
	public int updateVideo(CmVideoDVO cmVideoDVO) {
		return (int) update(NAMESPACE + "updateVideo", cmVideoDVO);
	}
	
	/**
	 * @title   : 영상 삭제    
	 * @method  : deleteVideo()    
	 * @comment : DB에 영상을 등록합니다.  
	 * @param   : CmVideoDVO
	 */
	public int deleteVideo(CmVideoDVO cmVideoDVO) {
		return (int) update(NAMESPACE + "deleteVideo", cmVideoDVO);
	}
	
	/**
	 * @title   : 영상 단건 조회    
	 * @method  : selectVideo()    
	 * @comment : DB에서 영상 1건을 조회합니다.  
	 * @param   : CmVideoDVO
	 */
	public CmVideoDVO selectVideo(CmVideoDVO cmVideoDVO) {
		return (CmVideoDVO) select(NAMESPACE + "selectVideo", cmVideoDVO);
	}
	
	/**
	 * @title   : 영상 리스트 조회    
	 * @method  : selectVideoList()    
	 * @comment : DB에서 영상 리스트를 조회합니다.  
	 * @param   : CmVideoDVO
	 */
	public List<CmVideoDVO> selectVideoList(CmVideoDVO cmVideoDVO) {
		return (List<CmVideoDVO>) selectList(NAMESPACE + "selectVideoList", cmVideoDVO);
	}
}
