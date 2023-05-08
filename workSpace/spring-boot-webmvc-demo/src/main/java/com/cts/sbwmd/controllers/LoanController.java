package com.cts.sbwmd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbwmd.model.Loan;
import com.cts.sbwmd.services.LoanService;

@Controller
@RequestMapping("/loan")
public class LoanController {

	@Autowired
	private LoanService loanService;
	
	@GetMapping
	public ModelAndView showLoanInputPageAction() {
		return new ModelAndView("loans/input-page","loan",new Loan(1000.0,2.3,1.2));
		//return new ModelAndView("loans/input-page","loan",new Loan());
	}
	
	@PostMapping
	public ModelAndView computeLoanAction(@ModelAttribute("loan") Loan loan) {
		loanService.compute(loan);
		return new ModelAndView("loans/output-page", "loan", loan);
	}
}
