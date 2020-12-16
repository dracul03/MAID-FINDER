package com.example.maidfinder;

public class userhelperclass2 {
    String skills;
    String workinghours;
    String expectedsal;
    String shift;

    userhelperclass2() {
    }

    public userhelperclass2(String skills, String workinghours, String expectedsal, String shift) {
        this.skills = skills;
        this.workinghours = workinghours;
        this.expectedsal = expectedsal;
        this.shift = shift;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getWorkinghours() {
        return workinghours;
    }

    public void setWorkinghours(String workinghours) {
        this.workinghours = workinghours;
    }

    public String getExpectedsal() {
        return expectedsal;
    }

    public void setExpectedsal(String expectedsal) {
        this.expectedsal = expectedsal;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
}