package com.example.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;

import com.example.repository.InMemoryEmployeeRepository;
import com.example.repository.MySqlJdbcEmployeeRepository;
import com.example.service.MySqlJpaEmployeeService;
import com.example.domain.Employee;
import com.example.domain.EJob;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/employees")
public class EmployeeController {
	
	InMemoryEmployeeRepository repository = new InMemoryEmployeeRepository();
	// MySqlJdbcEmployeeRepository repository = new MySqlJdbcEmployeeRepository();
	// @Autowired
	// MySqlJpaEmployeeService repository;
	
	// Lectura:
	@GetMapping
	public String read(Model model) throws SQLException {
		model.addAttribute("employees", repository.read());
		return "index";
	}
	
	@GetMapping("/{id}")
	//@ResponseBody
	public String readById(Model model, @PathVariable int id) throws SQLException {
		model.addAttribute("employee", repository.readById(id));
		return "edit";
	}
	// null -> throw new EmployeeNotFoundException(id)
	
	// Creació:
	@PostMapping
	public String create(Model model, @Valid Employee employee) throws SQLException {
		employee.setSalary(EJob.valueOf(employee.getJob()).getSalary());
		repository.create(employee);
		return "redirect:/employees";
	}
	/*public String create(Model model, @Valid Employee form) throws SQLException {
		String name = form.getName();
		EJob job = EJob.valueOf(form.getJob());
		
		Employee employee = new Employee();
		
		employee.setName(name);
		employee.setJob(job.name());
		employee.setSalary(job.getSalary());
		
		repository.create(employee);
		
		System.out.println(employee.toString());
		
		return "redirect:/employees";
	}*/
	
	// Eliminació:
	@DeleteMapping("/{id}")
	public String delete(Model model, @PathVariable int id) throws SQLException {
		repository.delete(id);
		return "redirect:/employees";
	}
	
	// Actualització:
	@PutMapping("/{id}")
	public String update(Model model, @PathVariable int id, @Valid Employee form) throws SQLException {
		String name = form.getName();
		EJob job = EJob.valueOf(form.getJob());
		
		Employee employee = new Employee();
		
		employee.setId(id);
		employee.setName(name);
		employee.setJob(job.name());
		employee.setSalary(job.getSalary());
		
		repository.update(employee);

		System.out.println(employee.toString());
		
		return "redirect:/employees";
	}
	
	// Filtratge:
	@GetMapping(params = "job")
	public String filterByJob(Model model, @Valid @RequestParam EJob job) throws SQLException {
		model.addAttribute("employees", repository.filterByJob(job.name()));
		return "index";
	}
	
}
