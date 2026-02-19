package ru.aston.file.testutils;

import ru.aston.file.JSONFileReader;

public class TestV1ForJSONFileReader
{
    static void main()
    {
    //JSONFileReader fileReader = new JSONFileReader(); так нельзя делать, тк методы статичные внутри
    boolean exists =  JSONFileReader.checkThatFileExists("students.json");
    boolean isJSON =  JSONFileReader.checkIsJSONFile("students.json");
        System.out.println("checkThatFileExists -> "+ exists);
        System.out.println("checkIsJSONFile -> "+ isJSON);
    }

}
