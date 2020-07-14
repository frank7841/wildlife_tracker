import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        assertEquals("Mbaku",testSighting.getRangerName());
    }
    @Test
    public void Sighting_instanciatesRangerAnimalId_true(){
        Sightings testSighting=setupSighting();
        assertEquals(1,testSighting.getAnimalId());
    }
    @Test
    public void Sightings_returnIfnameIsSame_true(){
        Sightings testSighting=setupSighting();
        Sightings testSighting1=setupSighting();
        assertTrue(testSighting.equals(testSighting1));
    }
}