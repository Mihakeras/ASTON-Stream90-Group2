package ru.aston.validation;

public class StudentValidator {

    //валидация номера группы
    public static boolean validateGroup(int group){
        return group > 0 && group < 20;
    }

    //валидация среднего балла
    public static boolean validateAverage(int avg){
        return avg >= 1 && avg <=5;
    }

    //валидация номера зачетной книжки
    public static boolean validateRecordBook(int record){
        return record >= 1000000 && record <= 9999999;
    }

    //общий метод валидации для удобства вызова в стратегиях
    public static boolean isValid(int group, int avg, int record) {
        return validateGroup(group) && validateAverage(avg) && validateRecordBook(record);
    }
}