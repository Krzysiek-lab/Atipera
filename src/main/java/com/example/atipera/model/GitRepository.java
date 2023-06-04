package com.example.atipera.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitRepository {
    private String name;
    private Owner owner;

    //czy tak zadziala?
    private Set<Branch> branchSet;
}
