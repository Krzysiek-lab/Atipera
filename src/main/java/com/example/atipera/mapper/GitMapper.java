package com.example.atipera.mapper;

import com.example.atipera.dto.Response;
import org.springframework.stereotype.Service;

@Service
public class GitMapper {
    public Response incorrectHeaderMapper(int code, String message) {
        return Response.builder()
                .code(code)
                .message(message)
                .build();
    }

    public Response noUserMapper(int code, String message) {
        return Response.builder()
                .code(code)
                .message(message)
                .build();
    }
}
