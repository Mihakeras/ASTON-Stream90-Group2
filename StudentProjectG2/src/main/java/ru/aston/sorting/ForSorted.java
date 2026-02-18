package ru.aston.sorting;

import ru.aston.model.Student;

import java.util.Comparator;

public enum ForSorted implements Comparator<Student> {
    numberOfGroup{
        @Override
        public int compare(Student student1, Student student2) {
            if (student1.getNumberOfGroup()<student2.getNumberOfGroup())
                return -1;
            if (student1.getNumberOfGroup()>student2.getNumberOfGroup())
                return 1;
            return 0;
        }
    },
    averageGrade {
        @Override
        public int compare(Student student1, Student student2) {
            if (student1.getAverageGrade()<student2.getAverageGrade())
                return -1;
            if (student1.getAverageGrade()>student2.getAverageGrade())
                return 1;
            return 0;
        }
    },
    numberOfRecordBook {
        @Override
        public int compare(Student student1, Student student2) {
            if (student1.getNumberOfRecordBook()<student2.getNumberOfRecordBook())
                return -1;
            if (student1.getNumberOfRecordBook()>student2.getNumberOfRecordBook())
                return 1;
            return 0;
        }
    };
}
