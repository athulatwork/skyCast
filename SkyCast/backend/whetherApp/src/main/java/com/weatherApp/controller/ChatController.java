package com.weatherApp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weatherApp.dto.ChatRequest;
import com.weatherApp.service.ChatService;
import com.weatherApp.dto.ChatResponse;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/chat")
@CrossOrigin(origins = "*")
public class ChatController {
    
    private final ChatService chatService;
    public ChatController(ChatService chatService ){
    this.chatService = chatService;

}
@PostMapping
public ChatResponse chat(
        @RequestBody ChatRequest request) {

    System.out.println(request);

    String answer =
            chatService.chat(
                    request.message());

    return new ChatResponse(answer);
}
}
