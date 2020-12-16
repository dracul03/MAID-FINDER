package com.example.maidfinder;

public class helperclass3 {
    String Skills, salary, email, name, shift;

    helperclass3() {
    }

    public helperclass3(String skills, String name, String salary, String shift, String email) {
        Skills = skills;
        this.salary = salary;
        this.email = email;
        this.name = name;
        this.shift = shift;
    }

    public String getSkills() {
        return Skills;
    }

    public void setSkills(String skills) {
        Skills = skills;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
}

