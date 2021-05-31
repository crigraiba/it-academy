package com.example.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.domain.Employee;
import com.example.domain.EJob;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	InMemoryEmployeeRepository repository;
	
	// Lectura:
	@GetMapping
	@ResponseBody
	/*public String read(Model model) {
		model.addAttribute("employees", repository.read());
		return "index";
	}*/
	public ArrayList<Employee> read() {
		return repository.read();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	/*public String readById(Model model, RedirectAttributes ra, @PathVariable int id) {
		ra.addFlashAttribute("employee", repository.readById(id));
		return "redirect:/employees";
	}*/
	public Employee readById(@PathVariable int id) {
		return repository.readById(id);
	}
	
	// Creació:
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) // 201
	/*public String create(Model model, @Valid @RequestBody Employee employee) {
		repository.create(new Employee("creació", EJob.ADVOCAT));
		return "redirect:/employees";
	}*/
	public void create() {
		repository.create(new Employee("creació", EJob.ADVOCAT));
	}
	
	// Eliminació:
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // 204
	/*public String delete(Model model, @PathVariable int id) {
		repository.delete(id);
		return "redirect:/employees";
	}*/
	public void delete(@PathVariable int id) {
		repository.delete(id);
	}
	
	// Actualització:
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK) // 200
	/*public String update(Model model, @PathVariable int id, @Valid @RequestBody Employee employee) {
		repository.update(new Employee("actualització", EJob.ADVOCAT));
		return "redirect:/employees";
	}*/
	public void update(@PathVariable int id) {
		Employee employee = new Employee();
		
		employee.setId(id);
		employee.setName("actualització");
		employee.setJob(EJob.ADVOCAT.name());
		employee.setSalary(EJob.ADVOCAT.getSalary());
		
		repository.update(employee);
	}
	
	// Filtratge:
	@GetMapping(params = "job")
	@ResponseBody
	/*public String filterByJob(Model model, @Valid @RequestParam EJob job) {
		model.addAttribute("employees", repository.filterByJob(job.name()));
		return "index";
	}*/
	public ArrayList<Employee> filterByJob(@RequestParam EJob job) {
		return repository.filterByJob(job.name());
	}
	
}
