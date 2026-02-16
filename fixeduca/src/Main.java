import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        List<Student> studentList = new ArrayList<>();
        ArrayInputSelector arrayInputSelector;

        while (true) {

            System.out.println("\n------------------------------" +
                    "\nЗаполнение списка" +
                    "\n   1. Заполнить из файла" +
                    "\n   2. Заполнить случайными значениями" +
                    "\n   3. Заполнить вручную" +
                    "\n---" +
                    "\nСортировка массива" +
                    "\n   4. Сортировать по номеру группы" +
                    "\n   5. Сортировать по среднему баллу" +
                    "\n   6. Сортировать по номеру зачётной книжки" +
                    "\n---" +
                    "\n   7. Вывести список студентов" +
                    "\n---" +
                    "\n   0. Выход" +
                    "\n------------------------------");

            System.out.print("\n--- Введите значение: ");

            Scanner input = new Scanner(System.in);
            if (input.hasNextInt()) {
                int userInput = input.nextInt();

                switch (userInput) {
                    case 1 -> {
                        studentList = new ArrayList<>();
                        arrayInputSelector = new ArrayInputSelector(new FromFileInput());
                        arrayInputSelector.arrayInput(studentList);
                    }
                    case 2 -> {
                        studentList = new ArrayList<>(new Random().nextInt(10 - 1 + 1) + 1);
                        arrayInputSelector = new ArrayInputSelector(new RNGInput());
                        arrayInputSelector.arrayInput(studentList);
                    }
                    case 3 -> {
                        studentList = new ArrayList<>();
                        arrayInputSelector = new ArrayInputSelector(new ManualInput());
                        arrayInputSelector.arrayInput(studentList);
                    }
                    case 4 -> {
                        if (!studentList.isEmpty()) {
                            studentList.sort(Comparator.comparing(Student::getGroupNumber));
                        }
                        else {
                            System.out.println("Список ещё не был заполнен");
                        }
                    }
                    case 5 -> {
                        if (!studentList.isEmpty()) {
                            studentList.sort(Comparator.comparingDouble(Student::getAverageGrades));
                        }
                        else {
                            System.out.println("Список ещё не был заполнен");
                        }
                    }
                    case 6 -> {
                        if (!studentList.isEmpty()) {
                            studentList.sort(Comparator.comparingInt(Student::getStudentId));
                        }
                        else {
                            System.out.println("Список ещё не был заполнен");
                        }
                    }
                    case 7 -> System.out.println(studentList);
                    case 0 -> System.exit(0);
                    default -> System.out.println("\n---Введите корректное значение---");
                }
            } else {
                System.out.println("\n---Введите корректное значение---");
            }
        }
    }
}