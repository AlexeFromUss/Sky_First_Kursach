import java.util.Objects;

public class Employee {
    private static int createID = 0;
    //переменные
    private String firstname;
    private String lastname;
    private String patronymic;
    private byte department;
    private float salary;
    private int id;

    //методы класса
    public Employee(String lastname, String firstname, String patronymic, byte department, float salary) {
        this.id = createID++;
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.department = department;
        this.salary = salary;
    }


    //геттеры, сеттеры и т.д.
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public byte getDepartment() {
        return department;
    }

    public void setDepartment(byte department) {
        this.department = department;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && id == employee.id && Objects.equals(firstname, employee.firstname) && Objects.equals(lastname, employee.lastname) && Objects.equals(patronymic, employee.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, patronymic, department, salary, id);
    }
}
