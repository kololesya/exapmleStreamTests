package org.example;

import java.util.List;

public class EmployeeTest {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final List<String> skills;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public int getAge(){
        return age;
    }

    public List<String> getSkills(){
        return skills;
    }

    public EmployeeTest(String firstName, String lastName, int age, List<String> skills){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.skills = skills;
    }

    @Override
    public String toString(){
        return String.format("Employee (firstName=%s, lastName=%s, age=%d; skills=%s)", firstName, lastName, age, skills);
    }
}
