package ru.itmo.rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import ru.itmo.dto.ErrorMessageDTO;
import ru.itmo.dto.VerificationRequestDTO;
import ru.itmo.dto.VerificationResponseDTO;
import ru.itmo.service.VerifyService;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Slf4j
@RestController
public class VerifyController {

    private final VerifyService verifyService;
    private final ObjectMapper mapper;

    @PostMapping(value = "/api/verification.verify-user-message", produces = MediaType.APPLICATION_JSON_VALUE)
    public VerificationResponseDTO saveFileInRepository(@RequestBody VerificationRequestDTO request) throws Exception {

        log.info("пришел запрос на верификацию сообщения пользователя - {}", mapper.writeValueAsString(request));
        try {
            return verifyService.verifyUserMessage(request);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity handleEntityNotFoundEx(Exception ex, WebRequest request) {

        ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO(000, LocalDateTime.now(), ex.getMessage(), ex.getMessage(), ex.getMessage(), null);
        return new ResponseEntity(errorMessageDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
