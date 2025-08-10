public class Main {

    public static void indexingSalary(Employee[] employee, float percent) {
        for (Employee value : employee) {
            value.setSalary(value.getSalary() * ((percent / 100) + 1));
        }
    }

    public static void indexingSalary(Employee[] employee, byte otdel, float percent) {
        for (Employee value : employee) {
            if (value.getDepartment() == otdel) {
                value.setSalary(value.getSalary() * ((percent / 100) + 1));
            }
        }
    }

    public static float sumingSalary(Employee[] employees) {
        float sumSalary = 0;
        for (Employee employee : employees) {
            sumSalary += employee.getSalary();
        }
        return sumSalary;
    }

    public static float sumingSalary(Employee[] employees, byte otdel) {
        float sumSalary = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == otdel) {
                sumSalary += employee.getSalary();
            }
        }
        return sumSalary;
    }

    public static float findMinSalary(Employee[] employees) {
        float minSalary = employees[0].getSalary();
        for (int i = 1; i < employees.length; i++) {
            if (minSalary > employees[i].getSalary()) {
                minSalary = employees[i].getSalary();
            }
        }
        return minSalary;
    }

    public static float findMinSalary(Employee[] employees, byte otdel) {
        float minSalary = Float.MAX_VALUE;
        for (Employee employee : employees) {
            if (minSalary > employee.getSalary() && otdel == employee.getDepartment()) {
                minSalary = employee.getSalary();
            }
        }
        return minSalary;
    }

    public static float findMaxSalary(Employee[] employees) {
        float maxSalary = employees[0].getSalary();
        for (int i = 1; i < employees.length; i++) {
            if (maxSalary < employees[i].getSalary()) {
                maxSalary = employees[i].getSalary();
            }
        }
        return maxSalary;
    }

    public static float findMaxSalary(Employee[] employees, byte otdel) {
        float maxSalary = 0;
        for (int i = 1; i < employees.length; i++) {
            if (maxSalary < employees[i].getSalary() && employees[i].getDepartment() == otdel) {
                maxSalary = employees[i].getSalary();
            }
        }
        return maxSalary;
    }

    public static void printFIO(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee.getLastname() + " " + employee.getFirstname() + " " + employee.getPatronymic());
        }
    }

    public static void printDepartament(Employee[] employees, byte otdel) {
        for (Employee employee : employees) {
            if (employee.getDepartment() == otdel) {
                System.out.println(employee.getLastname() + " " + employee.getFirstname() + " " + employee.getPatronymic() + " salary: " + employee.getSalary());
            }
        }
    }

    public static float averageSalary(Employee[] employees) {
        return sumingSalary(employees) / employees.length;
    }

    public static float averageSalary(Employee[] employees, byte otdel) {
        int countPersonal = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == otdel) {
                countPersonal++;
            }
        }
        return sumingSalary(employees, otdel) / countPersonal; //не оптимально с точки зрения производительности, но красиво
    }

    public static void printEmployeesFewerLevelSalary(Employee[] employees, float parametr) {
        System.out.println("ЗП ниже уровня " + parametr + " у:");
        for (Employee employee : employees) {
            if (employee.getSalary() < parametr) {
                System.out.println("id: " + employee.getId() + " ФИО: " + employee.getLastname() + " " + employee.getFirstname() + " " + employee.getPatronymic() + " ЗП: " + employee.getSalary());
            }

        }
    }


    public static void printEmployeesHigherLevelSalary(Employee[] employees, float parametr) {
        System.out.println("ЗП выше или равно " + parametr + " у:");
        for (Employee employee : employees) {
            if (employee.getSalary() >= parametr) {
                System.out.println("id: " + employee.getId() + " ФИО: " + employee.getLastname() + " " + employee.getFirstname() + " " + employee.getPatronymic() + " ЗП: " + employee.getSalary());
            }

        }
    }


    public static void main(String[] args) {

        //заполнение данных сотрудников

        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Иванов", "Иван", "Иванович", (byte) 1, 15_000);
        employees[1] = new Employee("Петров", "Пётр", "Петрович", (byte) 2, 85_000);
        employees[2] = new Employee("Сидоров", "Сидор", "Сидорович", (byte) 3, 5_000);
        employees[3] = new Employee("Максимов", "Максим", "Максимович", (byte) 4, 115_000);
        employees[4] = new Employee("Иванова", "Ивана", "Ивановна", (byte) 5, 35_000);
        employees[5] = new Employee("Петрова", "Пелагея", "Петровна", (byte) 1, 16_000);
        employees[6] = new Employee("Сидорова", "Симона", "Сидоровна", (byte) 2, 87_000);
        employees[7] = new Employee("Иванов", "Иван", "Иванович", (byte) 3, 4_000);
        employees[8] = new Employee("Иванов", "Иван", "Иванович", (byte) 4, 125_000);
        employees[9] = new Employee("Иванов", "Иван", "Иванович", (byte) 5, 38_000);

        //получить список всех сотрудников
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
        System.out.println();

        //посчитать сумму затрат на ЗП
        System.out.println("sumSalary = " + sumingSalary(employees));

        //найти сотрудника с минимальной ЗП
        System.out.println("minSalary = " + findMinSalary(employees));

        //найти сотрудника с максимальной ЗП
        System.out.println("maxSalary = " + findMaxSalary(employees));

        //Подсчитать среднее значение зарплат
        System.out.println("averageSalary(employees) = " + averageSalary(employees));
        System.out.println();

        //Распечатать ФИО всех сотрудников (метод void)
        printFIO(employees);
        System.out.println();

        //Базовая сложновсть завершена. начинается повышенная
        //Проиндексировать ЗП
        indexingSalary(employees, (float) 1.2);

        //минимальная зарплата в отделе
        System.out.println("findMinSalary(employees,1) = " + findMinSalary(employees, (byte) 1));

        //максимальная зарплата в отделе
        System.out.println("findMaxSalary(employees,2) = " + findMaxSalary(employees, (byte) 2));

        //сумма зарплат по отделу
        System.out.println("sumingSalary(employees,3) = " + sumingSalary(employees, (byte) 3));

        //средняя зарплата по отделу
        System.out.println("averageSalary(employees,4) = " + averageSalary(employees, (byte) 4));
        System.out.println();

        //индексация зарплат отдела
        indexingSalary(employees, (byte) 3, (float) 50);

        //распечатать данные сотрудников отдела
        printDepartament(employees, (byte) 3);
        System.out.println();

        //ЗП меньше параметра (распечатать id, фио и зп в консоль)
        printEmployeesFewerLevelSalary(employees, 9500);
        System.out.println();


        //ЗП больше или равно параметру (распечатать id, фио и зп в консоль)
        printEmployeesHigherLevelSalary(employees, 36000);
        System.out.println();


    }
}