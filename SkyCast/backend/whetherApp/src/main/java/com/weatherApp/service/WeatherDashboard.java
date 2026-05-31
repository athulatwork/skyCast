package com.weatherApp.service;

import org.springframework.stereotype.Service;

@Service
public class WeatherDashboard {
    private final WeatherService weatherService;
     public WeatherDashboard(WeatherService weatherService){
        this.weatherService = weatherService;
     }
     
}
