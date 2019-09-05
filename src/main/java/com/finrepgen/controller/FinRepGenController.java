package com.finrepgen.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finrepgen.bean.FinancialInfo;
import com.finrepgen.bean.FinancialInfoReturn;

@RestController
public class FinRepGenController {

	@PostMapping(path = "/uploadfindata", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public boolean uploadData(@RequestBody FinancialInfo fininfo) {
		System.out.println("Financial Info Received---> \n" + fininfo);
		return true;

	}

	@PostMapping(path = "/updateuserdata", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public boolean updateUserData() {
		return true;
	}
	
	@GetMapping(path = "/getcompanyinfo", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public FinancialInfoReturn getCompanyInfo(@RequestParam("compid") String compId,@RequestParam("userid") String userId) {
		System.out.println("Inside getcompanyinfo ---> compId= "+compId +" userId="+userId);
		return new FinancialInfoReturn();
	}

}
