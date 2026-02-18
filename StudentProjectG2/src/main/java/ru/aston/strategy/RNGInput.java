import java.util.List;
import java.util.Random;

public class RNGInput implements ArrayInputStrategy {

    public void arrayInput(List<Student> studentList) {

        int rngCount = new Random().nextInt(1, 30);

        int numberOfGroup, averageGrade, numberOfRecordBook;

        do {
            numberOfGroup = new Random().nextInt(1, 10);
            averageGrade = new Random().nextInt(1, 5);
            numberOfRecordBook = new Random().nextInt(100000, 999999);

            studentList.add(new Student.StudentBuilder(numberOfGroup, averageGrade, numberOfRecordBook)
                    .setNumberOfGroup(numberOfGroup)
                    .setAverageGrade(averageGrade)
                    .setNumberOfRecordBook(numberOfRecordBook)
                    .build());
            rngCount--;

        } while (rngCount > 0);

        System.out.println("\nСписок заполнен");
    }
}
