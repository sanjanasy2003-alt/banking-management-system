package com.example.demo.mapper;

import com.example.demo.dto.AccountDto;
import com.example.demo.entity.Account;

public class AccountMapper {
	
	public static Account mapToAccount(AccountDto accountdto) {
		Account account =new Account(
				accountdto.id(),
				accountdto.accountHolderName(),
				accountdto.balance(),
				accountdto.mobileNumber(),
				accountdto.email()
				);
		return account ;
		
	}
	
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountdto =new AccountDto(
				account.getId(),
				account.getAccountHolderName(),
				account.getBalance(),
				account.getMobileNumber(),
				account.getEmail()
				
				);
		return accountdto;
				
	}

}
