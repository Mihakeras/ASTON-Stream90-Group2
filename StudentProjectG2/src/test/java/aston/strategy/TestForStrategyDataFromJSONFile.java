// автор Даниил Конев
package aston.strategy;

import ru.aston.model.Student;
import ru.aston.strategy.StrategyDataFromJSONFile;

import java.util.List;

public class TestForStrategyDataFromJSONFile {
    static private void positiveTest() {
        System.out.println("\n\n\n\n"); // это, чтобы отступить в консоли от предыдущего вывода
        System.out.println("-".repeat(50) + "Начался позитивный тест" + "-".repeat(50)); // для оформления заголовка
        System.out.println("В него передано int numberOfStudents = 10;");

        int numberOfStudents = 10; // это нормальное значение, ошибочным являются 0 и отрицательные
        // и большие - больше 30.
        StrategyDataFromJSONFile dataFromJSONFileHandler = new StrategyDataFromJSONFile();
        List<Student> listOfStudents = dataFromJSONFileHandler.getData(numberOfStudents);
        listOfStudents.forEach(System.out::println); // оказывается можно так распечатать без стрима
        System.out.println("- Исключений не было выброшено.");
    }

    static private void negativeTest1() {
        System.out.println("\n\n\n\n"); // это, чтобы отступить в консоли от предыдущего вывода
        System.out.println("-".repeat(50) + "Начался negativeTest1 " + "-".repeat(50)); // для оформления заголовка
        System.out.println("В него передано int numberOfStudents = 100;");

        int numberOfStudents = 100; // это нормальное значение, ошибочным являются 0 и отрицательные
        // и большие - больше 30.
        StrategyDataFromJSONFile dataFromJSONFileHandler = new StrategyDataFromJSONFile();
        List<Student> listOfStudents = dataFromJSONFileHandler.getData(numberOfStudents);
        listOfStudents.forEach(System.out::println); // оказывается можно так распечатать без стрима
        System.out.println("- Исключений не было выброшено.");
    }

    static private void negativeTest2() {
        System.out.println("\n\n\n\n"); // это, чтобы отступить в консоли от предыдущего вывода
        System.out.println("-".repeat(50) + "Начался negativeTest2 " + "-".repeat(50)); // для оформления заголовка
        System.out.println("В него передано int numberOfStudents = 0;");

        int numberOfStudents = 0; // это нормальное значение, ошибочным являются 0 и отрицательные
        // и большие - больше 30.
        StrategyDataFromJSONFile dataFromJSONFileHandler = new StrategyDataFromJSONFile();
        List<Student> listOfStudents = dataFromJSONFileHandler.getData(numberOfStudents);
        System.out.println("Пустой ли списк listOfStudents.isEmpty() = " + listOfStudents.isEmpty());
        listOfStudents.forEach(System.out::println); // оказывается можно так распечатать без стрима
        System.out.println("- Исключений не было выброшено.");
    }

    static private void negativeTest3() {
        System.out.println("\n\n\n\n"); // это, чтобы отступить в консоли от предыдущего вывода
        System.out.println("-".repeat(50) + "Начался negativeTest3 " + "-".repeat(50)); // для оформления заголовка
        System.out.println("В него передано int numberOfStudents = -5;");

        int numberOfStudents = -5; // это нормальное значение, ошибочным являются 0 и отрицательные
        // и большие - больше 30.
        StrategyDataFromJSONFile dataFromJSONFileHandler = new StrategyDataFromJSONFile();
        List<Student> listOfStudents = dataFromJSONFileHandler.getData(numberOfStudents);
        System.out.println("- Пустой ли списк listOfStudents.isEmpty() = " + listOfStudents.isEmpty());
        listOfStudents.forEach(System.out::println); // оказывается можно так распечатать без стрима
        System.out.println("- Исключений не было выброшено.");
    }


    static void main() {
        positiveTest();
        negativeTest1();
        negativeTest2();
        negativeTest3();

    }
}
