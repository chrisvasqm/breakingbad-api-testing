package com.chrisvasqm.data;

import com.chrisvasqm.model.Character;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Characters implements Repository<Character> {

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
