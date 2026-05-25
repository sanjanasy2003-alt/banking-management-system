package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AccountDto;
import com.example.demo.service.AccountService;
import com.example.demo.service.EmailService;
import com.example.demo.service.SmsService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	private AccountService accountservice;
	private final SmsService smsService;
	private final EmailService emailService;

	public AccountController(AccountService accountservice,SmsService smsService,EmailService emailService) {
		this.accountservice = accountservice;
		this.smsService= smsService;
		this.emailService=emailService;
	}
	
	//add account REST API
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountdto){
		return new ResponseEntity<>(accountservice.createAccount(accountdto),HttpStatus.CREATED);
		}
	
	//get account REST API 
	
	@GetMapping("/{id}")
	
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
		AccountDto accountdto = accountservice.getAccountById(id);
		return ResponseEntity.ok(accountdto);
	}
	
	//deposit REST API 
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable Long id , @RequestBody Map<String ,Double>request){
		Double amount =request.get("amount");
		AccountDto accountdto= accountservice.deposit(id, amount);
		
		smsService.sendSms(
			    accountdto.mobileNumber(),
			    "Amount Deposited Successfully. Current Balance: " + accountdto.balance()
			);
		
		emailService.sendEmail(
				accountdto.email(),
		        "Amount Deposited",
		        "Rs " + amount +
		        " deposited successfully.\nAvailable Balance: Rs "
		        + accountdto.balance()
		);
		
		return ResponseEntity.ok(accountdto);
	}
	
	//withdraw REST API
	@PutMapping("{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable Long id , @RequestBody Map<String ,Double>request){
		Double amount =request.get("amount");
		AccountDto accountdto= accountservice.withdraw(id, amount);
		
		smsService.sendSms(
			    accountdto.mobileNumber(),
			    "Amount Deposited Successfully. Current Balance: " + accountdto.balance()
			);
		
		emailService.sendEmail(
				accountdto.email(),
		        "Amount Deposited",
		        "Rs " + amount +
		        " deposited successfully.\nAvailable Balance: Rs "
		        + accountdto.balance()
		);
		
		return ResponseEntity.ok(accountdto);
	}
	
	//get all Account REST API 
	
	@GetMapping
	public ResponseEntity<List<AccountDto>> getAllAccounts(){
		List <AccountDto> accounts =accountservice.getAllAccounts();
		return ResponseEntity.ok(accounts);
	}
	
	//Delete by id REST API
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long id){
		accountservice.deleteAccount(id);
		return ResponseEntity.ok("Account is deleted successfully !!");
	}
	
	
}


