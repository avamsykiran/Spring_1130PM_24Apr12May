package com.cts.sbwmd.model;

public class Loan {

	private double principal;
	private double rateOfInterest;
	private double timePeriod;
	private double simpleInterest;
	private double totalDebtAmount;
	
	public Loan() {
		// TODO Auto-generated constructor stub
	}

	public Loan(double principal, double raeOfInterest, double timePeriod) {
		super();
		this.principal = principal;
		this.rateOfInterest = raeOfInterest;
		this.timePeriod = timePeriod;
	}

	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public double getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(double timePeriod) {
		this.timePeriod = timePeriod;
	}

	public double getSimpleInterest() {
		return simpleInterest;
	}

	public void setSimpleInterest(double simpleInterest) {
		this.simpleInterest = simpleInterest;
	}

	public double getTotalDebtAmount() {
		return totalDebtAmount;
	}

	public void setTotalDebtAmount(double totalDebtAmount) {
		this.totalDebtAmount = totalDebtAmount;
	}

	
	
	
}
