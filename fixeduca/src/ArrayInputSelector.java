import java.io.FileNotFoundException;
import java.util.List;

public class ArrayInputSelector {

    private final ArrayInputStrategy arrayInputStrategy;

    public ArrayInputSelector(ArrayInputStrategy arrayInputStrategy) {
        this.arrayInputStrategy = arrayInputStrategy;
    }

    public void arrayInput(List<Student> studentList) throws FileNotFoundException {
        arrayInputStrategy.arrayInput(studentList);
    }
}
