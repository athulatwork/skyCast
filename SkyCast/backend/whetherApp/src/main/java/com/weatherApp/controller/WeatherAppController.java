
package com.weatherApp.controller;

import org.springframework.web.bind.annotation.*;

import com.weatherApp.dto.WeatherResponseDTO;
import com.weatherApp.service.WeatherService;
@RestController
@RequestMapping("/weather")
@CrossOrigin(origins ="http://localhost:3000")
public class WeatherAppController {
    
   private final  WeatherService weatherService;
   WeatherAppController(WeatherService weatherService){
    this.weatherService=weatherService;
   }
   @GetMapping("/{city}")

    public WeatherResponseDTO getWeather(
            @PathVariable String city
    ) {

        return weatherService.getWeatherData(city);
    }

    
}
