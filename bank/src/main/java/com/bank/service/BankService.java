package com.bank.service;

import com.bank.model.Bank;

public interface BankService {
	long save(Bank bank);
	Bank get(long id);
	void delete(long id);
	boolean login(long id,String pass);
	

}
