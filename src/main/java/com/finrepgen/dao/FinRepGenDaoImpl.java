package com.finrepgen.dao;

import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.finrepgen.inmemorymockdb.InMemoryMockDB;
import com.finrepgen.model.Company;
import com.finrepgen.model.FinancialInfoInput;
import com.finrepgen.model.Teams;
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
	public Company getCompanyInfo(String companyId, int userId) {
		
		Company comp = InMemoryMockDB.getFinInfoInput().getCompanies().getCompany().stream()
				.filter(c -> c.getID().equals(companyId)).collect(Collectors.toList()).get(0);

		return comp;

	}
	
	@Override
	public Teams getAllTeams() {
		return InMemoryMockDB.getFinInfoInput().getTeams();
	}

}
