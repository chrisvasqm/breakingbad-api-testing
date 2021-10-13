import com.chrisvasqm.data.Characters;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;

public class BreakingBadTests {
    private Characters characters;

    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = "https://www.breakingbadapi.com/api";
        RestAssured
                .config()
                .objectMapperConfig(objectMapperConfig().defaultObjectMapperType(ObjectMapperType.GSON));

        characters = new Characters();
    }

    @Test
    public void testPrintAllCharacterNamesAndActors() {
        if (characters == null)
            throw new IllegalStateException("The characters repository was not initialized properly.");

        for (final var character : characters.getAll()) {
            System.out.println("The actor: " + character.getPortrayed() + " played the character: " + character.getName());
        }
    }

    @AfterMethod
    public void tearDown() {
        RestAssured.reset();
    }

}
