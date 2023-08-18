package com.demo.employee.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.employee.dto.EmployeeModelDTO;
import com.demo.employee.entity.EmployeeModel;
import com.demo.employee.service.EService;

@RestController
public class EmployeeController {
	
	@Autowired
	EService service;
	
	@RequestMapping(value = "/search" , method = RequestMethod.GET)
	@ResponseBody
	public String Say()
	{
		return "Hello Spring";
	}
	
	@PostMapping("/add")
	public ResponseEntity<EmployeeModel> postEmp(@RequestBody EmployeeModelDTO model)
	{
		EmployeeModel user = service.postempuser(model);
		return new ResponseEntity<EmployeeModel>(user,HttpStatus.CREATED) ;
	}

	@GetMapping("/getAll")
	public ResponseEntity <List<EmployeeModel>> getAll(@RequestBody int Id )
	{
		List<EmployeeModel> allUser = service.getAllUser();
		return new ResponseEntity <List<EmployeeModel>> (allUser,HttpStatus.OK);
	}
	
	@GetMapping("/getById/{Id}")
	public ResponseEntity<EmployeeModel> getEmp(@PathVariable int id)
	{
		EmployeeModel User = service.getAllUser(id);
		return new ResponseEntity<EmployeeModel> (User,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteById/{Id}")
	public ResponseEntity<String> deleteEmp(@PathVariable int id)
	{
		String user = service.deleteUser(id);
		return new ResponseEntity<String> (user,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateById/{Id}")
	public ResponseEntity<EmployeeModel > putEmp(@PathVariable int id, @RequestBody EmployeeModel model)
	{
		EmployeeModel user = service.updateUser(id,model);
		return new ResponseEntity<EmployeeModel>(user, HttpStatus.ACCEPTED);
	}
	

	

}
