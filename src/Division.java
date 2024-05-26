import org.jetbrains.annotations.NotNull;

public class Division {
    @NotNull
    private final int id;
    private final String name;
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
