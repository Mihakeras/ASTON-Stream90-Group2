package ru.aston.strategy;

import ru.aston.model.Student;

import java.util.List;

public interface ContractForDataMining {

    abstract List<Student> getData(int amountOfStudents);
}
