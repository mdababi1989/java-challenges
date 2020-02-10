package com.mdababi.lambdas.streams;

import java.util.ArrayList;
import java.util.List;

public class Departement {

	private String name;
	List<Employee> employees;

	public Departement(String name) {
		super();
		this.name = name;
		employees = new ArrayList<Employee>();
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

}
