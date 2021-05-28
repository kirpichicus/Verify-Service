package ru.itmo.dto;

import lombok.Data;

@Data
public class VerificationResponseDTO {
    private long userId;
    private String message;
    private Double result;
    private Boolean resultTrueFalse;

    public VerificationResponseDTO(long userId, String message, Double result, Boolean resultTrueFalse ) {
        this.userId = userId;
        this.message = message;
        this.result = result;
        this.resultTrueFalse = resultTrueFalse;
    }
}
