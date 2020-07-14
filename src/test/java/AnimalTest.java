import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AnimalTest {
    @Test
    public void animals_instanciatesCorrectly_true() {
        Animal testAnimal = new Animal("pantha");
        assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    public void animals_instanciatesWithName_true() {
        Animal testAnimal = new Animal("pantha");
        assertEquals("pantha", testAnimal.getName());

    }
    @Test
    public void animals_returnIfnameIsSame_true(){
        Animal testAnimal=new Animal("pantha");
        Animal testAnimal1=new Animal("pantha");
        assertTrue(testAnimal.equals(testAnimal1));
    }
    @Test
    public void save_insertsObjectIntoDatabase_Animal() {
        Animal testAnimal = new Animal("pantha");
        testAnimal.save();
        assertTrue(Animal.all().get(0).equals(testAnimal));
    }

}