package com.finrepgen.dao;

import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.finrepgen.inmemorymockdb.InMemoryMockDB;
import com.finrepgen.model.Company;
import com.finrepgen.model.FinancialInfoInput;
import com.finrepgen.model.ObjectFactory;
import com.finrepgen.model.Team;
import com.finrepgen.model.Teams;
import com.finrepgen.model.User;
import com.finrepgen.model.UserInfo;
import com.finrepgen.model.UsersInfo;
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
	public FinancialInfoInput getRawFinInfo() {
		return InMemoryMockDB.getFinInfoInput();
	}

	@Override
	public boolean updateUsersData(MultipartFile xmlFile) {

		UsersInfo updtdUsers = (UsersInfo) XmlUtil.mapXmlToJava(xmlFile, new UsersInfo());

		try {
			for (UserInfo updtdUser : updtdUsers.getUserInfo()) {
				team: for (Team t : InMemoryMockDB.getFinInfoInput().getTeams().getTeam()) {
					for (User u : t.getUsers().getUser()) {
						if (u.getId() == updtdUser.getId()) {
							u.setName(updtdUser.getName());
							u.setEmail(new ObjectFactory().createUserEmail(updtdUser.getEmail()));

							break team;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Company getCompanyInfo(String companyId, int userId) {
		Company comp = new Company();
		try {
			comp = InMemoryMockDB.getFinInfoInput().getCompanies().getCompany().stream()
					.filter(c -> c.getID().equals(companyId)).collect(Collectors.toList()).get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return new Company();
		}
		return comp;

	}

	@Override
	public Teams getAllTeams() {
		return InMemoryMockDB.getFinInfoInput().getTeams();
	}

}
