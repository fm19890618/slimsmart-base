package com.slimsmart.dao.usercenter;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.slimsmart.common.dao.MyBatisDao;
import com.slimsmart.model.honglin.Loan;
@Repository
public class LoanDao extends MyBatisDao<Loan> {
	
	public List<Loan> getList(){
		
		return findList("findList", null);
	}

}
