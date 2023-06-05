package com.example.atipera.controller;

import com.example.atipera.interfaces.GitService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("git/")
@AllArgsConstructor
public class GitController {
    private final GitService gitServiceImpl;
    //lepiej nie zwracac ResponseEntity z Object bo wtedy uzywanie generyka jest tu bez sensu
    @GetMapping
    public ResponseEntity<Object> allRepositories(@RequestParam() @Valid @NotEmpty String userName,
                                                               @RequestParam(defaultValue = "Accept: application/json") String header) {
        return GitServiceImpl.repositories(header, userName);
    }
}

