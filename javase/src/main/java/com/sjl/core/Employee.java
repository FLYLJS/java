package com.sjl.core;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Employee implements Comparable<Employee>{

    private String name;
    private int age;
    private double salary;

    public Employee() {
    }

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee employee) {
        return Double.compare(salary,employee.salary);
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(new Employee("zs", 15, 100),
                new Employee("ls", 16, 99),
                new Employee("ww", 12, 110));
        Collections.sort(employees);
      employees.stream()
              .forEach(employee ->
                      System.out.println(employee));

    }
}
