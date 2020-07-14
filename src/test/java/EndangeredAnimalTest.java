import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EndangeredAnimalTest  {
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
}