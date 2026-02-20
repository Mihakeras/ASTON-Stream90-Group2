package ru.aston.strategy;

import ru.aston.model.Student;

import java.util.List;

public class TestForStartegyDataFromConsole {
    public static void main(String[] args) {
        ContractForDataMining contract=new StartegyDataFromConsole();
        List<Student> students = contract.getData(5);

        students.stream().forEach(System.out::println);
    }
}
