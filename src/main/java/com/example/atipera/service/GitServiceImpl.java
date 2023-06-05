package com.example.atipera.service;

import com.example.atipera.interfaces.GitService;
import com.example.atipera.mapper.GitMapper;
import com.example.atipera.model.GitRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
@SuppressWarnings("all")
public class GitServiceImpl implements GitService {
    private final GitMapper mapper;
    // tez nie zwracac generykow z Object
    //lepiej skorzystac z HttpClienta Springowego
    @Override
    public ResponseEntity<Object> repositories(String header, String userName) {
        Set<GitRepository> response = new HashSet<>();
        try {
            response = getRepositories(header, userName);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        var opt = Optional.ofNullable(response);
        if (Objects.equals(header, "Accept: application/xml")) {
            var res = mapper.incorrectHeaderMapper(HttpStatus.resolve(406).value(), "Wrong header value");
            return new ResponseEntity<>(res, HttpStatus.valueOf(406));
        } else if (!opt.isPresent() || opt.get().isEmpty()) {
            var res = mapper.noUserMapper(HttpStatus.resolve(404).value(), "No repository with given user: " + userName);
            return new ResponseEntity<>(res, HttpStatus.valueOf(404));
        } else {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }
    }
}
