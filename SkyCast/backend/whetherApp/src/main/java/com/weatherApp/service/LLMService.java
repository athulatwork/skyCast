package com.weatherApp.service;
import org.springframework.stereotype.Service;
import com.weatherApp.client.NvidiaClient ;
@Service
public class LLMService {

    private final NvidiaClient client;

    public LLMService(NvidiaClient client) {
        this.client = client;
    }

    public String askLLM(String message) {
        String prompt = "You are a helpful assistant. User: " + message;
        return client.callModel(prompt);
    }
}