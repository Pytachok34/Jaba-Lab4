import org.jetbrains.annotations.NotNull;

public class Division {
    /**Идентификатор данного подразделения*/
    @NotNull
    private final int id;
    /**Название данного подразделения*/
    private final String name;
    /**Переменная хранящая первый свободный идентификатор*/
    private static int startId = 0;
    /**
     * Конструктор класса, присваивающий имя подразделению
     * выдаётся первый свободный идентификатор
     * увеличивает значение свободного идентификатора на 1
     * @param nameOfDivision
     */
    public Division(final String nameOfDivision) {
        this.name = nameOfDivision;
        this.id = startId;
        ++startId;
    }
    /**
     * Метод возвращающий идентификатор
     * @return идентификатор даннаого подразделения
     */
    final public int getId() {
        return this.id;
    }
    /**
     * Метод возвращающий имя подразделения
     * @return имя данного подразделения
     */
    final public String getName() {
        return this.name;
    }
}
