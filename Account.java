package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="accounts")
@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	private Long id;
	
	@Column (name ="account_holder_name")
	private String accountHolderName;
	
	
	private double balance;
	
	private String mobileNumber;
	
	private String email;
	
	public Account() {}

	public Account(Long id, String accountHolderName ,double balance,String mobileNumber, String email) {
		this.id=id;
		this.accountHolderName=accountHolderName;
		this.balance=balance;
		this.mobileNumber=mobileNumber;
		this.email=email;
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
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
