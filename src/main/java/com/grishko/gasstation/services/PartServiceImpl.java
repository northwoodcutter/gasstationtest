package com.grishko.gasstation.services;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grishko.gasstation.dao.DispenserDAO;
import com.grishko.gasstation.dao.PartDAO;

@Service("partService")
@Transactional
public class PartServiceImpl<T> implements PartService<T>{

	@Autowired(required=true)
	@Qualifier("partDAO")
	private PartDAO<T> partDAO;

	
	@Transactional
	@Override
	public void addPart(T part) {
		partDAO.addPart(part);
	}

	@Transactional
	@Override
	public void deletePart(T part) {
		partDAO.deletePart(part);
	}

	@Transactional
	@Override
	public List<T> getList(T type) {
		return partDAO.getList(type);
	}

}
