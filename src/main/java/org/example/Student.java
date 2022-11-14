package org.example;

public class Student {
    Student(String name) {
       this.name = name;
       grade = null;
    }
    Student (String name, Grade grade) {
       this.name = name;
       this.grade = grade;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Grade getGrade() {
        return grade;
    }
    public void setGrade(Grade grade) {
        this.grade = grade;
    }
    private String name;
    private Grade grade;
}
