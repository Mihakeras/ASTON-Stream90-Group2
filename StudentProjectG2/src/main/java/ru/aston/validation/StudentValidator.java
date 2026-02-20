package ru.aston.validation;

public class StudentValidator {

    //валидация номера группы
    public static boolean validateGroup(int group) {
        if (group >= 0 && group <= 20) {
            System.out.println(" Группа (" + group + "): Корректно.");
            return true;
        } else {
            System.err.println(" Ошибка в группе: " + group + " (должна быть от 1 до 20)");
            return false;
        }
    }

    //валидация среднего балла
    public static boolean validateAverage(int avg) {
        if (avg >= 1 && avg <= 5) {
            System.out.println(" Балл (" + avg + "): Корректно.");
            return true;
        } else {
            System.err.println(" Ошибка в баллах: " + avg + " (должны быть от 1 до 5)");
            return false;
        }
    }


    //валидация номера зачетной книжки
    public static boolean validateRecordBook(int record) {
        if (record >= 100000 && record <= 999999) {
            System.out.println(" Зачетка (" + record + "): Корректно.");
            return true;
        } else {
            System.err.println(" Ошибка в номере зачетки: " + record + " (должен быть 100000 до 999999)");
            return false;
        }
    }

    /**
     * Общая проверка всех данных
     */
    public static boolean isValid(int group, int avg, int record) {
        System.out.println("\n--- Запуск валидации данных ---");

        // Проверяем каждое поле
        boolean g = validateGroup(group);
        boolean a = validateAverage(avg);
        boolean r = validateRecordBook(record);

        if (g && a && r) {
            System.out.println(" Итог: Все данные верны! Студент создан.");
            return true;
        } else {
            System.err.println(" Итог: Валидация провалена. Студент не будет добавлен.");
            return false;
        }
    }

    public static boolean isInteger(String str) {
        // Проверка на null
        if (str == null) {
            System.err.println(" Ошибка: Входная строка пуста (null).");
            return false;
        }

        try {
            // Пробуем преобразовать
            Integer.parseInt(str);

            // Если получилось, выводим подтверждение
            System.out.println(" Проверка типа: Строка '" + str + "' является целым числом.");
            return true;

        } catch (NumberFormatException e) {
            // Если вылетела ошибка, значит в строке были буквы или спецсимволы
            System.err.println(" Ошибка типа: '" + str + "' — это не число, а строка или текст.");
            return false;
        }
    }

}