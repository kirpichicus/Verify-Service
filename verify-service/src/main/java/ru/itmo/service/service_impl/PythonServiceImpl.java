package ru.itmo.service.service_impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.itmo.dto.VerificationRequestDTO;
import ru.itmo.service.PythonSevice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@RequiredArgsConstructor
@Slf4j
@Service
public class PythonServiceImpl implements PythonSevice {
    @Override
    public Double startModel(VerificationRequestDTO requestDTO) {
        double result = -0.1;

        String command = "python3 " + "D:\\Verification\\fns-ospm\\verify-service\\src\\main\\resources\\Script.py" + " " + requestDTO.getMessage() + " model" + requestDTO.getUserId();
        try {
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            result = Double.parseDouble(in.readLine());
            log.info(String.valueOf(result));
        } catch (Exception e) {
            log.error("Ошибка выполения модели");
        }

        return result;
    }
}
