package com.example.demoCrudApp.controller;

import java.util.List;


import com.example.demoCrudApp.repository.DataBase;

public interface ControllService {
	
	
	public String update(DataBase d);
	public String add(DataBase d);
	public DataBase getById(Integer id);
	public List<DataBase> getAll();
	public String deleteById(Integer id);
	

}
