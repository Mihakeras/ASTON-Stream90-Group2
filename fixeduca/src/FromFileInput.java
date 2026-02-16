import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class FromFileInput implements ArrayInputStrategy {

    public void arrayInput(List<Student> studentList) throws FileNotFoundException {

        String groupNumber = null;
        double averageGrades = 0;
        int studentId = 0;

        Scanner fileScan = new Scanner(new File("students.txt"));

        while (fileScan.hasNextLine()) {

            String line = fileScan.nextLine();

            if (line.isEmpty()) {
                if (groupNumber != null && averageGrades != 0 && studentId != 0) {
                    boolean correctGroupNumber = groupNumber.matches("[А-ЯЁ]{1}-\\d{2}");

                    if (correctGroupNumber &&
                            (averageGrades >= 2 && averageGrades <= 5) &&
                            (studentId >= 10000000 && studentId <= 99999999)) {

                        studentList.add(new Student(groupNumber, averageGrades, studentId));

                        groupNumber = null;
                        averageGrades = 0;
                        studentId = 0;
                    } else {
                        studentList.clear();
                        System.out.println("\n---Введите корректное значение---");
                        break;
                    }
                    continue;
                }
            }

            String[] lineValue = line.split(":");

            switch (lineValue[0]) {

                case "groupNumber" -> groupNumber = lineValue[1];
                case "averageGrades" -> averageGrades = Double.parseDouble(lineValue[1]);
                case "studentId" -> studentId = Integer.parseInt(lineValue[1]);
            }
        }
        if (!studentList.isEmpty()) {
            System.out.println("\nСписок заполнен");
        }
    }
}
