import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Employees {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private Division division;
    private int Salary;

    public Employees(final int id, final String name, final Gender gender,
                    final LocalDate birthDate, final Division division, final int Salary) {

        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.division = division;
        this.Salary = Salary;
    }

    public  String getInfo() {
        return String.format(" Id:%d \n Name: %s \n Gender: %s \n BithDate: %s \n Division id: %d \n Division name: %s \n Salary: %d \n ----------------",
                id, name, gender.toString(), birthDate.toString() ,division.getId(), division.getName(), Salary);
    }


}