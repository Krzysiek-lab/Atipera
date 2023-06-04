package com.example.apitera.interfaces;

import com.example.apitera.model.Branch;
import com.example.apitera.model.GitRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

@Service
public interface GitService {
    ResponseEntity<Object> repositories(String header, String userName);

    default Set<GitRepository> getRepositories(String header, String userName) throws IOException {
        URL url = new URL("https://api.github.com/users/" + userName + "/repos");
        StringBuilder jsonObject = getStringBuilder(header, url);
        ObjectMapper objectMapper = new ObjectMapper();
        var repos = objectMapper.readValue(String.valueOf(jsonObject), GitRepository[].class);
        for (GitRepository repository : repos) {
            try {
                var res = getBranchesForAllRepositories(header, userName, repository.getName());
                repository.setBranchSet(res);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        return Set.of(repos);
    }

    private Set<Branch> getBranchesForAllRepositories(String header, String userName, String repoName) throws IOException {
        URL url = new URL("https://api.github.com/repos/" + userName + "/" + repoName + "/branches");
        StringBuilder jsonObject = getStringBuilder(header, url);
        ObjectMapper objectMapper = new ObjectMapper();
        return new HashSet<>(Set.of(objectMapper.readValue(String.valueOf(jsonObject), Branch[].class)));
    }

    private StringBuilder getStringBuilder(String header, URL url) throws IOException {
        String[] arr = header.split(": ");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setRequestProperty(arr[0], arr[1]);
        urlConnection.setRequestProperty("Authorization", "Bearer " + "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"); // wygaśnie za 30 dni pozwala na dostep do prywatnych repozytoriów (nie wiem czy powinienem byl podawac)
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        StringBuilder jsonObject = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            jsonObject.append(line);
        }
        bufferedReader.close();
        return jsonObject;
    }
}
