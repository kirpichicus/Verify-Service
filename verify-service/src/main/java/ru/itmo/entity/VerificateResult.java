package ru.itmo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Data
@Entity
@Table(	name = "verificate_result",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "verificate_result_id")
        }, schema= "verify_app")
public class VerificateResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="verificate_result_id")
    private Long verificateResultId;

    @Column(name="user_id")
    private Long userId;

    @Column(name="message")
    private String message;

    @Column(name="result")
    private Double result;

    @Column(name="result_true_false")
    private Boolean resultTrueFalse;

    public VerificateResult( Long userId, String message, Double result, Boolean resultTrueFalse) {
        this.userId = userId;
        this.message = message;
        this.result = result;
        this.resultTrueFalse = resultTrueFalse;
    }

    public VerificateResult() {

    }
}