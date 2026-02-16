import java.util.List;
import java.util.Scanner;

public class ManualInput implements ArrayInputStrategy {

    public void arrayInput(List<Student> studentList) {

        String groupNumber;
        double averageGrades;
        int studentId;

        Scanner input = new Scanner(System.in);

        System.out.print("\nВведите длину списка: ");

        if (input.hasNextInt()) {
            int manualCount = input.nextInt();
            do {
                System.out.print("\nВведите номер группы: ");
                input = new Scanner(System.in);
                groupNumber = input.nextLine();
                boolean correctGroupNumber = groupNumber.matches("[А-ЯЁ]{1}-\\d{2}");
                if (!correctGroupNumber) {
                    studentList.clear();
                    System.out.println("\n---Введите корректное значение---");
                    break;
                }

                System.out.print("\nВведите средний балл: ");
                input = new Scanner(System.in);
                if (input.hasNextDouble()) {
                    averageGrades = input.nextDouble();
                } else {
                    studentList.clear();
                    System.out.println("\n---Введите корректное значение---");
                    break;
                }
                if (!(averageGrades >= 2 && averageGrades <= 5)) {
                    studentList.clear();
                    System.out.println("\n---Введите корректное значение---");
                    break;
                }

                System.out.print("\nВведите номер зачётной книжки: ");
                input = new Scanner(System.in);
                if (input.hasNextInt()) {
                    studentId = input.nextInt();
                } else {
                    studentList.clear();
                    System.out.println("\n---Введите корректное значение---");
                    break;
                }
                if (!(studentId >= 10000000 && studentId <= 99999999)) {
                    studentList.clear();
                    System.out.println("\n---Введите корректное значение---");
                    break;
                }

                studentList.add(new Student(groupNumber, averageGrades, studentId));
                manualCount--;

            } while (manualCount > 0);

        } else {
            studentList.clear();
            System.out.println("\n---Введите корректное значение---");
        }

        if (!studentList.isEmpty()) {
            System.out.println("\nСписок заполнен");
        }
    }
}
