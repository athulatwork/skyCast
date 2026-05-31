package com.weatherApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weatherApp.service.KeralaDashboardService;
import com.weatherApp.dto.DistrictWeatherDTO;
import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    
    private final KeralaDashboardService keralaDashboardService ;
     public DashboardController( KeralaDashboardService keralaDashboardService){
         this.keralaDashboardService = keralaDashboardService;

     }
   @GetMapping("/kerala")
    public List<DistrictWeatherDTO> getkeralaDashboard() {
        return keralaDashboardService.getAllDistrictWeather();  
    }
    
    }
