package com.ofss.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.controller.types.AddChequeRequestBody;
import com.ofss.main.domain.BankSlip;
import com.ofss.main.service.BankSlipService;

@CrossOrigin(origins="*")
@RequestMapping("api/bankSlip")
@RestController
public class BankSlipController {
	@Autowired
	BankSlipService bankSlipService;
	@PostMapping("addCheque")
	BankSlip addCheque(@RequestBody AddChequeRequestBody body) {
		return bankSlipService.addCheque(body.getBankSlip(), body.getCheque());
	}
}
