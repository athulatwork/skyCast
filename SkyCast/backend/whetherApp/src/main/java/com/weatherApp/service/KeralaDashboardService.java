
package com.weatherApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.weatherApp.constants.KeralaDistricts;
import com.weatherApp.dto.DistrictWeatherDTO;
import com.weatherApp.dto.WeatherResponseDTO;

@Service
public class KeralaDashboardService {

    private final WeatherService weatherService;

    public KeralaDashboardService(
            WeatherService weatherService) {

        this.weatherService = weatherService;
    }

    public List<DistrictWeatherDTO> getAllDistrictWeather() {

        return KeralaDistricts.DISTRICTS
                .stream()
                .map(city -> {

                    WeatherResponseDTO weather =
                            weatherService.getWeatherData(city);

                    return new DistrictWeatherDTO(
                            city,
                            weather.getTemperature(),
                            weather.getHumidity(),
                            weather.getDescription()
                    );

                })
                .toList();
    }
}