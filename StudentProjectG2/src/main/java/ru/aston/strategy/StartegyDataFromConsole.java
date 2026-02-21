package ru.aston.strategy;

import ru.aston.model.Student;
import ru.aston.validation.StudentValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartegyDataFromConsole implements ContractForDataMining {

    // Метод для проверки строки с консоли и возвращения значения в типе Integer

    private int getValueInCount(Scanner consol, int numberOperation){
        int valueCount;
        String valueCountOnString;
        while (true){
            valueCountOnString = consol.nextLine();
            if(StudentValidator.isInteger(valueCountOnString) &&
                    (numberOperation == 1 ? StudentValidator.validateGroup(Integer.parseInt(valueCountOnString))
                    : numberOperation == 2 ? StudentValidator.validateAverage(Integer.parseInt(valueCountOnString))
                    :StudentValidator.validateRecordBook(Integer.parseInt(valueCountOnString)))){
                valueCount = Integer.parseInt(valueCountOnString);
                break;
            }
        }
        return valueCount;
    }

    //Реализация переопределенного метода интерфейса ContractForDataMining

    @Override
    public List<Student> getData(int countStudents) {
        int numberOperation;
        int numberOfGroup;
        int averageGrade;
        int numberOfRecordBook;
        List<Student> students = new ArrayList<Student>();
        Scanner consol = new Scanner(System.in);

        while (countStudents != students.size()){
            numberOperation = 0;
            System.out.println("Ввод данных нового студента");
            System.out.println("Введите номер группы:");
            numberOperation = 1;
            numberOfGroup = getValueInCount(consol,numberOperation);
            System.out.println("Введите средний балл:");
            numberOperation = 2;
            averageGrade = getValueInCount(consol,numberOperation);
            System.out.println("Введите номер зачетной книжки:");
            numberOperation = 3;
            numberOfRecordBook = getValueInCount(consol,numberOperation);
            students.add(Student.builderStudent().
                    setNumberOfGroup(numberOfGroup).
                    setAverageGrade(averageGrade).
                    setNumberOfRecordBook(numberOfRecordBook).
                    build());
            System.out.print("\n");
        }

        System.out.println("Список заполнен");
        return students;
    }
}
