package com.finrepgen.dao;

import org.springframework.web.multipart.MultipartFile;

import com.finrepgen.model.Company;
import com.finrepgen.model.FinancialInfo;
import com.finrepgen.model.Teams;

public interface FinRepGenDao <T extends FinancialInfo> {
	
	public boolean readAndStoreFile(MultipartFile file, T t);
	public Company getCompanyInfo(String companyId,int userId);
	public Teams getAllTeams();

}
