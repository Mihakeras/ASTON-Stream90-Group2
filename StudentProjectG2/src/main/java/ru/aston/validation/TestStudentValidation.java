package ru.aston.validation;

import ru.aston.validation.StudentValidator;

public class TestStudentValidation {

    public static void main(String[] args) {
        System.out.println("--- Простой тест валидации ---");

        // --- Тест корректных данных ---
        System.out.println("\nТест 1: Корректные данные");
        boolean ok1 = StudentValidator.validateGroup(10);//должно быть true
        boolean ok2 = StudentValidator.validateAverage(4);//должно быть true
        boolean ok3 = StudentValidator.validateRecordBook(123456);//должно быть true

        if (ok1 && ok2 && ok3) {
            System.out.println(" Результат: OK (Валидация пропускает верные данные)");
        } else {
            System.out.println(" Результат: ОШИБКА (Валидация не пропустила верные данные!)");
        }

        // --- Тест некорректных данных ---
        System.out.println("\nТест 2: Некорректные данные");
        boolean bad1 = StudentValidator.validateGroup(-5); // Должно быть false
        boolean bad2 = StudentValidator.validateAverage(150); // Должно быть false
        boolean bad3 = StudentValidator.validateRecordBook(0); // Должно быть false

        if (!bad1 && !bad2 && !bad3) {
            System.out.println(" Результат: OK (Валидация блокирует неверные данные)");
        } else {
            System.out.println(" Результат: ОШИБКА (Валидация пропустила неверные данные!)");
        }

        System.out.println("\n--- Тест завершен ---");
    }
}
