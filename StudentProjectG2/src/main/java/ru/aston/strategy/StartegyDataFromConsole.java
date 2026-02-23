package ru.aston.strategy;

import ru.aston.model.Student;
import ru.aston.validation.StudentValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartegyDataFromConsole implements ContractForDataMining {

    // Метод для проверки строки с консоли и возвращения значения в типе Integer

    private int getValueInCount(Scanner consol, AdaptorStudetnValidator operation, String message){
        int valueCount;
        String valueCountOnString;
        while (true){
            System.out.print(message);
            valueCountOnString = consol.nextLine();
            if(StudentValidator.isInteger(valueCountOnString) && operation.validator(Integer.parseInt(valueCountOnString))){
                valueCount = Integer.parseInt(valueCountOnString);
                break;
            }
        }
        return valueCount;
    }

    //Реализация переопределенного метода интерфейса ContractForDataMining

    @Override
    public List<Student> getData(int countStudents) {
        int numberOfGroup;
        int averageGrade;
        int numberOfRecordBook;
        List<Student> students = new ArrayList<Student>();
        Scanner consol = new Scanner(System.in);

        while (countStudents != students.size()){
            System.out.println("Ввод данных нового студента");
            numberOfGroup = getValueInCount(consol, AdaptorStudetnValidator.Group,"Введите номер группы: ");
            averageGrade = getValueInCount(consol, AdaptorStudetnValidator.Average, "Введите средний балл: ");
            numberOfRecordBook = getValueInCount(consol, AdaptorStudetnValidator.RecorBook,"Введите номер зачетной книжки: ");
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

    //Адаптор Класса StudentValidator для упрощеной работы в Классе StartegyDataFromConsole

    public enum AdaptorStudetnValidator{
        Group{
            @Override
            public boolean validator(int value) {
                return StudentValidator.validateGroup(value);
            }
        },
        Average{
            @Override
            public boolean validator(int value) {
                return StudentValidator.validateAverage(value);
            }
        },
        RecorBook{
            @Override
            public boolean validator(int value) {
                return StudentValidator.validateRecordBook(value);
            }
        };
        public abstract boolean validator(int value);
    }
}
