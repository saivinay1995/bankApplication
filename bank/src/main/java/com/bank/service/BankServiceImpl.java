package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dao.BankDao;
import com.bank.model.Bank;

@Service
@Transactional(readOnly=true)
public class BankServiceImpl implements BankService {
	
	@Autowired
	private BankDao bankDao;

	@Transactional
	@Override
	public long save(Bank bank) {
		return bankDao.save(bank);
	}

	@Override
	public Bank get(long id) {
		return bankDao.get(id);
	}

	@Transactional
	@Override
	public void delete(long id) {
		bankDao.delete(id);
		
	}

	@Override
	public boolean login(long id, String pass) {
		return bankDao.login(id, pass);
		
	}

	@Transactional
	@Override
	public void transferbalance(long fromid, long toid, Integer amount) {
		bankDao.transferbalance(fromid, toid, amount);
		
	}

	@Override
	public List<Bank> getAllBank() {
		return bankDao.getAllBank();
	}

	

}
