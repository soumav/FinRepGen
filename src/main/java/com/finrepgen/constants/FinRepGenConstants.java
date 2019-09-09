package com.finrepgen.constants;

public enum FinRepGenConstants {

	EPS_STRING("EPS"), 
	PE_STRING("PE"), 
	REVENUE_STRING("Revenue");

	private final String val;
	
	public String getVal() {
		return val;
	}
	
	private FinRepGenConstants(String val) {
		this.val = val;
	}

}
