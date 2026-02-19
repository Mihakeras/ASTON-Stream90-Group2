package ru.aston.file;

/*
 * Класс JSONFileReader предоставляет методы для чтения JSON файлов.
 * Использует современный Java NIO API для простой и эффективной работы с файлами.
 *
 * Архитектура: file-пакет v1.1 - упрощенная версия с использованием NIO
 * Версия класса: 1.1
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JSONFileReader {
    /*
     * Читает содержимое JSON файла и возвращает его в виде строки;
     * Используется Files.readString() для максимальной простоты;
     *
     * @param fileName имя файла для чтения;
     * @return содержимое файла в виде одной строки;
     * @throws выбросит IOException если возникла ошибка при чтении файла;
     */
    public static String readFileAsOneString(String fileName) throws IOException {
        Path pathOfFile = Paths.get(fileName);
        return Files.readString(pathOfFile);
    }

    /*
     * Проверяет существование JSON файла
     * @param fileName имя файла для проверки
     * @return true если файл существует
     */
    public static boolean checkThatFileExists(String fileName) {
        return  // Проверяем, что файл существует И является обычным файлом, а не директорией или устройством
                Files.isRegularFile(Paths.get(fileName));
    }

    /*
     * Дальше код проверяет, является ли файл именно JSON файлом (анализируя его расширение)
     * @param fileName имя файла для проверки
     * @return true если файл имеет расширение .json
     */
    public static boolean checkIsJSONFile(String fileName) {

        return  // анализируем расширение файла и понимаем верный ли это файл
                fileName != null && fileName.toLowerCase().endsWith(".json");

    }
}