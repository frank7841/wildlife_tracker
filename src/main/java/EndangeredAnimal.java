import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class EndangeredAnimal extends Animal{
    private String health;
    private String age;
    public static final String DATABASE_TYPE = "endangered";
    public EndangeredAnimal(String name, String health, String age) {
        super(name);
        this.name = name;
        this.health= health;
        this.age = age;
        type=DATABASE_TYPE;
    }
}
