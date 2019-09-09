package com.finrepgen.service;

import org.springframework.web.multipart.MultipartFile;

import com.finrepgen.model.FinancialInfo;
import com.finrepgen.model.FinancialInfoReturn;

public interface FinRepGenService<T extends FinancialInfo> {

	public boolean readAndStoreFile(T t, MultipartFile xmlFile, String xsdPath);
	
	public T getRawFinInfo();

	public FinancialInfoReturn getCompanyInfo(String companyId, int userId);

	public boolean updateUserData(MultipartFile xmlFile, String xsdPath);

}
