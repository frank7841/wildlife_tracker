import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EndangeredAnimalTest {
    public EndangeredAnimal setupEndangeredAnimal() {
        return new EndangeredAnimal("pantha", "ill", "old");
    }

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void EndangeredAnimals_instanciatesCorrectly_true() {
        EndangeredAnimal testEndangeredAnimal = setupEndangeredAnimal();
        assertEquals(true, testEndangeredAnimal instanceof EndangeredAnimal);

    }

    @Test
    public void EndangeredAnimals_instanciatesWithName_true() {
        EndangeredAnimal testEndangeredAnimal = setupEndangeredAnimal();
        assertEquals("pantha", testEndangeredAnimal.getName());
    }

    @Test
    public void EndangeredAnimals_instanciatesWithHealth_true() {
        EndangeredAnimal testEndangeredAnimal = setupEndangeredAnimal();
        assertEquals("ill", testEndangeredAnimal.getHealth());
    }

    @Test
    public void EndangeredAnimals_instanciatesWithAge_true() {
        EndangeredAnimal testEndangeredAnimal = setupEndangeredAnimal();
        assertEquals("old", testEndangeredAnimal.getAge());
    }
    @Test
    public void EndangeredAnimals_returnIfnameIsSame_true(){
        EndangeredAnimal testEndangeredAnimal=setupEndangeredAnimal();
        EndangeredAnimal testEndangeredAnimal1=setupEndangeredAnimal();
        assertTrue(testEndangeredAnimal.equals(testEndangeredAnimal1));
    }
    @Test
    public void EndangeredAnimals_successfullyAddsAnimalToDatabase_List(){
        EndangeredAnimal testEndangeredAnimal=setupEndangeredAnimal();
        testEndangeredAnimal.save();
        assertTrue(EndangeredAnimal.all().get(0).equals(testEndangeredAnimal));
    }
    @Test
    public void save_assignsIdToEndangeredAnimal() {
        EndangeredAnimal testEndangeredAnimal=setupEndangeredAnimal();
        testEndangeredAnimal.save();
        EndangeredAnimal savedEndangeredAnimal = EndangeredAnimal.all().get(0);
        Assert.assertEquals(savedEndangeredAnimal.getId(), testEndangeredAnimal.getId());
    }
    @Test
    public void all_returnsAllInstancesOfEndangeredAnimal_true() {
        EndangeredAnimal firstEndageredAnimal = setupEndangeredAnimal();
        firstEndageredAnimal.save();
        EndangeredAnimal secondEndangeredAnimal = setupEndangeredAnimal();
        secondEndangeredAnimal.save();
        assertEquals(true, EndangeredAnimal.all().get(0).equals(firstEndageredAnimal));
        assertEquals(true, EndangeredAnimal.all().get(1).equals(secondEndangeredAnimal));
    }
    @Test
    public void find_returnsEndangeredAnimalWithSameId_secondEndangeredAnimal() {
        EndangeredAnimal firstEndageredAnimal = setupEndangeredAnimal();
        firstEndageredAnimal.save();
        EndangeredAnimal secondEndangeredAnimal = setupEndangeredAnimal();
        secondEndangeredAnimal.save();
        assertEquals(EndangeredAnimal.find(secondEndangeredAnimal.getId()), secondEndangeredAnimal);
    }
    @Test
    public void delete_deletesEndangeredAnimal_true() {
        EndangeredAnimal testEndangeredAnimal = setupEndangeredAnimal();
        testEndangeredAnimal.save();
        testEndangeredAnimal.delete();
        assertEquals(null, EndangeredAnimal.find(testEndangeredAnimal.getId()));
    }
}
