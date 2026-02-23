package aston.model;

import ru.aston.model.Student;

public class TestStudent {
    static void main(String[] args) {
        Student student = Student.builderStudent()
                .setNumberOfGroup(2)
                .setNumberOfRecordBook(1232)
                .setAverageGrade(123).build();

        System.out.println(student);
    }
}
