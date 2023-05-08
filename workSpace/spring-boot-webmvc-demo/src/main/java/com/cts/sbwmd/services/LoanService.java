package com.cts.sbwmd.services;

import org.springframework.stereotype.Service;

import com.cts.sbwmd.model.Loan;

@Service
public class LoanService {

	public void compute(Loan loan) {
		loan.setSimpleInterest(loan.getPrincipal()*loan.getRateOfInterest()*loan.getTimePeriod()/100.0);
		loan.setTotalDebtAmount(loan.getPrincipal()+loan.getSimpleInterest());
	}
}
