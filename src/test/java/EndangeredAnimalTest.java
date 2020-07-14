import junit.framework.TestCase;
import org.junit.Rule;

public class EndangeredAnimalTest extends{
    public EndangeredAnimal setupEndangeredAnimal(){
        return new EndangeredAnimal("panther","ill","old");
    }
    @Rule
    public DatabaseRule database=new DatabaseRule();

}