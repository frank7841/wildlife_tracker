import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class Animal {
    public String name;
    public String type;
    public int id;

    public Animal(String name ){ this.name = name;}

    public String getName() {return name;}

    public int getId() {return id;}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name);
    }
}
