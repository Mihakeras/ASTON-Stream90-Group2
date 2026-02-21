package aston.strategy;

import ru.aston.model.Student;
import ru.aston.strategy.ContractForDataMining;
import ru.aston.strategy.StrategyDataFromRandom;

import java.util.List;

public class TestForStrategyDataFromRandom {
    public static void main(String[] args) {
        ContractForDataMining contract=new StrategyDataFromRandom();
        List<Student> students = contract.getData(5);

        students.stream().forEach(System.out::println);
    }
}