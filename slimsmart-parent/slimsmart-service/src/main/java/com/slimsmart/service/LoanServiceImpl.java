package com.slimsmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slimsmart.api.honglin.LoanService;
import com.slimsmart.common.service.AbstractBaseService;
import com.slimsmart.dao.usercenter.LoanDao;
import com.slimsmart.model.honglin.Loan;
@Service
public class LoanServiceImpl extends AbstractBaseService<Loan> implements LoanService{
	@Autowired
	private LoanDao loanDao;
	@Override
	public List<Loan> findList() {
		
		return loanDao.getList();
	}

}
