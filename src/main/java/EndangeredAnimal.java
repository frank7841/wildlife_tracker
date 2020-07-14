import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class EndangeredAnimal extends Animal {
    private String health;
    private String age;
    public static final String DATABASE_TYPE = "endangered";

    public EndangeredAnimal(String name, String health, String age) {
        super(name);
        this.name = name;
        this.health = health;
        this.age = age;
        type = DATABASE_TYPE;
    }

    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }

    public static String getDatabaseType() {
        return DATABASE_TYPE;
    }

    public static List<EndangeredAnimal> all() {
        String sql = "SELECT * FROM animals ;";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(EndangeredAnimal.class);
        }
    }

    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name, health, age, type) VALUES (:name, :health, :age, :type)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("health", this.health)
                    .addParameter("age", this.age)
                    .addParameter("type", this.type)
                    .executeUpdate()
                    .getKey();
        }
    }
}