package ru.aston.ui;

import ru.aston.model.Student;
import ru.aston.sorting.StudentSorter;
import ru.aston.strategy.StartegyDataFromConsole;
import ru.aston.strategy.StrategyDataFromJSONFile;
import ru.aston.strategy.StrategyDataFromRandom;
import ru.aston.strategy.ContractForDataMining;
import ru.aston.file.JSONFileReader;
import ru.aston.validation.StudentValidator;

import java.util.*;


 // Класс для обработки пользовательского меню (User Interface)
public class ConsoleMenuHandler {

     // Список студентов, с которым работает программа.
    private List<Student> students;

     // Сканер для чтения ввода пользователя.
    private final Scanner scanner;

     // Сортировщик студентов.
    private final StudentSorter sorter;

    /**
     * Конструктор обработчика меню.
     * Инициализирует все необходимые компоненты.
     */
    public ConsoleMenuHandler() {
        this.students = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.sorter = new StudentSorter();
    }

    /**
     * Запускает основной цикл программы.
     * Отображает меню и обрабатывает выбор пользователя.
     */
    public void start() {
        boolean running = true;

        while (running) {
            // Отображаем главное меню
            displayMainMenu();

            // Получаем выбор пользователя
            System.out.println("Выберите пункт меню: ");
            int choice = readIntInput();

            // Обрабатываем выбор
            switch (choice) {
                case 1:
                    generateDataMenu();
                    break;
                case 2:
                    sortStudents();
                    break;
                case 3:
                    displayStudents();
                    break;
                case 4:
                    clearData();
                    break;
                case 5:
                    running = false;
                    System.out.println("\nДо свидания!");
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }

    /**
     * Отображает главное меню.
     */
    private void displayMainMenu() {
        System.out.println("\n┌────────────────────────────────────────────────┐");
        System.out.println("│                  ГЛАВНОЕ МЕНЮ                   │");
        System.out.println("├────────────────────────────────────────────────┤");
        System.out.println("│ Текущее количество студентов: " + padRight(String.valueOf(students.size()), 16) + "│");
        System.out.println("├────────────────────────────────────────────────┤");
        System.out.println("│ 1. Сгенерировать данные                         │");
        System.out.println("│ 2. Отсортировать студентов                      │");
        System.out.println("│ 3. Показать студентов                           │");
        System.out.println("│ 4. Очистить данные                              │");
        System.out.println("│ 5. Выход                                        │");
        System.out.println("└────────────────────────────────────────────────┘");
    }

    /**
     * Меню генерации данных.
     */
    private void generateDataMenu() {
        System.out.println("\n┌────────────────────────────────────────────────┐");
        System.out.println("│                 ГЕНЕРАЦИЯ ДАННЫХ                 │");
        System.out.println("├────────────────────────────────────────────────┤");
        System.out.println("│ 1. Случайная генерация                          │");
        System.out.println("│ 2. Ручной ввод                                  │");
        System.out.println("│ 3. Загрузка из JSON файла                       │");
        System.out.println("│ 4. Назад                                        │");
        System.out.println("└────────────────────────────────────────────────┘");

        System.out.println("Выберите способ: ");
        int choice = readIntInput();

        if (choice == 4) {
            return;
        }

        ContractForDataMining strategy = null;

        switch (choice) {
            case 1:
                // Случайная генерация
                System.out.println("Сколько студентов сгенерировать? (1-100): ");
                int randomCount = readIntInput();
                strategy = new StrategyDataFromRandom();
                break;

            case 2:
                // Ручной ввод
                System.out.println("Сколько студентов ввести? (1-20): ");
                int manualCount = readIntInput();
                strategy = new StartegyDataFromConsole();
                break;

            case 3:
                // Загрузка из файла
                System.out.print("Чтение из JSON файла: ");
                strategy = new StrategyDataFromJSONFile();
                break;
        }

        if (strategy != null) {
            System.out.println("\n" + "Введите количество студентов: ");
            students = strategy.getData(readIntInput());
/*
            if (!newStudents.isEmpty()) {
                students.addAll(newStudents);
                System.out.println("Добавлено студентов: " + newStudents.size());
            } else {
                System.out.println("Не удалось добавить студентов");
            }
            */
        }
    }

    /**
     * Сортировка студентов.
     */
    private void sortStudents() {
        if (students.isEmpty()) {
            System.out.println("Нет данных для сортировки. Сначала сгенерируйте данные.");
            return;
        }

        System.out.println("\n┌────────────────────────────────────────────────┐");
        System.out.println("│               СОРТИРОВКА СТУДЕНТОВ               │");
        System.out.println("├────────────────────────────────────────────────┤");
        System.out.println("│ Сортировка по всем трем полям:                  │");
        System.out.println("│   1. Номер группы (по возрастанию)              │");
        System.out.println("│   2. Средний балл (по возрастанию)              │");
        System.out.println("│   3. Номер зачетки (по возрастанию)             │");
        System.out.println("└────────────────────────────────────────────────┘");

        System.out.print("Начать сортировку? (y/n): ");
        String confirm = scanner.nextLine().trim().toLowerCase();

        if (confirm.equals("y")) {
            try {
                // Выполняем сортировку
                sorter.sortStudents(students);

                System.out.println("Сортировка успешно завершена!");

                // Показываем предпросмотр
                showPreview(5);

            } catch (Exception e) {
                System.err.println("Ошибка при сортировке: " + e.getMessage());
            }
        } else {
            System.out.println("Сортировка отменена.");
        }
    }

    /**
     * Отображает всех студентов.
     */
    private void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("Нет студентов для отображения.");
            return;
        }

        System.out.println("\n┌────────────────────────────────────────────────────────────────┐");
        System.out.println("│                        СПИСОК СТУДЕНТОВ                         │");
        System.out.println("├────────────────────────────────────────────────────────────────┤");
        System.out.println("│ Всего студентов: " + padRight(String.valueOf(students.size()), 45) + "│");
        System.out.println("└────────────────────────────────────────────────────────────────┘");

        // Разбиваем на страницы по 10 студентов
        int pageSize = 10;
        int totalPages = (students.size() + pageSize - 1) / pageSize;

        for (int page = 0; page < totalPages; page++) {
            int start = page * pageSize;
            int end = Math.min(start + pageSize, students.size());

            System.out.println("\n┌────────────────────────────────────────────────────────────────┐");
            System.out.println("│ Страница " + padRight((page + 1) + " из " + totalPages, 48) + "│");
            System.out.println("├────────────────────────────────────────────────────────────────┤");

            for (int i = start; i < end; i++) {
                System.out.printf("│ %3d. %-60s │%n", i + 1, students.get(i));
            }

            System.out.println("└────────────────────────────────────────────────────────────────┘");

            if (page < totalPages - 1) {
                System.out.print("\nНажмите Enter для продолжения...");
                scanner.nextLine();
            }
        }
    }

    /**
     * Очищает данные.
     */
    private void clearData() {
        if (students.isEmpty()) {
            System.out.println("Данные уже пусты.");
            return;
        }

        System.out.print("Вы уверены? Все данные будут удалены. (y/n): ");
        String confirm = scanner.nextLine().trim().toLowerCase();

        if (confirm.equals("y")) {
            students.clear();
            System.out.println("Все данные удалены.");
        } else {
            System.out.println("Операция отменена.");
        }
    }

    /**
     * Показывает предпросмотр первых N студентов.
     *
     * @param count количество студентов для предпросмотра
     */
    private void showPreview(int count) {
        int previewCount = Math.min(count, students.size());
        if (previewCount > 0) {
            System.out.println("\nПервые " + previewCount + " студентов:");
            for (int i = 0; i < previewCount; i++) {
                System.out.println("  " + (i + 1) + ". " + students.get(i));
            }
        }
    }

    /**
     * Вспомогательный метод для выравнивания текста справа.
     *
     * @param text текст для выравнивания
     * @param width ширина поля
     * @return текст с пробелами слева
     */
    private String padRight(String text, int width) {
        return String.format("%-" + width + "s", text);
    }

    /**
     * Безопасное чтение целого числа с валидацией.
     * @return введенное число
     */
    private int readIntInput() {
        int value = 0;
        while (true) {
            String input = scanner.nextLine().trim();
            if(StudentValidator.isInteger(input)) {
                value = Integer.parseInt(input);
                break;
            }
        } return value;
    }
}