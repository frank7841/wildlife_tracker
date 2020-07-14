import junit.framework.TestCase;
import org.junit.Rule;

public class SightingsTest  {
    public Sightings setupSighting(){ return new Sightings(1,"Riverbank","Mbaku"); }
    @Rule
    public DatabaseRule database=new DatabaseRule();


}