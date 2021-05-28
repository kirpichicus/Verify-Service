package ru.itmo.service;

import ru.itmo.dto.VerificationRequestDTO;

public interface PythonSevice {
    Double startModel(VerificationRequestDTO requestDTO);
}
