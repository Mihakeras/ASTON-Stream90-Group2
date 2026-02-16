import java.util.List;
import java.util.Random;

public class RNGInput implements ArrayInputStrategy {

    public void arrayInput(List<Student> studentList) {
        int rngCount = new Random().nextInt(10 - 1 + 1) + 1;

        String groupNumber, alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        double averageGrades;
        int studentId;

        do {
            groupNumber = alphabet.charAt(new Random().nextInt(alphabet.length())) + "-" +
                    (new Random().nextInt(10, 99));
            averageGrades = Math.random() * (5 - 2) + 2;
            studentId = new Random().nextInt(10000000, 99999999);

            studentList.add(new Student(groupNumber, averageGrades, studentId));
            rngCount--;

        } while (rngCount > 0);

        System.out.println("\nСписок заполнен");
    }
}
