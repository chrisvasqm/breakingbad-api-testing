import com.chrisvasqm.data.Characters;
import io.restassured.RestAssured;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BreakingBadTests {
    private Characters characters;

    @BeforeMethod
    public void setUp() {
        characters = new Characters();
    }

    @Test
    public void testPrintAllCharacterNamesAndActors() {
        if (characters == null)
            throw new IllegalStateException("The characters repository was not initialized properly.");

        if (characters.getAll().size() == 0)
            throw new IllegalStateException("The characters repository is empty.");

        for (final var character : characters.getAll())
            System.out.println("The actor: " + character.getPortrayed() + " played the character: " + character.getName());
    }

    @AfterMethod
    public void tearDown() {
        RestAssured.reset();
    }

}
