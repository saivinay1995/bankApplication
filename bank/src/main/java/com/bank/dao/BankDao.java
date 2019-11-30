package com.bank.dao;



import com.bank.model.Bank;

public interface BankDao {
	
	long save(Bank bank);
	Bank get(long id);
	
	boolean login(long id,String pass);
	void delete(long id);

}
