public class Division {
    private int id;
    private String name;
    private static int startId = 0;

    public Division(final String nameOfDivision) {
        this.name = nameOfDivision;
        this.id = startId;
        ++startId;
    }

    final public int getId() {
        return this.id;
    }

    final public String getName() {
        return this.name;
    }
}
