package com.wiproo.weather.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WeatherController {


//@GetMapping("/weather")
//public String getWeather(
//@RequestParam(name = "city") String city,
//@RequestParam(name = "day") String day
//) {//
//return String.format("Weather in %s for %s is cloudy.", city, day);
//}

	@GetMapping("/tocentigrade/{fahrenheit}")
	public String toCentigrade(@PathVariable("fahrenheit") double fahrenheit) {
	double centigrade = (fahrenheit - 32) * 5 / 9.0;
	return String.format("The centigrade equivalent of %.2f°F is %.2f°C", fahrenheit, centigrade);
	}
	
}