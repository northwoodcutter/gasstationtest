package com.grishko.gasstation.services;

import java.util.List;

import com.grishko.gasstation.models.Dispenser;

public interface DispenserService {
	void addDispenser(Dispenser dispenser);
	List<Dispenser> getDispensers();
	void deleteDispenser(Integer id);
}
