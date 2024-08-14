package com.ofss.main.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.controller.types.DepositWithdrawRequest;
import com.ofss.main.controller.types.TransferRequestBody;
import com.ofss.main.domain.Transaction;
import com.ofss.main.service.TransactionService;

@CrossOrigin(origins="*")
@RequestMapping("api/transaction")
@RestController
public class TransactionController {
	@Autowired
	TransactionService transactionService;
	@PostMapping("deposit")
	public Transaction deposit(@RequestBody DepositWithdrawRequest req) {
		return transactionService.deposit(req.getAccount(), req.getAmount());
	}
	@PostMapping("withdraw")
	public Transaction withdraw(@RequestBody DepositWithdrawRequest req) {
		return transactionService.withdraw(req.getAccount(), req.getAmount());
	}
	@PostMapping("transfer")
	public Transaction transfer(@RequestBody TransferRequestBody req) {
		return transactionService.transfer(req.getPayer(),req.getPayee(),req.getAmount());
	}
}
