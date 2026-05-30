package com.weatherApp.dto;

import com.weatherApp.model.WeatherAdvice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WeatherResponseDTO {
    private double temperature;
    private String description;
    private int humidity;
    private WeatherAdvice aiSummary;

}
