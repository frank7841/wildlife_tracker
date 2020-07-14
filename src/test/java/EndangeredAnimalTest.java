import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EndangeredAnimalTest {
    public EndangeredAnimal setupEndangeredAnimal() {
        return new EndangeredAnimal("panther", "ill", "old");
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
        assertEquals("panther", testEndangeredAnimal.getName());
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
}
