package ru.aston.file;
import java.io.IOException;

public class TestForJSONFileReader {
    static void main() {
        //JSONFileReader fileReader = new JSONFileReader(); так нельзя делать, тк методы статичные внутри
        boolean exists = JSONFileReader.checkThatFileExists("students.json");
        boolean isJSON = JSONFileReader.checkIsJSONFile("students.json");
        String contentOfFileAsOneString;
        try {
            contentOfFileAsOneString = JSONFileReader.readFileAsOneString("students.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("checkThatFileExists -> " + exists);
        System.out.println("checkIsJSONFile -> " + isJSON);
        System.out.println(contentOfFileAsOneString);

    }
}

