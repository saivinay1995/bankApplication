package com.bank.dao;


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
	@Override
	public void transferbalance(long fromid,long toid, Integer amount) {
		Session s=sessionFactory.getCurrentSession();
		
		Bank b1=s.byId(Bank.class).load(fromid);
		Bank b2=s.byId(Bank.class).load(toid);
		b1.setBalance(b1.getBalance()-amount);
		b2.setBalance(b2.getBalance()+amount);
		s.persist(b1);
		s.persist(b2);
		
		
	}
	@Override
	public List<Bank> getAllBank() {
		Session s=sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder=s.getCriteriaBuilder();
		CriteriaQuery<Bank> criteriaQuery=criteriaBuilder.createQuery(Bank.class);
		Root<Bank> root=criteriaQuery.from(Bank.class);
		criteriaQuery.select(root);
		Query query=s.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	
	

}
