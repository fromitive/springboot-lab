package com.example.springboot_jpa_osiv.repository;

import com.example.springboot_jpa_osiv.entity.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    
    Optional<Member> findById(Long id);
}
