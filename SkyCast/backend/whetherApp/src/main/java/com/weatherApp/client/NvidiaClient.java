package com.weatherApp.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


@Service
public class NvidiaClient {

  
    @Value("${nvidia.api.key}")
    private String apiKey;

    private final RestClient restClient;

    public NvidiaClient() {
        
        this.restClient = RestClient.builder()
                .baseUrl("https://integrate.api.nvidia.com")
                .build();
    }

    public String callModel(String prompt) {

        String requestBody = """
            {
              "model": "stepfun-ai/step-3.7-flash",
              "messages": [
                {
                  "role": "user",
                  "content": "%s"
                }
              ]
            }
            """.formatted(prompt);

        return restClient.post()
                .uri("/v1/chat/completions")
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .retrieve()
                .body(String.class);
    }
}