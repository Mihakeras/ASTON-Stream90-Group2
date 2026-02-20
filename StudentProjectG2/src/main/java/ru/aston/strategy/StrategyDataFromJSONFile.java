

package ru.aston.strategy;
import ru.aston.model.Student;
import ru.aston.validation.StudentValidator;
import ru.aston.file.JSONFileReader;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StrategyDataFromJSONFile implements ContractForDataMining {

    private static final String FILE_NAME = "students.json";
    //private final StudentValidator validator = new StudentValidator();

    @Override
    public List<Student> getData(int amountOfStudents) {
        List<Student> students = new ArrayList<>(); // Создаем пустой список

        try {
            if (!JSONFileReader.checkThatFileExists(FILE_NAME)) {
                System.out.println("❌ Ошибка: Файл " + FILE_NAME + " не найден!");
                return students; // Возвращаем пустой список
            }

            if (!JSONFileReader.checkIsJSONFile(FILE_NAME)) {
                System.out.println("❌ Ошибка: Файл " + FILE_NAME + " не является JSON файлом!");
                return students;
            }

            // Читаем содержимое файла - внутри JSONFileReader используется try-with-resources
            String jsonContent = JSONFileReader.readFileAsOneString(FILE_NAME);

            // Парсим JSON массив
            JSONArray jsonArray = new JSONArray(jsonContent);

            // Определяем реальное количество студентов для чтения
            // тут важно понять чего мньше - запрошенных студентов или
            // имеющихся в файле
            int studentsToRead = Math.min(amountOfStudents, jsonArray.length());

            if (studentsToRead < amountOfStudents) {
                System.out.println("⚠️ Внимание: В файле только " + jsonArray.length() + " студентов");
            }

            // Проходим по JSON массиву
            for (int i = 0; i < studentsToRead; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                try {
                    // Извлекаем данные из JSON
                    int group = jsonObject.getInt("numberOfGroup");
                    int grade = jsonObject.getInt("averageGrade");
                    int recordBook = jsonObject.getInt("numberOfRecordBook");

                    // Валидируем данные
                    if (StudentValidator.validateGroup(group) &&
                            StudentValidator.validateGroup(grade) &&
                            StudentValidator.validateRecordBook(recordBook)) {

                        // Создаем студента и добавляем в список
                        Student student = new Student.BuilderStudent()
                                .setNumberOfGroup(group)
                                .setAverageGrade(grade)
                                .setNumberOfRecordBook(recordBook)
                                .build();

                        students.add(student); // Добавляем в список
                    } else {
                        System.out.println("⚠️ Пропущен студент с невалидными данными: группа=" +
                                group + ", балл=" + grade + ", зачетка=" + recordBook);
                    }
                } catch (Exception e) {
                    System.out.println("⚠️ Ошибка при обработке студента #" + (i + 1) + ": " + e.getMessage());
                }
            }

            if (students.size() < studentsToRead) {
                System.out.println("⚠️ Загружено только " + students.size() + " валидных студентов");
            }

            return students;

        } catch (IOException e) {
            System.out.println("❌ Ошибка при чтении файла: " + e.getMessage());
            return students; // Возвращаем пустой список в случае ошибки
        }
    }
}
