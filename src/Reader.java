import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reader {
    private List<Division> divisionList;
    Reader() {
        this.divisionList = new ArrayList<>();
    }
    private String read(Path targetFilePath) {
        try {
            return Files.readString(targetFilePath);
        } catch (final IOException ioe) {
            throw new RuntimeException(ioe.getMessage());
        }
    }
    private void checkDataValidity(final List<String> data) {
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
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
            LocalDate.parse(data.get(3), formatter);
        } catch (Exception e) {
            throw new RuntimeException("Invalid data");
        }

        if(Integer.parseInt(data.get(5)) < 0) {
            throw new RuntimeException("Invalid salary");
        }
    }
    private Employees createNewEmployees(final String sourceLine) {
        final var targetLine = Arrays.asList(sourceLine.split(";"));

        checkDataValidity(targetLine);

        final int id = Integer.parseInt(targetLine.get(0));
        final String name = targetLine.get(1);
        final Gender gender = targetLine.get(2).equals("Male") ? Gender.Male : Gender.Female;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
        final LocalDate birthDate = LocalDate.parse(targetLine.get(3), formatter);
        final Division division;

        final var listOfEqualsDivision = divisionList.stream().filter(elem->elem.getName().equals(targetLine.get(4))).toList();
        if (listOfEqualsDivision.size() > 0) {
            division = listOfEqualsDivision.get(0);
        } else {
            divisionList.add(new Division(targetLine.get(4)));
            division = divisionList.get(divisionList.size() - 1);
        }
        final int Salary = Integer.parseInt(targetLine.get(5));

        return new Employees(id, name, gender, birthDate, division, Salary);
    }
    public List<Employees> getListFromFile(final String targetFile) {
        divisionList.clear();
        String fileContent = read(Path.of(targetFile));

        fileContent = fileContent.replace("\r", "");
        fileContent = fileContent.substring(fileContent.indexOf("\n") + 1);

        return Arrays.stream(fileContent.split("\n")).map(this::createNewEmployees).toList();
    }

}
