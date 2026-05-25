package com.example.demo.dto;

/*import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
	
	private Long id;
	private String accountHolderName;
	private double balance;
	private String mobileNumber;
	
	public AccountDto() {}

	public AccountDto(Long id, String accountHolderName ,double balance, String mobileNumber) {
		this.id=id;
		this.accountHolderName=accountHolderName;
		this.balance=balance;
		this.mobileNumber=mobileNumber;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
		
		
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	
}*/

	public record AccountDto ( Long id, String accountHolderName ,double balance,String mobileNumber ,String email ) {}
	 
	
	


