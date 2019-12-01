package com.bank.service;

import java.util.List;

import com.bank.model.Bank;

public interface BankService {
	long save(Bank bank);
	Bank get(long id);
	void delete(long id);
	void transferbalance(long fromid,long toid, Integer amount);
	boolean login(long id,String pass);
	List<Bank> getAllBank();
	

}
