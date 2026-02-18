package ru.aston.model;

import java.util.ArrayList;
import java.util.List;

public class ListStudents {

    public List<Student> students;
//    public Какой-то интерфейс


    public ListStudents() {
        students = new ArrayList<Student>();
    }

    public List<Student> getStudents() {
        return students;
    }

    /*public void sortedListStudent(){
        students.sort(ForSorted.numberOfGroup.thenComparing(ForSorted.averageGrade).thenComparing(ForSorted.numberOfRecordBook));
    }*/

}
