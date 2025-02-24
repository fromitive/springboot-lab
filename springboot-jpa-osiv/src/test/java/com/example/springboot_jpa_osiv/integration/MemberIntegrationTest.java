package com.example.springboot_jpa_osiv.integration;

import com.example.springboot_jpa_osiv.dto.MemberChangeRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

public class MemberIntegrationTest extends SpringIntegrationTest {

    @Test
    void 닉네임을_변경할_수_있다() {
        memberFixture.createMember("poke");
        MemberChangeRequest request = new MemberChangeRequest("change");

        RestAssured.given().log().all()
                .body(request)
                .contentType(ContentType.JSON)
                .when().patch("/member")
                .then().log().all()
                .statusCode(200);

        RestAssured.given().log().all()
                .when().get("/member")
                .then().log().all()
                .statusCode(200);
    }
}
