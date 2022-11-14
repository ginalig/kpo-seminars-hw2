package org.example;

import java.util.ArrayList;

public interface ISeminarService {
    Student getRandomStudent();
    ArrayList<Student> getStudentsWithGrades();
    void addGrade(Student student, Grade grade);
}
