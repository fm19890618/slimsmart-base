package com.slimsmart.api.honglin;

import java.util.List;

import com.slimsmart.common.service.BaseService;
import com.slimsmart.model.honglin.Loan;

public interface LoanService extends BaseService<Loan>{

	List<Loan> findList();
}
