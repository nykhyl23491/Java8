package com.app.emp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeTest {
	public static void main(String[] args) 
	{
		Employee employee1 = new Employee("Yash", 20, new Address("1234"),
				Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

		Employee employee2 = new Employee("Ram", 20, new Address("1235"),
				Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

		Employee employee3 = new Employee("Ram", 20, new Address("1236"),
				Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));

		List<Employee> employees = Arrays.asList(employee1, employee2, employee3);

		Stream<Employee> empStream = employees.stream();

		// Get employee with exact match name "Yash", if not found print "Not found".
		System.out.println("Case 1 ::");
		Optional obj = employees.stream().filter(emp -> emp.getName().equals("Yash")).findAny();
		System.out.println(obj.orElseGet(() -> "Not found"));

		// Get employee with matching address "1235"
		System.out.println("Case 2 ::");
		employees.stream().filter(emp -> emp.getAddress().getZipcode().equals("1235")).forEach(System.out::println);

		// Get all employee having mobile numbers 3333.
		System.out.println("Case 3 ::");
		// employees.stream().filter(emp -> emp.getMobileNumbers().contains(new
		// MobileNumber("3333"))).forEach(System.out::println);

		List<Employee> eList = employees.stream()
				.filter(emp -> emp.getMobileNumbers().stream().anyMatch(number -> number.getNumber().equals("3333")))
				.collect(Collectors.toList());

		// Convert List<Employee> to List<String> of employee name
		System.out.println("Case 4 ::");
		List<String> names = employees.stream().map(emp -> emp.getName()).collect(Collectors.toList());
		names.forEach(System.out::println);

		// Collect all the names of employees in a string separated by ||
		System.out.println("Case 5 ::");
		String nameString = employees.stream().map(emp -> emp.getName()).collect(Collectors.joining("||"));
		System.out.println(nameString);

		// Change the case of List<String>
		System.out.println("Case 6 ::");
		names.stream().map(name -> name.toUpperCase()).forEach(System.out::println);

		// Sort List<String>
		System.out.println("Case 7 ::");
		names.stream().sorted().forEach(System.out::println);

		// sort List<Employee> based on name
		System.out.println("Case 8 ::");
		Comparator<Employee> comparator = Comparator.comparing(Employee::getName);
		employees.stream().sorted(comparator).forEach(System.out::println);
	}

}
