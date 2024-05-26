import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Reader rd = new Reader();
        var list = rd.getListFromFile("src/files/foreign_names.csv");
        list.forEach(x -> System.out.println(x.getInfo()));

    }
}