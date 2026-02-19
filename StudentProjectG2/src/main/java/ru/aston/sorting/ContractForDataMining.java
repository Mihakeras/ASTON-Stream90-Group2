

/*
 * Интерфейс ContractForDataMining определяет контракт для всех стратегий
 * получения данных о студентах. Каждая стратегия должна реализовать
 * метод для получения списка студентов.
 *
 * Архитектура: strategy пакет v1.0
 *
 * Версия интерфейса: 3.0
 */

package ru.aston.sorting;

import app.model.Student;

import java.util.List;

public interface ContractForDataMining {
    /*
     * Метод для получения списка студентов согласно выбранной стратегии
     * @param count количество студентов для получения
     * @return список объектов Student
     */
    List<Student> getData(int count);
}