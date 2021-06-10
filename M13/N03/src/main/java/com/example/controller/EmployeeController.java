package com.example.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;

import com.example.repository.InMemoryEmployeeRepository;
import com.example.repository.MySqlJdbcEmployeeRepository;
import com.example.service.MySqlJpaEmployeeService;
import com.example.domain.Employee;
import com.example.domain.EJob;

@Controller
@CrossOrigin(origins = "http://localhost:8080")//, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
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
	public String readById(Model model, @PathVariable int id) throws SQLException {
		model.addAttribute("employees", repository.read());
		model.addAttribute("employee", repository.readById(id));
		return "index";
	}
	// null -> throw new EmployeeNotFoundException(id)
	
	// Creació:
	@PostMapping
	public String create(Model model, @Valid @RequestParam String name, @Valid @RequestParam EJob job) throws SQLException {
		repository.create(new Employee(name, job));
		return "redirect:/employees";
	}
	
	// Eliminació:
	@DeleteMapping("/{id}")
	@ResponseBody
	public void delete(Model model, @PathVariable int id) throws SQLException {
		repository.delete(id);
	}
	
	// Actualització:
	@PutMapping("/{id}")
	@ResponseBody
	public String update(Model model, @PathVariable int id, @Valid Employee employee) {//Map<String, String> json) throws SQLException {
		System.out.println(id + " " + employee.getName() + " " + employee.getJob());
		//System.out.println(id + " " + name + " " + job);
		//System.out.println(id + " " + json.get("name") + " " + json.get("job"));
		//new Employee(name, job).setId(id);
		/*System.out.println(employee.toString());
		
		employee.setId(id);
		employee.setSalary(EJob.valueOf(employee.getJob()).getSalary());
		
		System.out.println(employee.toString());
		
		repository.update(employee);*/
		return "redirect:/employees";
	}
	
	// Filtratge:
	@GetMapping(params = "job")
	public String filterByJob(Model model, @Valid @RequestParam EJob job) throws SQLException {
		model.addAttribute("employees", repository.filterByJob(job.name()));
		return "index";
	}
	
}
