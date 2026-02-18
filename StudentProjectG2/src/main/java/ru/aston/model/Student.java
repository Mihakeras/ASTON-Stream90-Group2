package ru.aston.model;

public class Student {
    private int numberOfGroup;
    private int averageGrade;
    private int numberOfRecordBook;

    public Student(int numberOfGroup, int averageGrade, int numberOfRecordBook) {
        this.numberOfGroup = numberOfGroup;
        this.averageGrade = averageGrade;
        this.numberOfRecordBook = numberOfRecordBook;
    }

    public int getNumberOfGroup() {
        return numberOfGroup;
    }

    public int getAverageGrade() {
        return averageGrade;
    }

    public int getNumberOfRecordBook() {
        return numberOfRecordBook;
    }

    @Override
    public String toString() {
        return "Student{" +
                "numberOfGroup=" + numberOfGroup +
                ", averageGrade=" + averageGrade +
                ", numberOfRecordBook=" + numberOfRecordBook +
                '}';
    }

    public static BuilderStudent builderStudent(){
        return new BuilderStudent();
    }

    public static class BuilderStudent {
        private int numberOfGroup;
        private int averageGrade;
        private int numberOfRecordBook;

        public BuilderStudent setNumberOfGroup(int numberOfGroup) {
            this.numberOfGroup = numberOfGroup;
            return this;
        }

        public BuilderStudent setAverageGrade(int averageGrade) {
            this.averageGrade = averageGrade;
            return this;
        }

        public BuilderStudent setNumberOfRecordBook(int numberOfRecordBook) {
            this.numberOfRecordBook = numberOfRecordBook;
            return this;
        }
        public Student build(){
            return new Student(numberOfGroup,averageGrade,numberOfRecordBook);
        }
    }
}
