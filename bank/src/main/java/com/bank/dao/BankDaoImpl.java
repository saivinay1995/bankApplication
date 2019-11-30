package com.bank.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bank.model.Bank;

@Repository
public class BankDaoImpl implements BankDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public long save(Bank bank) {
		sessionFactory.getCurrentSession().save(bank);
		return bank.getId();
	}
	@Override
	public Bank get(long id) {
		return sessionFactory.getCurrentSession().get(Bank.class, id);
	}
	
	
	@Override
	public void delete(long id) {
		Bank b=sessionFactory.getCurrentSession().byId(Bank.class).load(id);
		sessionFactory.getCurrentSession().delete(b);
		
	}
	@Override
	public boolean login(long id, String pass) {
		Bank b=sessionFactory.getCurrentSession().byId(Bank.class).load(id);
		if(b.getPassword().equals(pass))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	

}
