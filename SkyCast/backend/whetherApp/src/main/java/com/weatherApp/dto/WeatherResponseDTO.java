package com.weatherApp.dto;

import com.weatherApp.model.WeatherAdvice;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponseDTO {
    private double temperature;
    private String description;
    private int humidity;
    private WeatherAdvice aiSummary;

}
