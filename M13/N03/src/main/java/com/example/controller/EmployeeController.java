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
import org.springframework.http.HttpStatus;
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
		model.addAttribute("form", "create");
		model.addAttribute("method", "post");
		model.addAttribute("legend", "Nou empleat");
		model.addAttribute("btn", "Afegir");
		
		model.addAttribute("employees", repository.read());
		return "index";
	}
	
	@GetMapping("/{id}")
	public String readById(Model model, @PathVariable int id) throws SQLException {
		model.addAttribute("form", "update");
		model.addAttribute("method", null);
		model.addAttribute("legend", "Actualització");
		model.addAttribute("btn", "Actualitzar");
		
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
	public void update(Model model, @PathVariable int id, @Valid @RequestBody Map<String, String> json) throws SQLException {
		String name = json.get("name");
		EJob job = EJob.valueOf(json.get("job"));
		
		Employee employee = new Employee(name, job);
		employee.setId(id);
		
		repository.update(employee);
	}
	
	// Filtratge:
	@GetMapping(params = "job")
	public String filterByJob(Model model, @Valid @RequestParam EJob job) throws SQLException {
		model.addAttribute("form", "create");
		model.addAttribute("method", "post");
		model.addAttribute("legend", "Nou empleat");
		model.addAttribute("btn", "Afegir");
		
		model.addAttribute("employees", repository.filterByJob(job.name()));
		return "index";
	}
	
}
