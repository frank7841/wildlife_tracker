import org.sql2o.Connection;

import java.util.Objects;

public class Sightings {
    public int animalId;
    private String location;
    private String rangerName;
    private int id;

    public  Sightings(int animalId, String location, String rangerName){
        this.animalId = animalId;
        this.location = location;
        this.rangerName =rangerName;

    }

    public String getLocation() { return location; }

    public String getRangerName() { return rangerName;}

    public int getAnimalId() { return animalId; }
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (location, rangername, animalid) VALUES (:location, :rangername, :animalid)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("location", this.location)
                    .addParameter("rangername", this.rangerName)
                    .addParameter("animalid", this.animalId)
                    .executeUpdate()
                    .getKey();
        }
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
}
