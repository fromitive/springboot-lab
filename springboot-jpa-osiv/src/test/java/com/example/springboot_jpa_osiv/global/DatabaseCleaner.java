package com.example.springboot_jpa_osiv.global;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class DatabaseCleaner {

    @PersistenceContext
    private EntityManager entityManager;


    public void execute() { // TODO: 테이블명 빼와서 반복문으로 돌리기
        entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY FALSE").executeUpdate();
        clearMember();
        entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY TRUE").executeUpdate();
    }

    private void clearMember() {
        entityManager.createNativeQuery("DELETE FROM member").executeUpdate();
        entityManager.createNativeQuery("ALTER TABLE member ALTER COLUMN id RESTART").executeUpdate();
    }
}
