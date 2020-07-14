import junit.framework.TestCase;
import org.junit.Assert;
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
    @Test
    public void save_assignsIdToSighting() {
        Sightings testSighting=setupSighting();
        testSighting.save();
        Sightings savedSighting = Sightings.all().get(0);
        Assert.assertEquals(savedSighting.getId(), testSighting.getId());
    }
    @Test
    public void Sightings_successfullyAddsSightingsToDatabase_List(){
        Sightings testSighting1=setupSighting();
        testSighting1.save();
        assertTrue(Sightings.all().get(0).equals(testSighting1));
    }

    @Test
    public void all_returnsAllInstancesOfSighting_true() {
        Sightings firstSighting = setupSighting();
        firstSighting.save();
        Sightings secondSighting = setupSighting();
        secondSighting.save();
        assertEquals(true, Sightings.all().get(0).equals(firstSighting));
        assertEquals(true, Sightings.all().get(1).equals(secondSighting));
    }
    @Test
    public void find_returnsSightingWithSameId_secondSighting() {
        Sightings firstSighting = setupSighting();
        firstSighting.save();
        Sightings secondSighting = setupSighting();
        secondSighting.save();
        assertEquals(Sightings.find(secondSighting.getId()), secondSighting);
    }

}