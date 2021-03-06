import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sightings {

    private String location;
    private String rangerName;
    private int id;
    public int animalId;

    public  Sightings(int animalId, String location, String rangerName){
        this.animalId = animalId;
        this.location = location;
        this.rangerName =rangerName;
    }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getRangerName() { return rangerName;}
    public void setRangerName(String rangerName) {this.rangerName = rangerName; }
    public void setId(int id) {
        this.id = id;
    }
    public int getAnimalId() { return animalId; }
    public void setAnimalId(int animalId) {this.animalId = animalId; }
    public int getId() {return id; }

    public static List<Sightings> all() {
        String sql = "SELECT * FROM sightings";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(Sightings.class);
        }
    }
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (animalid, location, rangername) VALUES (:animalId, :location, :rangerName)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("animalId", this.animalId)
                    .addParameter("location", this.location)
                    .addParameter("rangerName", this.rangerName)
                    .executeUpdate()
                    .getKey();
        }
    }
    public void delete() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM sightings WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }
    }

    public static Sightings find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings where id=:id";
            Sightings sighting = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sightings.class);
            return sighting;
        }
    }
    public List<Object> getSightings() {
        List<Object> allSightings = new ArrayList<Object>();

        try(Connection con = DB.sql2o.open()) {
            String sqlSighting = "SELECT * FROM sightings WHERE animalid=:id";
            List<Sightings> sightings = con.createQuery(sqlSighting)
                    .addParameter("id", this.id)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Sightings.class);
            allSightings.addAll(sightings);

            String sqlEndangeredAnimal = "SELECT * FROM sightings WHERE animalid=:id AND type='endangered';";
            List<Sightings> endangeredSightings = con.createQuery(sqlSighting)
                    .addParameter("id", this.id)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Sightings.class);
            allSightings.addAll(endangeredSightings);
        }

        return allSightings;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sightings sighting = (Sightings) o;
        return animalId == sighting.animalId &&
                Objects.equals(location, sighting.location) &&
                Objects.equals(rangerName, sighting.rangerName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(animalId, location, rangerName);
    }
}


