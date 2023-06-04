package com.example.atipera.mapper;

import com.example.atipera.dto.Response;
import org.springframework.stereotype.Service;

@Service
public class GitMapper {
    public Response badHeader(int code, String message) {
        return Response.builder()
                .code(code)
                .message(message)
                .build();
    }

    public Response noUser(int code, String message) {
        return Response.builder()
                .code(code)
                .message(message)
                .build();
    }
}
