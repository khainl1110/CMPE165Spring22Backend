package com.example.backend.RestController;

import com.example.backend.Model.City;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cities")
public class CityController {

	@PostMapping("/{lat}/{lon}")
	public City findNearest(@PathVariable("lat") double lat, @PathVariable("lon") double lon) {
		return City.findNearest(lat, lon);
	}
	
	@PostMapping("/{name}/{lat}/{lon}")
	public City addCity(@PathVariable("name") String name, @PathVariable("lat") double lat, @PathVariable("lon") double lon) {
		City.addCity(name, lat, lon);
		return new City(name, lat, lon);
	}
}
