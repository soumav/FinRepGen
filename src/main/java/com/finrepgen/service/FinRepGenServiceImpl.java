package com.finrepgen.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.finrepgen.constants.FinRepGenConstants;
import com.finrepgen.dao.FinRepGenDao;
import com.finrepgen.model.Company;
import com.finrepgen.model.FinancialInfoInput;
import com.finrepgen.model.FinancialInfoReturn;
import com.finrepgen.model.FinancialPeriodData;
import com.finrepgen.model.Team;
import com.finrepgen.model.Teams;
import com.finrepgen.model.User;
import com.finrepgen.util.XmlUtil;

@Service
public class FinRepGenServiceImpl implements FinRepGenService<FinancialInfoInput> {

	@Autowired
	FinRepGenDao<FinancialInfoInput> finRepGenDao;

	@Override
	public boolean readAndStoreFile(FinancialInfoInput finInfoInp, MultipartFile xmlFile, String xsdPath) {
		if (XmlUtil.validateXmlAgainstXsd(xmlFile, xsdPath))
			return finRepGenDao.readAndStoreFile(xmlFile, finInfoInp);
		return false;
	}

	@Override
	public FinancialInfoInput getRawFinInfo() {
		return finRepGenDao.getRawFinInfo();
	}
	
	@Override
	public boolean updateUserData(MultipartFile xmlFile, String xsdPath) {

		if (XmlUtil.validateXmlAgainstXsd(xmlFile, xsdPath))
			return finRepGenDao.updateUsersData(xmlFile);
		return false;
	}

	@Override
	public FinancialInfoReturn getCompanyInfo(String companyId, int userId) {

		FinancialInfoReturn finInfoRet = new FinancialInfoReturn();
		if (checkUserCoverage(companyId, userId)) {
			Company comp = finRepGenDao.getCompanyInfo(companyId, userId);
			finInfoRet.setCompanyId(comp.getID());
			finInfoRet.setCompanyName(comp.getCompanyName());
			finInfoRet.setIndustryCovered(comp.getIndustry());
			Map<Date, Float> epsMap = new HashMap<>();
			Map<Date, Float> peMap = new HashMap<>();
			Map<Date, Float> revenueMap = new HashMap<>();
			for (FinancialPeriodData fnp : comp.getFinancialPeriodData()) {
				epsMap.put(fnp.getFrom(),
						(Float) fnp.getMetrics().getMetric().stream()
								.filter(d -> FinRepGenConstants.EPS_STRING.val().equals(d.getName()))
								.collect(Collectors.toList()).get(0).getValue());
				peMap.put(fnp.getFrom(),
						(Float) fnp.getMetrics().getMetric().stream()
								.filter(d -> FinRepGenConstants.PE_STRING.val().equals(d.getName()))
								.collect(Collectors.toList()).get(0).getValue());
				revenueMap.put(fnp.getFrom(),
						(Float) fnp.getMetrics().getMetric().stream()
								.filter(d -> FinRepGenConstants.REVENUE_STRING.val().equals(d.getName()))
								.collect(Collectors.toList()).get(0).getValue());
			}
			finInfoRet.setEpsMap(epsMap);
			finInfoRet.setPeMap(peMap);
			finInfoRet.setRevenueMap(revenueMap);
		}

		return finInfoRet;

	}

	private boolean checkUserCoverage(String companyId, int userId) {
		Teams teams = finRepGenDao.getAllTeams();
		User user = new User();
		user.setId(userId);
		for (Team t : teams.getTeam()) {
			if (t.getCoverage().getCompanyIDList().getID().contains(companyId)
					&& t.getUsers().getUser().stream().anyMatch(c -> c.getId() == userId)) {
				return true;
			}
		}
		return false;
	}

}
