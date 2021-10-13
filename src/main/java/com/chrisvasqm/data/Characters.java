package com.chrisvasqm.data;

import com.chrisvasqm.model.Character;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;

public class Characters implements Repository<Character> {

    public Characters() {
        RestAssured.baseURI = "https://www.breakingbadapi.com/api";
        RestAssured
                .config()
                .objectMapperConfig(objectMapperConfig().defaultObjectMapperType(ObjectMapperType.GSON));
    }

    @Override
    public List<Character> getAll() {
        return given()
                .when()
                .get("/characters")
                .then()
                .extract()
                .body()
                .jsonPath()
                .getList(".", Character.class);
    }

}
