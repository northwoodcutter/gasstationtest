package com.grishko.gasstation.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grishko.gasstation.models.Dispenser;

@Repository ("dispenserDAO")
@Transactional
public class DispenserDAOImpl implements DispenserDAO{
	
	@Autowired
	private SessionFactory mFactory;
	
	public void setFactory(SessionFactory factory) {
		this.mFactory = factory;
	}
	
	@Transactional(readOnly=false)
	@Override
	public void addDispenser(Dispenser dispenser) {
		Session session = this.mFactory.getCurrentSession();
		session.persist(dispenser);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Dispenser> getDispensers() {
		Session session = this.mFactory.getCurrentSession();
		List<Dispenser> dispensers = session.createQuery("from Dispenser").list();
		return dispensers;
	}

	@Override
	public void deleteDispenser(Integer id) {
		Session session = this.mFactory.getCurrentSession();
		Dispenser dispenser = session.load(Dispenser.class, id);
		if (dispenser != null) {
			session.delete(dispenser);
		}
	}
}
