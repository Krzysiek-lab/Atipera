package com.example.atipera.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Response {
    Integer code;
    String message;
}
