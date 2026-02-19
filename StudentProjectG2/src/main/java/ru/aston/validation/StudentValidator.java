package ru.aston.validation;

public class StudentValidator {

    public static boolean validateGroup(int group){
        return group > 0 && group < 20;
    }

    public static boolean validateAverage(int avg){
        return avg >= 0 && avg <=5;
    }

    public static boolean validateRecordBook(int record){
        return record > 0;
    }

    public static boolean isValid(int group, int avg, int record) {
        return validateGroup(group) && validateAverage(avg) && validateRecordBook(record);
    }
}