package com.example.springboot_jpa_osiv.integration;

import com.example.springboot_jpa_osiv.global.DatabaseCleaner;
import com.example.springboot_jpa_osiv.support.MemberFixture;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public abstract class SpringIntegrationTest {

    @Autowired
    protected MemberFixture memberFixture;

    @LocalServerPort
    private int port;
    
    @Autowired
    private DatabaseCleaner databaseCleaner;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
        databaseCleaner.execute();
    }
}
