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

    public Employees(final String sourceLine) {
        final var params = Arrays.asList(sourceLine.split(";"));

        this.id = Integer.parseInt(params.get(0));
        this.name = params.get(1);
        this.gender = params.get(2) == "Male" ? Gender.Male : Gender.Female;
        this.birthDate = LocalDate.parse(params.get(3));
        this.Salary = Integer.parseInt(params.get(4));
    }


}