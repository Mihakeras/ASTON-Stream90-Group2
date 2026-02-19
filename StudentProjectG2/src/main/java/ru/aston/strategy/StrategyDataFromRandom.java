package ru.aston.strategy;

import ru.aston.model.Student;
import ru.aston.validation.StudentValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StrategyDataFromRandom implements ContractForDataMining {

    public List<Student> getData(int numberOfStudents) {

        int numberOfGroup, averageGrade, numberOfRecordBook;

        List<Student> students = new ArrayList<>();

        do {
            numberOfGroup = new Random().nextInt(1, 20+1);
            averageGrade = new Random().nextInt(1, 5+1);
            numberOfRecordBook = new Random().nextInt(100000, 999999+1);

            if (StudentValidator.isValid(numberOfGroup, averageGrade, numberOfRecordBook)) {
                students.add(Student.builderStudent()
                        .setNumberOfGroup(numberOfGroup)
                        .setAverageGrade(averageGrade)
                        .setNumberOfRecordBook(numberOfRecordBook)
                        .build());
                numberOfStudents--;
            } else {
                students.clear();
                System.out.println("Ошибка в коде");
            }
        } while (numberOfStudents > 0);

        if (!students.isEmpty()) {
            System.out.println("\nСписок заполнен");
        }

        return students;
    }
}
