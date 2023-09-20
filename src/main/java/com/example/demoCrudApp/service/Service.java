package com.example.demoCrudApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoCrudApp.controller.ControllService;
import com.example.demoCrudApp.repository.DataBase;

@RestController
public class Service {

	@Autowired
	private ControllService control;
	
	
	
	
	
	@PutMapping("update")
	public ResponseEntity<String> updateUser(@RequestBody DataBase d,Integer id){
		
		String  op= control.update(d);
		
		
		 
		 return new ResponseEntity<>(op,HttpStatus.CREATED);
		
	}
	@PostMapping("/add")
public ResponseEntity<String> addUser(@RequestBody DataBase d){
		
		String  op= control.add(d);
		 
		 return new ResponseEntity<>(op,HttpStatus.CREATED);
		
	}
	@GetMapping("/get/{id}")
public ResponseEntity<DataBase> getUser(@PathVariable Integer id){
		
		DataBase  get= control.getById(id);
		 
		 return new ResponseEntity<>(get,HttpStatus.OK);
		
	}
	@GetMapping("/getAll")
public  ResponseEntity<List<DataBase>> getAllUser( ){
		
		List<DataBase>  getAll= control.getAll();
		 
		 return new ResponseEntity<>(getAll,HttpStatus.OK);
		
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id ) {
		
		String jk=control.deleteById(id);
		
		return new ResponseEntity<>(jk,HttpStatus.OK);
	}
	
	
}
