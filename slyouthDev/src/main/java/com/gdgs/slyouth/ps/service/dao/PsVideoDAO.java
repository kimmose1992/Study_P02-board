package com.gdgs.slyouth.ps.service.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gdgs.slyouth.cm.service.dao.AbstractDAO;

/**
 * @title    : [찬양과 셀라] 주일찬양 DAO 클래스	    
 * @author   : 이하은
 * @create   : 2021.06.28
 */

@Component
@Repository("psWorshipDAO")
@SuppressWarnings("unchecked")
public class PsVideoDAO extends AbstractDAO {
	
	private static final String NAMESPACE = "ps.psworship.";

}
