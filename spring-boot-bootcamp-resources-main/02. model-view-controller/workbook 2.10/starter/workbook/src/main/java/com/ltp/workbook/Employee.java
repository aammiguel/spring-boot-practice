package com.ltp.workbook;

public class Employee
{
    private final String name;
    private final int age;
    private final String role;


    public Employee(final String name,
                    final int age,
                    final String role)
    {
        this.name = name;
        this.age = age;
        this.role = role;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getRole() {
        return role;
    }



}
