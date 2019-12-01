package com.bank.dao;



import java.util.List;

import com.bank.model.Bank;

public interface BankDao {
	
	long save(Bank bank);
	Bank get(long id);
	void transferbalance(long fromid,long toid, Integer amount);
	boolean login(long id,String pass);
	void delete(long id);
	List<Bank> getAllBank();

}
