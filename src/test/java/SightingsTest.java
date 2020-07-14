import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SightingsTest  {
    public Sightings setupSighting(){ return new Sightings(1,"Riverbank","Mbaku"); }
    @Rule
    public DatabaseRule database=new DatabaseRule();

    @Test
    public void Sighting_instanciatesCorrectly_true(){
        Sightings testSighting=setupSighting();
        assertEquals(true,testSighting instanceof Sightings);
    }
    @Test
    public void Sighting_instanciatesWithLocation_true(){
        Sightings testSighting=setupSighting();
        assertEquals("Riverbank",testSighting.getLocation());
    }
    @Test
    public void Sighting_instanciatesRangerName_true(){
        Sightings testSighting=setupSighting();
        assertEquals("mbaku",testSighting.getRangerName());
    }
}