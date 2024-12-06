package com.jonah.vttp5_ssf_day09l.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jonah.vttp5_ssf_day09l.Service.CarparkService;
import com.jonah.vttp5_ssf_day09l.Service.WeatherService;
import com.jonah.vttp5_ssf_day09l.model.Carpark;

@Controller
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    CarparkService carparkService;
    @Autowired
    WeatherService weatherService;

    @GetMapping("/carparks")
    @ResponseBody
    public List<Carpark> getCarparkRates(){
        List<Carpark> carparks = carparkService.getCarparkRates();
        return carparks;
    }

    @GetMapping("/weather")
    @ResponseBody
    public void getWeather(){
        String rawWeatherData = weatherService.getWeatherData("0f6d360558364c8799c14438240612","London","no");
        weatherService.filterWeatherData(rawWeatherData);
    }
}
