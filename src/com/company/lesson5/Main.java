package com.company.lesson5;

import javax.sound.midi.Soundbank;

public class Main {

    public static int number_of_employees = 5;

    public static void main() {
        Employee[] employees = setEployeesList();
        displayEmployeesList(employees, 40);
    }

    public static Employee[] setEployeesList() {
        Employee[] employees = new Employee[number_of_employees];

        employees[0] = new Employee("Бендер Остап Ибрагимович", 34,
                "+7 (985) 755-55-55", "obender@mail.ru", "CEO", 700000.0);

        employees[1] = new Employee("Корейко Александр Иванович", 48,
                "+7 (985) 744-44-44", "akoreyko@mail.ru", "CFO", 500000.0);

        employees[2] = new Employee("Паниковский Михаэль Самуэльевич", 72,
                "+7 (985) 733-33-33", "mpanikovsky@mail.ru", "manager", 80000.0);

        employees[3] = new Employee("Балаганов Александр Петрович", 42,
                "+7 (985) 722-22-22", "abalaganov@mail.ru", "manager", 80000.0);

        employees[4] = new Employee("Козлевич Адам Казимирович", 41,
                "+7 (985) 711-11-11", "akozlevich@mail.ru", "driver", 55000.0);

        return employees;
    }

    public static void displayEmployeesList(Employee[] employees, int beginningAge) {
        System.out.printf("Сотрники, старше %d лет:\n", beginningAge);

        for (int index = 0; index < employees.length; index++) {
            Employee employee = employees[index];
            int ageOfEmployee = employee.getAge();

            if (ageOfEmployee > beginningAge) {
                employee.displayDossier();
            }
        }
    }
}
