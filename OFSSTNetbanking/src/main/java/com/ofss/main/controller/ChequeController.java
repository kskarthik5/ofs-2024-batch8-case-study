package com.ofss.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.controller.types.ChequeRequestBody;
import com.ofss.main.service.ChequeService;

@CrossOrigin(origins="*")
@RequestMapping("api/cheque")
@RestController
public class ChequeController {
	@Autowired
	ChequeService chequeService;
	@PostMapping("generate")
	boolean generateCheques(@RequestBody ChequeRequestBody req){
		chequeService.generateCheques(req.getAccount(), req.getCount());
		return true;
	}
	
}
