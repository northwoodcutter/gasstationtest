package com.grishko.gasstation.services;

import java.util.List;

public interface PartService<T> {
	void addPart(T part);
	void deletePart(T part);
	List<T> getList(T type);
}
