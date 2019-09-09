package com.finrepgen.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.finrepgen.inmemorymockdb.InMemoryMockDB;
import com.finrepgen.model.FinancialInfoInput;
import com.finrepgen.model.FinancialInfoReturn;
import com.finrepgen.service.FinRepGenService;

@RestController
public class FinRepGenController {

	@Autowired
	FinRepGenService<FinancialInfoInput> fileService;

	/*
	 * @Autowired //Not required as @Value is being used
	 * FinInfoProperties finInfoProps;
	 */

	private String XSD_FININFO_PATH;

	@Value("${fininfo.xsdpath}")
	public void setXsdFinInfoPath(String path) {
		XSD_FININFO_PATH = new File("").getAbsolutePath().replace("\\", "/") + path;
	}

	@PostMapping(path = "/uploadfindata", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public boolean uploadFinData(@RequestParam("file") MultipartFile uploadedFile) {

		return fileService.readAndStoreFile(InMemoryMockDB.getFinInfoInput(), uploadedFile, XSD_FININFO_PATH);

	}

	@PostMapping(path = "/updateuserdata", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public boolean updateUserData() {
		
		//logic to be implemented
		return true;

	}

	@GetMapping(path = "/getcompanyinfo", produces = {MediaType.APPLICATION_XML_VALUE })
	public FinancialInfoReturn getCompanyInfo(@RequestParam("compid") String compId,
			@RequestParam("userid") int userId) {
		
		return fileService.getCompanyInfo(compId, userId);
	}

}
