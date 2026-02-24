// автор Даниил Конев
package aston.file;
import ru.aston.file.JSONFileReader;
import java.io.IOException;

public class TestForJSONFileReader {
    static private void positiveTest() {
        // Позитивные тестовые кейсы
        String goodFileName = "students.json";
        String contentOfFileAsOneString = null;
        boolean isFileExists = false;
        boolean isJSONfile = false;

        try {
            isFileExists = JSONFileReader.checkThatFileExists(goodFileName);
            isJSONfile = JSONFileReader.checkIsJSONFile(goodFileName);
            contentOfFileAsOneString = JSONFileReader.readFileAsOneString(goodFileName);

            System.out.println("checkThatFileExists (а файл существует?) -> " + isFileExists);
            System.out.println("checkIsJSONFile (а это JSON-файл?) -> " + isJSONfile);
            System.out.println(contentOfFileAsOneString);

        } catch (IOException e) { // обработаю исключение, если файла нет
            System.err.println("Позитивный тест сообщает: тут ожидалось получить файл с верным именем.");
            System.err.println("Вот детали ошибки, полученные от e.getMessage(): "+ e.getMessage());
        }

    }

    static private void negativeTest() {
        // Негативные тестовые кейсы
        String badFileName = "badStudents.json";
        String contentOfFileAsOneString = null;
        boolean isFileExists = false;
        boolean isJSONfile = false;

        try {
            isFileExists = JSONFileReader.checkThatFileExists(badFileName);
            isJSONfile = JSONFileReader.checkIsJSONFile(badFileName);
            contentOfFileAsOneString = JSONFileReader.readFileAsOneString(badFileName);

            System.out.println("checkThatFileExists (файл существует?) -> " + isFileExists);
            System.out.println("checkIsJSONFile (это JSON-файл?) -> " + isJSONfile);
            System.out.println(contentOfFileAsOneString);

        } catch (IOException e) { // обработаю исключение
            System.err.println("Негативнй тест сообщает: тут ожидаемо не получилось прочитать файл с неверным именем. " +
                    "Использовался трай-кетч, чтобы приложение не крашнулось.");
            System.err.println("Вот детали ошибки, полученные от e.getMessage(): "+ e.getMessage());
        }

    }


    static void main() {
        System.out.println("\n\n\n\n"); // это, чтобы отступить в консоли от предыдущего вывода
        System.out.println("-".repeat(50)+ "Начался позитивный тест" + "-".repeat(50)); // для оформления заголовка
        positiveTest(); // вызов позитивного кейса
        System.out.println("-".repeat(50)+ "Начался негативный тест" + "-".repeat(50)); // для оформления заголовка
        negativeTest(); // вызов негативного кейса
    }
}

