import java.text.DecimalFormat;

public class Student {
    private final String groupNumber;
    private final double averageGrades;
    private final int studentId;

    public Student(String groupNumber, double averageGrades, int studentId) {
        this.groupNumber = groupNumber;
        this.averageGrades = averageGrades;
        this.studentId = studentId;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public double getAverageGrades() {
        return averageGrades;
    }

    public int getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return "\nНомер группы: " + groupNumber +
                " / Средний балл: " + new DecimalFormat("#.##").format(averageGrades) +
                " / Номер зачётной книжки: " + studentId;
    }
}