package com.finrepgen.dao;

import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.finrepgen.inmemorymockdb.InMemoryMockDB;
import com.finrepgen.model.Company;
import com.finrepgen.model.FinancialInfoInput;
import com.finrepgen.model.FinancialInfoReturn;
import com.finrepgen.util.XmlUtil;

@Repository
public class FinRepGenDaoImpl implements FinRepGenDao<FinancialInfoInput> {

	@Override
	public boolean readAndStoreFile(MultipartFile file, FinancialInfoInput finInfoInp) {
		try {
			InMemoryMockDB.setFinInfoInput((FinancialInfoInput) XmlUtil.mapXmlToJava(file, finInfoInp));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public FinancialInfoReturn getCompanyInfo(String companyId, String userId) {
		FinancialInfoReturn finInfoRet = new FinancialInfoReturn();
		Company comp = InMemoryMockDB.getFinInfoInput().getCompanies().getCompany().stream()
				.filter(c -> c.getID().equals(companyId)).collect(Collectors.toList()).get(0);

		// population logic to be implemented
		return finInfoRet;

	}

}
