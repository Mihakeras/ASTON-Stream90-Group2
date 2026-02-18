package ru.aston.strategy;

import ru.aston.model.Student;

import java.util.List;
import java.util.Scanner;

public class StartegyDataFromConsole implements ContractForDataMining {

    public void arrayInput(List<Student> studentList) {

        int numberOfGroup;
        int averageGrade;
        int numberOfRecordBook;

        Scanner input = new Scanner(System.in);

        System.out.print("\nВведите длину списка: ");

        if (input.hasNextInt()) {
            int manualCount = input.nextInt();
            do {
                System.out.print("\nВведите номер группы: ");
                input = new Scanner(System.in);
                if (input.hasNextInt()) {
                    numberOfGroup = input.nextInt();
                } else {
                    studentList.clear();
                    System.out.println("\n---Введите корректное значение---");
                    break;
                }
                if (!(numberOfGroup >= 1 && numberOfGroup <= 10)) {
                    studentList.clear();
                    System.out.println("\n---Введите корректное значение---");
                    break;
                }

                System.out.print("\nВведите средний балл: ");
                input = new Scanner(System.in);
                if (input.hasNextInt()) {
                    averageGrade = input.nextInt();
                } else {
                    studentList.clear();
                    System.out.println("\n---Введите корректное значение---");
                    break;
                }
                if (!(averageGrade >= 1 && averageGrade <= 5)) {
                    studentList.clear();
                    System.out.println("\n---Введите корректное значение---");
                    break;
                }

                System.out.print("\nВведите номер зачётной книжки: ");
                input = new Scanner(System.in);
                if (input.hasNextInt()) {
                    numberOfRecordBook = input.nextInt();
                } else {
                    studentList.clear();
                    System.out.println("\n---Введите корректное значение---");
                    break;
                }
                if (!(numberOfRecordBook >= 100000 && numberOfRecordBook <= 999999)) {
                    studentList.clear();
                    System.out.println("\n---Введите корректное значение---");
                    break;
                }

                studentList.add(new Student.BuilderStudent(numberOfGroup, averageGrade, numberOfRecordBook)
                        .setNumberOfGroup(numberOfGroup)
                        .setAverageGrade(averageGrade)
                        .setNumberOfRecordBook(numberOfRecordBook)
                        .build());
                manualCount--;

            } while (manualCount > 0);

        } else {
            studentList.clear();
            System.out.println("\n---Введите корректное значение---");
        }

        if (!studentList.isEmpty()) {
            System.out.println("\nСписок заполнен");
        }
    }
}
