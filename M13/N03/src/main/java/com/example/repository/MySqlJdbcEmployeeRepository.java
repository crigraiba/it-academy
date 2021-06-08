package com.example.repository;

import java.util.ArrayList;
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

	private Connection connection;
	
	public MySqlJdbcEmployeeRepository() { // throws ClassNotFoundException, SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // JDBC driver for MySQL (Connector/J)
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", ""); // url, username, password
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("La connexió no ha estat possible.");
		}
	}
	
	// Lectura:
	public ArrayList<Employee> read() throws SQLException {
		String query = "SELECT *"
			+ " FROM employees";
		
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		while (rs.next())
			employees.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
		
		return employees;
	}
	
	public Employee readById(int id) throws SQLException {
		String query = "SELECT *"
			+ " FROM employees"
			+ " WHERE id = " + id;
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		
		if (resultSet.next())
			return new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4));
		else
			return null;
	}
	
	// Creació:
	public void create(Employee employee) throws SQLException {
		String query = "INSERT INTO employees (name, job, salary)"//id, name, job, salary)\"
			+ " VALUES (?, ?, ?)";
			
		PreparedStatement preparedStatement = connection.prepareStatement(query);

		//preparedStatement.setInt(1, employee.getId());
		preparedStatement.setString(1, employee.getName());
		preparedStatement.setString(2, employee.getJob());
		preparedStatement.setDouble(3, employee.getSalary());
		
		preparedStatement.executeUpdate();
	}
	
	// Eliminació:
	public void delete(int id) throws SQLException {
		String query = "DELETE FROM employees"
			+ " WHERE id = " + id;
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.executeUpdate();
	}
	
	// Actualització:
	public void update(Employee employee) throws SQLException{
		String query = "UPDATE employees"
			+ " SET name = ?, job = ?, salary = ?"
			+ " WHERE id = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setString(1, employee.getName());
		preparedStatement.setString(2, employee.getJob());
		preparedStatement.setDouble(3, employee.getSalary());
		preparedStatement.setInt(4, employee.getId());
		
		preparedStatement.executeUpdate();
	}
	
	// Filtratge:
	public ArrayList<Employee> filterByJob(String job) throws SQLException {
		String query = "SELECT *"
				+ " FROM employees"
				+ " WHERE job = '" + job + "'";
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		
		ArrayList<Employee> employees = new ArrayList<>();
		
		while (resultSet.next())
			employees.add(new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4)));
		
		return employees;
	}
	
}
