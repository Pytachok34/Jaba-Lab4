import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class Employees {
    /**Идетификатор сотрудника*/
    @NotNull
    private int id;
    /**Имя сотрудника*/
    private String name;
    /** Пол сотрудника*/
    private Gender gender;
    /** Дата рождения сотрудника*/
    private LocalDate birthDate;
    /**Подразделение сотрудника*/
    @NotNull
    private Division division;
    /** Зарплата сотрудника*/
    private int Salary;
    /**Конструктор класса, принимающий все свойства и устанавливающий их*/
    public Employees(final int id, final String name, final Gender gender,
                    final LocalDate birthDate, final Division division, final int Salary) {

        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.division = division;
        this.Salary = Salary;
    }
    /**Метод, возращающий строку со всеми свойствами пользователя*/
    public  String getInfo() {
        return String.format(" Id:%d \n Name: %s \n Gender: %s \n BithDate: %s \n Division id: %d \n Division name: %s \n Salary: %d \n ----------------",
                id, name, gender.toString(), birthDate.toString() ,division.getId(), division.getName(), Salary);
    }


}