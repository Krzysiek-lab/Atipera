package com.example.atipera.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Response {
    private Integer code;
    private String message;
}
