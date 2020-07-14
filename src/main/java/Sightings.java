
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
}
