package com.grishko.gasstation.dao;

import java.util.List;

import com.grishko.gasstation.models.Dispenser;

public interface DispenserDAO {
   void addDispenser(Dispenser dispenser);
   void deleteDispenser(Integer id);
   List<Dispenser> getDispensers();
}
