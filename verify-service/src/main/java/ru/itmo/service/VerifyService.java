package ru.itmo.service;


import ru.itmo.dto.VerificationRequestDTO;
import ru.itmo.dto.VerificationResponseDTO;

public interface VerifyService {

    VerificationResponseDTO verifyUserMessage(VerificationRequestDTO requestDTO);
}
