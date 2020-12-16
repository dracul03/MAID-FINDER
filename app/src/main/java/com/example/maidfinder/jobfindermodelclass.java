package com.example.maidfinder;

import de.hdodenhof.circleimageview.CircleImageView;

public class jobfindermodelclass {
    String name,skills,email,salary;
    CircleImageView purl;
    jobfindermodelclass(){}

    public jobfindermodelclass(String name, String skills, String email, String salary) {
        this.name = name;
        this.skills = skills;
        this.email = email;
        this.salary= salary;
        this.purl=purl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getskills() {
        return skills;
    }

    public void setSkill(String Skill) {
        this.skills = Skill;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary= salary;
    }
    public void setPurl(CircleImageView purl){
        this.purl=purl;
    }
    public CircleImageView getPurl() {
        return purl;
    }


}

