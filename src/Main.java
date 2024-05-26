import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Reader rd = new Reader();
        System.out.println(rd.read(Path.of("src/files/foreign_names.csv")));

    }
}