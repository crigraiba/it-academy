package com.example.repository;

import java.util.ArrayList;
import java.util.Optional;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.example.domain.Employee;

@Repository
public class MySqlJdbcEmployeeRepository {

	private Connection conn;
	
	public MySqlJdbcEmployeeRepository() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // JDBC driver for MySQL (Connector/J)
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", ""); // url, username, password
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("La connexió no ha estat possible.");
		}
	}
	
	// Lectura:
	public ArrayList<Employee> read() throws SQLException {
		String query = "SELECT *"
			+ " FROM employees";
		
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(query);
		
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		while (rs.next())
			employees.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
		
		return employees;
	}
	
	public Optional<Employee> readById(int id) throws SQLException {
		String query = "SELECT *"
			+ " FROM employees"
			+ " WHERE id = " + id;
		
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(query);
		
		if (rs.next())
			return Optional.of(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
		
		return Optional.empty();
	}
	
	// Creació:
	public void create(Employee employee) throws SQLException {
		String query = "INSERT INTO employees (name, job, salary)"
			+ " VALUES (?, ?, ?)";
			
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, employee.getName());
		ps.setString(2, employee.getJob());
		ps.setDouble(3, employee.getSalary());
		
		ps.executeUpdate();
	}
	
	// Eliminació:
	public void delete(int id) throws SQLException {
		String query = "DELETE FROM employees"
			+ " WHERE id = " + id;
		
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.executeUpdate();
	}
	
	// Actualització:
	public void update(Employee employee) throws SQLException{
		String query = "UPDATE employees"
			+ " SET name = ?, job = ?, salary = ?"
			+ " WHERE id = ?";
		
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, employee.getName());
		ps.setString(2, employee.getJob());
		ps.setDouble(3, employee.getSalary());
		ps.setInt(4, employee.getId());
		
		ps.executeUpdate();
	}
	
	// Filtratge:
	public ArrayList<Employee> filterByJob(String job) throws SQLException {
		String query = "SELECT *"
				+ " FROM employees"
				+ " WHERE job = '" + job + "'";
		
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(query);
		
		ArrayList<Employee> employees = new ArrayList<>();
		
		while (rs.next())
			employees.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
		
		return employees;
	}
	
}
