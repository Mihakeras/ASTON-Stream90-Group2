package ru.aston.strategy;

import ru.aston.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StrategyDataFromRandom implements ContractForDataMining {

    public List<Student> getData(int numberOfStudents) {

        int numberOfGroup, averageGrade, numberOfRecordBook;

        List<Student> students = new ArrayList<>();

        do {
            numberOfGroup = new Random().nextInt(1, 20);
            averageGrade = new Random().nextInt(1, 5);
            numberOfRecordBook = new Random().nextInt(100000, 999999);

            students.add(Student.builderStudent()
                    .setNumberOfGroup(numberOfGroup)
                    .setAverageGrade(averageGrade)
                    .setNumberOfRecordBook(numberOfRecordBook)
                    .build());
            numberOfStudents--;

        } while (numberOfStudents > 0);

        System.out.println("\nСписок заполнен");
        return students;
    }
}
