package com.jonah.vttp5_ssf_day09l.Service;

import java.io.StringReader;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jonah.vttp5_ssf_day09l.model.Weather;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@Service
public class WeatherService {
    RestTemplate restTemplate = new RestTemplate();
    public String weatherUrl = "http://api.weatherapi.com/v1/current.json?";
    

    public String getWeatherData(String apiKey,String country, String airQuality){
        
        System.out.println("api key : " + apiKey);
        weatherUrl = weatherUrl.concat("key=" +apiKey);
        weatherUrl = weatherUrl.concat("&q=" + country);
        weatherUrl = weatherUrl.concat("&aqi=" + airQuality);
        System.out.println("weather url is: " + weatherUrl);

        String weatherRawData =  restTemplate.getForEntity(weatherUrl, String.class).getBody().toString();
        System.out.println("raw data: " + weatherRawData);
        return weatherRawData;
    }
    //use json-p to extract the data out
    //create the weather object
    //do these in service class

    public Weather filterWeatherData(String rawWeatherData){
        Weather weather = new Weather();
        JsonReader JsonReader = Json.createReader(new StringReader(rawWeatherData));
        JsonObject weatherJsonObject = JsonReader.readObject();
        System.out.println("weather json object is" + weatherJsonObject);
        JsonObject locationJsonObject = weatherJsonObject.getJsonObject("location");
        System.out.println("location json object is" + locationJsonObject);
        
        weather.setCountry(locationJsonObject.getString("name"));
        weather.setLatitude(Integer.toString(locationJsonObject.getInt("lat")));
        weather.setLongitude(Integer.toString(locationJsonObject.getInt("lon")));

        System.out.println("weather object created!: " + weather);
        


        return null;
    }
}
