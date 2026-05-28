package com.weatherApp.service;

import org.springframework.stereotype.Service;

import com.weatherApp.dto.WeatherResponseDTO;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Value;

@Service
public class WeatherService {
    @Value("${weather.api.key}")
 private String apiKey ;

public WeatherResponseDTO getWeatherData(String city) {
        // Logic to fetch weather data from an API
        // For example, you can use RestTemplate to call an external weather API
        // and return the data as a DTO

   try{
   String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";
    

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();
   
          
            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
     String json  = response.body();


     ObjectMapper mapper = new ObjectMapper();
     JsonNode  data  = mapper.readTree(json);
 /*  System.err.println(data);
    String cityName = data.get("name").asText();
       String country = data.get("sys").get(0).asString();
       */  
        double temperature = data.get("main").get("temp").asDouble();
        String description = data.get("weather").get(0).get("description").asString();
        int humidity = data.get("main").get("humidity").asInt();
        
         return  new WeatherResponseDTO(temperature, description, humidity);
            } catch (Exception e) {
                        

         throw new RuntimeException("Failed to fetch weather data", e);

   }


}}
