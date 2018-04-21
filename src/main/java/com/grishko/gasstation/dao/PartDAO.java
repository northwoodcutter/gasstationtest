package com.grishko.gasstation.dao;

import java.util.List;

public interface PartDAO<T> {
  void addPart(T part);
  void deletePart(T part);
  List<T> getList(T type);
}
