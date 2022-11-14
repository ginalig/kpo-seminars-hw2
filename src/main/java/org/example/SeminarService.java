package org.example;

import java.util.ArrayList;
import java.util.Random;

public class SeminarService implements ISeminarService {
    private final ArrayList<Student> students = new ArrayList<>();
    private final Random random = new Random();

    public SeminarService() {
        students.add(new Student("John"));
        students.add(new Student("Jane"));
        students.add(new Student("Jack"));
        students.add(new Student("Jill"));
        students.add(new Student("Jenny"));
    }

    public Student getRandomStudent() {
        var studentsWithoutGrades = getStudentsWithoutGrades();
        if (studentsWithoutGrades.isEmpty()) {
            return null;
        }
        return studentsWithoutGrades.get(random.nextInt(studentsWithoutGrades.size()));
    }
    public ArrayList<Student> getStudentsWithoutGrades() {
        var studentsWithGrades = new ArrayList<Student>();
        for (var student : students) {
            if (student.getGrade() == null) {
                studentsWithGrades.add(student);
            }
        }
        return studentsWithGrades;
    }
    public ArrayList<Student> getStudentsWithGrades() {
        var studentsWithGrades = new ArrayList<Student>();
        for (var student : students) {
            if (student.getGrade() != null) {
                studentsWithGrades.add(student);
            }
        }
        return studentsWithGrades;
    }
    public void addGrade(Student student, Grade grade) {
        for (var s : students) {
            if (s.getName().equals(student.getName())) {
                s.setGrade(grade);
            }
        }
    }
    public void getAllStudents() {
        for (var s : students) {
            System.out.println(s.getName() + " " + s.getGrade());
        }
    }
}
