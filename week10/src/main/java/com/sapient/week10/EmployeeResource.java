package com.sapient.week10;

import java.net.URI;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class EmployeeResource {
	@Autowired
	private EmployeeDaoService service;

	@GetMapping("/employees")
	public List<Employee> retrieveAllUsers() {
		return service.findAll();
	}

	@GetMapping("/employees/{id}")
	public Employee retrieveUser(@PathVariable int id) {
		return service.findOne(id);
	}

	@GetMapping("/employee/{name}")
	public Employee retrieveUserByName(@PathVariable String name) {
		return service.findByName(name);
	}

	@PostMapping("/employees")
	public ResponseEntity<Object> createUser(@RequestBody Employee employee) {
		Employee Saveduser = service.save(employee);
		URI location = ServletUriComponentsBuilder.
				fromCurrentRequest().path("/{id}").buildAndExpand(Saveduser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id) {
		
		service.delete(id);
	}
	
	@PutMapping("/employees/{id}")
	public void modifyEmployee(@PathVariable int id, @RequestBody Employee e ) {
	
		service.modify(id, e);
	}
}
