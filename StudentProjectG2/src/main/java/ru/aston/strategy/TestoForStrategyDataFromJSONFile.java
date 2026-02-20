package ru.aston.strategy;

import ru.aston.model.Student;

import java.util.List;

public class TestoForStrategyDataFromJSONFile
{
    static void main()
    {
        StrategyDataFromJSONFile dataFromJSONFileHandler = new StrategyDataFromJSONFile();
        List<Student> listOfStudents = dataFromJSONFileHandler.getData(10);
        listOfStudents.stream().forEach(System.out::println);

    }
}
