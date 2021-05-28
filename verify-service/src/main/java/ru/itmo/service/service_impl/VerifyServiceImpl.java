package ru.itmo.service.service_impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.itmo.dto.VerificationRequestDTO;
import ru.itmo.dto.VerificationResponseDTO;
import ru.itmo.entity.VerificateResult;
import ru.itmo.entity.VerificateResultRepository;
import ru.itmo.service.VerifyService;


@RequiredArgsConstructor
@Slf4j
@Service
public class VerifyServiceImpl implements VerifyService {


    private final VerificateResultRepository verificateResultRepository;
    private final PythonService pythonService;

    @Override
    public VerificationResponseDTO verifyUserMessage(VerificationRequestDTO requestDTO) {


        Double result = pythonService.startModel(requestDTO);
        Boolean resultTrueFalse = Math.round(result) == 1;

        verificateResultRepository.saveAndFlush(new VerificateResult(requestDTO.getUserId(),requestDTO.getMessage(),result,resultTrueFalse));


        return new VerificationResponseDTO(requestDTO.getUserId(),requestDTO.getMessage(),result,resultTrueFalse);
    }

}
