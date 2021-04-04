import com.chrisvasqm.model.Character;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;

public class BreakingBadTests {

    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = "https://www.breakingbadapi.com";
        RestAssured
                .config()
                .objectMapperConfig(objectMapperConfig().defaultObjectMapperType(ObjectMapperType.GSON));
    }

    @Test
    public void testPrintAllCharacterNamesAndActors() {
        final var characters = given()
                .when()
                .get("/api/characters")
                .then()
                .extract()
                .body()
                .jsonPath()
                .getList(".", Character.class);

        for (final var character : characters) {
            System.out.println("The actor: " + character.getPortrayed() + " played the character: " + character.getName());
        }
    }

    @AfterMethod
    public void tearDown() {
        RestAssured.reset();
    }

}
