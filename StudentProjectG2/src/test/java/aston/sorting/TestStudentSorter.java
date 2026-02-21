package aston.sorting;

import ru.aston.model.Student;
import ru.aston.sorting.StudentSorter;

import java.util.ArrayList;
import java.util.List;

public class TestStudentSorter {
    static void main(String[] args) {
        StudentSorter sorter = new StudentSorter();
        List<Student> students = new ArrayList<Student>();
        students.add(Student.builderStudent().setNumberOfGroup(2).setNumberOfRecordBook(1123).setAverageGrade(12312).build());
        students.add(Student.builderStudent().setNumberOfGroup(1).setNumberOfRecordBook(1152).setAverageGrade(32423).build());
        students.add(Student.builderStudent().setNumberOfGroup(2).setNumberOfRecordBook(1521).setAverageGrade(54654).build());
        students.add(Student.builderStudent().setNumberOfGroup(5).setNumberOfRecordBook(5121).setAverageGrade(325).build());
        students.add(Student.builderStudent().setNumberOfGroup(4).setNumberOfRecordBook(6132).setAverageGrade(6865).build());
        students.add(Student.builderStudent().setNumberOfGroup(4).setNumberOfRecordBook(112312).setAverageGrade(234).build());
        students.add(Student.builderStudent().setNumberOfGroup(2).setNumberOfRecordBook(745342).setAverageGrade(6856).build());
        sorter.sortStudents(students);
        students.forEach(System.out::println);
    }
}
