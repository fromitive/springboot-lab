package com.example.springboot_jpa_osiv.service;


import com.example.springboot_jpa_osiv.global.DatabaseCleaner;
import com.example.springboot_jpa_osiv.support.MemberFixture;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public abstract class SpringServiceTest {

    @Autowired
    protected DatabaseCleaner databaseCleaner;

    @Autowired
    protected MemberFixture memberFixture;

    @BeforeEach
    void setUp() {
        databaseCleaner.execute();
    }
}
