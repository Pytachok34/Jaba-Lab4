import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Reader {
    public String read(Path targetFilePath) {
        try {
            return Files.readString(targetFilePath);
        } catch (final IOException ioe) {
            System.err.println(ioe.getMessage());
            return "";
        }
    }
    public void checkDataValidity(final List<String> data) {
        try {
            Integer.parseInt(data.get(0));
        } catch (Exception e) {
            throw new RuntimeException("Invalid employee id");
        }

        if(Integer.parseInt(data.get(0)) < 0) {
            throw new RuntimeException("Invalid employee id");
        }

        if(!data.get(2).equals("Male") && !data.get(2).equals("Female")) {
            throw new RuntimeException("Invalid gender");
        }

        try {
            LocalDate.parse(data.get(3));
        } catch (Exception e) {
            throw new RuntimeException("Invalid data");
        }

        if(Integer.parseInt(data.get(5)) < 0) {
            throw new RuntimeException("Invalid salary");
        }
    }
    private Employees createNewEmployees(final String sourceLine, List<Division> divisionList) {
        final var targetLine = Arrays.asList(sourceLine.split(";"));

        checkDataValidity(targetLine);

        final int id = Integer.parseInt(targetLine.get(0));
        final String name = targetLine.get(1);
        final Gender gender = targetLine.get(2).equals("Male") ? Gender.Male : Gender.Female;
        final LocalDate birthDate = LocalDate.parse(targetLine.get(3));

        final var listOfEqualsDivision = divisionList.stream().filter(elem->elem.getName().equals(targetLine.get(4))).toList();
        final Division division = listOfEqualsDivision.size() > 0 ? listOfEqualsDivision.get(0) : new Division(targetLine.get(4));

        final int Salary = Integer.parseInt(targetLine.get(5));

        return new Employees(id, name, gender, birthDate, division, Salary);
    }


}
