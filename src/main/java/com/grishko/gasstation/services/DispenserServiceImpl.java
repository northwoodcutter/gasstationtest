package com.grishko.gasstation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grishko.gasstation.dao.DispenserDAO;
import com.grishko.gasstation.models.Dispenser;

@Service("dispenserService")
@Transactional
public class DispenserServiceImpl implements DispenserService{

	@Autowired(required=true)
	@Qualifier("dispenserDAO")
	private DispenserDAO dispenserDAO;

	@Transactional
	@Override
	public void addDispenser(Dispenser dispenser) {
		dispenserDAO.addDispenser(dispenser);
	}
	
	@Transactional
	@Override
	public List<Dispenser> getDispensers() {
		return dispenserDAO.getDispensers();
	}

	@Override
	public void deleteDispenser(Integer id) {
		dispenserDAO.deleteDispenser(id);
	}
}
