package models;

public class Entity {

    public static String instrument;
    public static String isin;
    public static String sedol;
    public static String name;

    public Entity(String instrument, String isin, String sedol, String name) {
        this.instrument = instrument;
        this.isin = isin;
        this.sedol = sedol;
        this.name = name;
    }
}
