package ru.itmo.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VerificateResultRepository extends JpaRepository<VerificateResult, Long> {
    Optional<VerificateResult> findByUserId(Long verificateResult);
}

