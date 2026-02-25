//Котеля Иван
package aston.sorting;

import ru.aston.model.Student;
import ru.aston.sorting.StudentSorter;

import java.util.ArrayList;
import java.util.List;

public class TestStudentSorter {
    static void main(String[] args) {

        // позитивный кейс

        try {
            System.out.println("Позитивный кейс");
            StudentSorter sorter = new StudentSorter();
            List<Student> students = new ArrayList<Student>();
            students.add(Student.builderStudent().setNumberOfGroup(6).setNumberOfRecordBook(1123).setAverageGrade(12312).build());
            students.add(Student.builderStudent().setNumberOfGroup(1).setNumberOfRecordBook(1152).setAverageGrade(32423).build());
            students.add(Student.builderStudent().setNumberOfGroup(2).setNumberOfRecordBook(1521).setAverageGrade(54654).build());
            students.add(Student.builderStudent().setNumberOfGroup(5).setNumberOfRecordBook(5121).setAverageGrade(325).build());
            students.add(Student.builderStudent().setNumberOfGroup(4).setNumberOfRecordBook(6132).setAverageGrade(6865).build());
            students.add(Student.builderStudent().setNumberOfGroup(1).setNumberOfRecordBook(112312).setAverageGrade(234).build());
            students.add(Student.builderStudent().setNumberOfGroup(8).setNumberOfRecordBook(1232).setAverageGrade(63556).build());
            students.add(Student.builderStudent().setNumberOfGroup(9).setNumberOfRecordBook(7421442).setAverageGrade(686556).build());
            students.add(Student.builderStudent().setNumberOfGroup(2).setNumberOfRecordBook(122).setAverageGrade(667556).build());
            students.add(Student.builderStudent().setNumberOfGroup(7).setNumberOfRecordBook(7424642).setAverageGrade(68756).build());

            students.forEach(System.out::println);
            System.out.println();
            sorter.sortStudents(students);
            students.forEach(System.out::println);
            System.out.println("Кейс успешно отработал код");
        }catch (Exception e){
            System.out.println("Ошибка кода");
        }

        // негативный кейс

        /*try {
            StudentSorter sorter = new StudentSorter();
            List<Student> students = new ArrayList<Student>();
            students.add(Student.builderStudent().setNumberOfGroup("asd").setNumberOfRecordBook(1123).setAverageGrade(12312).build());
            students.add(Student.builderStudent().setNumberOfGroup(1).setNumberOfRecordBook(1152).setAverageGrade(32423).build());
            students.add(Student.builderStudent().setNumberOfGroup(2).setNumberOfRecordBook(1521).setAverageGrade(54654).build());
            students.add(Student.builderStudent().setNumberOfGroup(5).setNumberOfRecordBook(5121).setAverageGrade(325).build());
            students.add(Student.builderStudent().setNumberOfGroup(4).setNumberOfRecordBook(6132).setAverageGrade(6865).build());
            students.add(Student.builderStudent().setNumberOfGroup(1).setNumberOfRecordBook("asd").setAverageGrade(234).build());
            students.add(Student.builderStudent().setNumberOfGroup(8).setNumberOfRecordBook(1232).setAverageGrade(63556).build());
            students.add(Student.builderStudent().setNumberOfGroup(9).setNumberOfRecordBook(7421442).setAverageGrade("asd").build());
            students.add(Student.builderStudent().setNumberOfGroup(2).setNumberOfRecordBook(122).setAverageGrade(667556).build());
            students.add(Student.builderStudent().setNumberOfGroup(7).setNumberOfRecordBook(7424642).setAverageGrade(68756).build());

            students.forEach(System.out::println);
            System.out.println();
            sorter.sortStudents(students);
            students.forEach(System.out::println);
        }catch (Exception e){
            System.out.println("Ошибка кода");
        }*/

        // негативный кейс

        try {
            System.out.println("Негативный кейс");
            StudentSorter sorter = new StudentSorter();
            List<Student> students = new ArrayList<Student>();
            students.add(Student.builderStudent().setNumberOfGroup(-1).setNumberOfRecordBook(1123).setAverageGrade(12312).build());
            students.add(Student.builderStudent().setNumberOfGroup(1).setNumberOfRecordBook(1152).setAverageGrade(32423).build());
            students.add(Student.builderStudent().setNumberOfGroup(2).setNumberOfRecordBook(1521).setAverageGrade(-54654).build());
            students.add(Student.builderStudent().setNumberOfGroup(5).setNumberOfRecordBook(5121).setAverageGrade(325).build());
            students.add(Student.builderStudent().setNumberOfGroup(4).setNumberOfRecordBook(6132).setAverageGrade(6865).build());
            students.add(Student.builderStudent().setNumberOfGroup(-1).setNumberOfRecordBook(-132132).setAverageGrade(234).build());
            students.add(Student.builderStudent().setNumberOfGroup(8).setNumberOfRecordBook(1232).setAverageGrade(63556).build());
            students.add(Student.builderStudent().setNumberOfGroup(9).setNumberOfRecordBook(-7421442).setAverageGrade(-712).build());
            students.add(Student.builderStudent().setNumberOfGroup(2).setNumberOfRecordBook(122).setAverageGrade(667556).build());
            students.add(Student.builderStudent().setNumberOfGroup(7).setNumberOfRecordBook(7424642).setAverageGrade(68756).build());

            students.forEach(System.out::println);
            System.out.println();
            sorter.sortStudents(students);
            students.forEach(System.out::println);
            System.out.println("Кейс успешно отработал код");
        }catch (Exception e){
            System.out.println("Ошибка кода");
        }
    }
}
