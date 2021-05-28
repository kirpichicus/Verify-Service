package ru.itmo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessageDTO {
    private Integer code;
    private LocalDateTime timestamp;
    private String systemMessage;
    private String userMessage;
    private String rootMessage;
    private List<String> fields;
}
