package com.finrepgen.model;

import java.util.Date;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FinancialInfoReturn", propOrder = {
    "companyId",
    "companyName","industryCovered",
    "peMap","epsMap","revenueMap"
})
@XmlRootElement(name="FinancialInfoReturn")
public class FinancialInfoReturn implements FinancialInfo {
	
	@XmlElement(name = "CompanyId",required=true)
	String companyId;
	@XmlElement(name = "CompanyName")
	String companyName;
	@XmlElement(name = "IndustryCovered")
	String industryCovered;
	@XmlElement(name = "PeMap")
	Map<Date,Float> peMap;
	@XmlElement(name = "EpsMap")
	Map<Date,Float> epsMap;
	@XmlElement(name = "RevenueMap")
	Map<Date,Float> revenueMap;
	
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getIndustryCovered() {
		return industryCovered;
	}
	public void setIndustryCovered(String industryCovered) {
		this.industryCovered = industryCovered;
	}
	public Map<Date, Float> getPeMap() {
		return peMap;
	}
	public void setPeMap(Map<Date, Float> peMap) {
		this.peMap = peMap;
	}
	public Map<Date, Float> getEpsMap() {
		return epsMap;
	}
	public void setEpsMap(Map<Date, Float> epsMap) {
		this.epsMap = epsMap;
	}
	public Map<Date, Float> getRevenueMap() {
		return revenueMap;
	}
	public void setRevenueMap(Map<Date, Float> revenueMap) {
		this.revenueMap = revenueMap;
	}
	
}
