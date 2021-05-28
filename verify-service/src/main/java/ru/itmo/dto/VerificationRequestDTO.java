package ru.itmo.dto;

import lombok.Data;

@Data
public class VerificationRequestDTO {
    private long userId;
    private String message;
}
