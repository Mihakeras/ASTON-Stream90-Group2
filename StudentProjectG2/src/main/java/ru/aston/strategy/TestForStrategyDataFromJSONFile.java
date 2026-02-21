package ru.aston.strategy;
import ru.aston.model.Student;
import java.util.List;

public class TestForStrategyDataFromJSONFile
{
    static void main()
    {
        StrategyDataFromJSONFile dataFromJSONFileHandler = new StrategyDataFromJSONFile();
        List<Student> listOfStudents = dataFromJSONFileHandler.getData(10);
        listOfStudents.forEach(System.out::println); // оказывается можно так распечатать без стрима

    }
}
