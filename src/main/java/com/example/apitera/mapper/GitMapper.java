package com.example.apitera.mapper;

import com.example.apitera.dto.Response;

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
