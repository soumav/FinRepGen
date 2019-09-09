package com.finrepgen.dao;

import org.springframework.web.multipart.MultipartFile;

import com.finrepgen.model.FinancialInfo;
import com.finrepgen.model.FinancialInfoReturn;

public interface FinRepGenDao <T extends FinancialInfo> {
	
	public boolean readAndStoreFile(MultipartFile file, T t);
	public FinancialInfoReturn getCompanyInfo(String companyId,String userId);

}
