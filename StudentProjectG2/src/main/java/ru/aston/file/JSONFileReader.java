package ru.aston.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JSONFileReader {

    public static String readFileAsOneString(String fileName) throws IOException {
        Path pathOfFile = Paths.get(fileName);
        return Files.readString(pathOfFile); //содержимое файла в виде одной строки;
    }

    public static boolean checkThatFileExists(String fileName) {
        return  // Проверяем, что файл существует И является обычным файлом, а не директорией или устройством
                Files.isRegularFile(Paths.get(fileName));
    }

    public static boolean checkIsJSONFile(String fileName) {

        return  // анализируем расширение файла и понимаем верный ли это файл
                fileName != null && fileName.toLowerCase().endsWith(".json");
    }
}