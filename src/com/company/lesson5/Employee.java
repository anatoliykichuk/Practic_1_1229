package com.company.lesson5;

import javax.sound.midi.Soundbank;

public class Employee {

    /*
    1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
    2. Конструктор класса должен заполнять эти поля при создании объекта.
    3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    4. Создать массив из 5 сотрудников.
    5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
    */

    private String fullName;
    private int age;
    private String phoneNumber;
    private String email;
    private String function;
    private double salary;

    private StringBuilder builder = new StringBuilder();

    Employee(String fullName, int age, String phoneNumber, String email, String function, double salary) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.function = function;

        setAge(age);
        setSalary(salary);
    }

    Employee(String fullName, int age) {
        this.fullName = fullName;
        this.phoneNumber = "";
        this.email = "";
        this.function = "";
        this.salary = 0.0;

        setAge(age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 14 && age <= 100) {
            this.age = age;
        } else {
            System.out.println("Возвраст указан некорректно!\n" +
                    "Он должен соотвествовать данным документа, удостоверяющего личность\n" +
                    "и требованиям трудового законодательства!");
        }
    }

    public void setSalary(double salary) {
        if (salary >= 12792.0) {
            this.salary = salary;
        } else {
            System.out.println("Оклад не может быть меньше МРОТ: 12792.00!\n" +
                    "См. Федеральный законом № 473-ФЗ от 29.12.2020");
        }
    }

    public void displayDossier() {
        builder.append("ДОСЬЕ:").append(System.lineSeparator());
        builder.append("- ФИО: ").append(fullName).append(System.lineSeparator());
        builder.append("- Возвраст: ").append(age).append(System.lineSeparator());
        builder.append("- телефон: ").append(phoneNumber).append(System.lineSeparator());
        builder.append("- электронная почта: ").append(email).append(System.lineSeparator());
        builder.append("- должность: ").append(function).append(System.lineSeparator());
        builder.append("- оклад: ").append(salary).append(System.lineSeparator());

        System.out.print(builder.toString());
    }
}
