package com.grishko.gasstation.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("partDAO")
@Transactional
public class PartDAOimpl<T> implements PartDAO<T> {
	
	@Autowired
	private SessionFactory mFactory;

	public void setFactory(SessionFactory factory) {
		this.mFactory = factory;
	}

	@Transactional
	@Override
	public void addPart(T part) {
		Session session = this.mFactory.getCurrentSession();
		session.persist(part);
	}

	@Transactional
	@Override
	public void deletePart(T part) {
		
	}

	@Transactional
	@Override
	public List<T> getList(T type) {
		Session session = this.mFactory.getCurrentSession();
		List<T> list = session.createQuery("from " + type.getClass().getName()).list();
		return list;
	}

}
