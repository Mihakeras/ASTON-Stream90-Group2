package ru.aston.sorting;

import ru.aston.model.Student;

import java.util.List;

public class StudentSorter {
    public void sortStudents(List<Student> students){
        students.sort(ForSorted.numberOfGroup.thenComparing(ForSorted.averageGrade).thenComparing(ForSorted.numberOfRecordBook));
    }
}
