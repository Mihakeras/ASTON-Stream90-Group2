package ru.aston.model.Sorting;

import ru.aston.model.Student;

import java.util.List;

public class Sort {
    public void sortedListStudent(List<Student> students){
        students.sort(ForSorted.numberOfGroup.thenComparing(ForSorted.averageGrade).thenComparing(ForSorted.numberOfRecordBook));
    }
}
