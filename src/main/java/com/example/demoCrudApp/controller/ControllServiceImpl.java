package com.example.demoCrudApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoCrudApp.repository.DataBase;
import com.example.demoCrudApp.repository.Repository;

@Service
public class ControllServiceImpl implements ControllService {

	@Autowired
	private Repository repos;
	@Override
	public String update(DataBase d) {
		
		repos.save(d);
		
		return "Updated";
	}
	@Override
	public String add(DataBase d) {
		
		repos.save(d);
		return "Saved";
	}

	@Override
	public DataBase getById(Integer id) {
		
		Optional<DataBase> op=repos.findById(id);
		
		return op.get();
	}

	@Override
	public List<DataBase> getAll() {
		return repos.findAll();
		
	}

	@Override
	public String deleteById(Integer id) {
		
		Optional<DataBase>data=repos.findById(id);
		
		if(data.isPresent()) {
			repos.deleteById(id);
			return "Delete";
		}
		else {
			return "Not Found";
		}
	}



	

}
