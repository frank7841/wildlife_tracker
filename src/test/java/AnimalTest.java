import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalTest {
    @Test
    public void animals_instanciatesCorrectly_true(){
        Animal testAnimal=new Animal("pantha");
        assertEquals(true,testAnimal instanceof Animal);
    }

}