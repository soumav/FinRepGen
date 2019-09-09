package com.finrepgen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.finrepgen.dao.FinRepGenDao;
import com.finrepgen.inmemorymockdb.InMemoryMockDB;
import com.finrepgen.model.Company;
import com.finrepgen.model.FinancialInfoInput;
import com.finrepgen.model.FinancialInfoReturn;
import com.finrepgen.util.XmlUtil;

@Service
public class FinRepGenServiceImpl implements FinRepGenService<FinancialInfoInput> {

	@Autowired
	FinRepGenDao<FinancialInfoInput> finRepGenDao;

	@Override
	public boolean readAndStoreFile(FinancialInfoInput finInfoInp, MultipartFile xmlFile, String xsdPath) {
		if (XmlUtil.validateXmlAgainstXsd(xmlFile, xsdPath))
			return finRepGenDao.readAndStoreFile(xmlFile, finInfoInp);
		else
			return false;
	}
	
	@Override
	public FinancialInfoReturn getCompanyInfo(String companyId,String userId) {
		
		if(checkUserCoverage(companyId, userId)) {
			return finRepGenDao.getCompanyInfo(companyId, userId);
		}
			
		return new FinancialInfoReturn();
		
	}
	
	private boolean checkUserCoverage(String companyId,String userId) {
		return true; // logic to be implemented
	}

}
