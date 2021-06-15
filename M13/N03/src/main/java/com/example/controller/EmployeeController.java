package com.example.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import com.example.repository.InMemoryEmployeeRepository;
//import com.example.repository.MySqlJdbcEmployeeRepository;
//import com.example.service.MySqlJpaEmployeeService;
import com.example.domain.Employee;
import com.example.domain.EJob;
import com.example.controller.exception.EmployeeNotFoundException;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/employees")
public class EmployeeController {
	
	InMemoryEmployeeRepository repository = new InMemoryEmployeeRepository();
	//MySqlJdbcEmployeeRepository repository = new MySqlJdbcEmployeeRepository();
	//@Autowired
	//MySqlJpaEmployeeService repository;
	
	private final String
		STR_FORM = "form",
		STR_METHOD = "method",
		STR_LEGEND = "legend",
		STR_BTN = "btn";
	
	// Lectura:
	@GetMapping
	public String read(Model model) throws SQLException {
		model.addAttribute(STR_FORM, "create");
		model.addAttribute(STR_METHOD, "post");
		model.addAttribute(STR_LEGEND, "Nou empleat");
		model.addAttribute(STR_BTN, "Afegir");
		
		ArrayList<Employee> employees = repository.read();
		model.addAttribute("employees", employees);
		
		return "index";
	}
	
	@GetMapping("/{id}")
	public String readById(Model model, @PathVariable int id) throws SQLException {
		model.addAttribute(STR_FORM, "update");
		model.addAttribute(STR_METHOD, null);
		model.addAttribute(STR_LEGEND, "Actualització");
		model.addAttribute(STR_BTN, "Actualitzar");
		
		model.addAttribute("employees", repository.read());
		model.addAttribute("employee", repository.readById(id).orElseThrow(() -> new EmployeeNotFoundException(id)));

		model.addAttribute("index");
		
		return "index";
	}
	
	// Creació:
	@PostMapping
	public String create(@Valid @RequestParam String name, @Valid @RequestParam EJob job) throws SQLException {
		Employee employee = new Employee(name, job);
		
		repository.create(employee);
		
		return "redirect:/employees";
	}
	
	// Eliminació:
	@DeleteMapping("/{id}")
	@ResponseBody
	public void delete(@PathVariable int id) throws SQLException {
		// Comprovem que l'empleat existeixi:
		repository.readById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
		
		repository.delete(id);
	}
	
	// Actualització:
	@PutMapping("/{id}")
	@ResponseBody
	public void update(@PathVariable int id, @Valid @RequestBody Map<String, String> json) throws SQLException {
		// Comprovem que l'empleat existeixi:
		repository.readById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
		
		String name = json.get("name");
		EJob job = EJob.valueOf(json.get("job"));
		
		Employee employee = new Employee(name, job);
		employee.setId(id);
		
		repository.update(employee);
	}
	
	// Filtratge:
	@GetMapping(params = "job")
	public String filterByJob(Model model, @Valid @RequestParam EJob job) throws SQLException {
		model.addAttribute(STR_FORM, "create");
		model.addAttribute(STR_METHOD, "post");
		model.addAttribute(STR_LEGEND, "Nou empleat");
		model.addAttribute(STR_BTN, "Afegir");
		
		model.addAttribute("employees", repository.filterByJob(job.name()));

		model.addAttribute("index");
		
		return "index";
	}
	
}
