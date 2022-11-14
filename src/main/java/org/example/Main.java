package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        ISeminarService seminarService = new SeminarService();
        var br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("СПИСОК КОМАНД: /h");
        label:
        while (true) {
            System.out.print("> ");
            var command = br.readLine();
            switch (command) {
                case "/r":
                    var student = seminarService.getRandomStudent();
                    if (student == null) {
                        System.out.println("У всех студентов уже есть оценка");
                    } else {
                        System.out.println("Отвечает Студент " + student.getName());
                        System.out.println("Студент присутсвует на семинаре? (y/n)");
                        System.out.print("> ");
                        command = br.readLine();
                        if (command.equals("y")) {
                            System.out.print("Введите оценку: ");
                            command = br.readLine();
                            var grade = new Grade(Integer.parseInt(command));
                            seminarService.addGrade(student, grade);
                        } else {
                            seminarService.addGrade(student, new Grade(0));
                        }
                    }
                    break;
                case "/l":
                    var students = seminarService.getStudentsWithGrades();
                    if (students.isEmpty()) {
                        System.out.println("Нет студентов с оценками");
                    } else {
                        for (var s : students) {
                            System.out.println("Студент " + s.getName() + " получил оценку " + s.getGrade().getValue());
                        }
                    }
                    break;

                case "/h":
                    System.out.println("Список команд:");
                    System.out.println("/r - выбрать случайного студента");
                    System.out.println("/l - вывести список студентов с оценками");
                    System.out.println("/h - вывести список команд");
                    System.out.println("/q - выйти из программы");
                    break;
                case "/q":
                    break label;
            }

        }
    }
}