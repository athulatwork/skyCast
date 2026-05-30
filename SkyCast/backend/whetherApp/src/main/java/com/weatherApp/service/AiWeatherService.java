package com.weatherApp.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import com.weatherApp.model.WeatherAdvice;

@Service
public class AiWeatherService {
    
    private final   ChatClient  chatClient;
     
    public AiWeatherService(ChatClient.Builder builder){

         this.chatClient =  builder.build();

    }
     public WeatherAdvice anlyzeWeather(double  temperature, int humidity , String description ){
         String promt = """
                  You are a weather expert 
                  
                 Temperature: %s°C
                Humidity: %s%%
                Condition: %s

                  Provide :
                  1. Summary 
                  2.Cloting  recommendaion
                  3.  Travel advice

                  Keep responese under  50 words.   
                  """ .formatted(temperature, humidity,description);
                return chatClient.prompt()
                    .user(
                    promt
                    )
                    .call()

                    
                    .entity(WeatherAdvice.class);

                     }
}
