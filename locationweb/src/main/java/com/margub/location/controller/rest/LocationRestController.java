package com.margub.location.controller.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.margub.location.entities.Location;
import com.margub.location.repos.ILocationReposistory;

@RestController
@RequestMapping("/locations")
public class LocationRestController {

	@Autowired
	ILocationReposistory locationReposistory;

	@GetMapping
	public List<Location> getLocations() {
		return locationReposistory.findAll();
	}

	@PostMapping
	public Location createLocation(@RequestBody Location location) {
		return locationReposistory.save(location);
	}

	@PutMapping
	public Location updateLocation(@RequestBody Location location) {
		return locationReposistory.save(location);

	}
	
	@DeleteMapping("/{id}")
	public void deleteLocation(@PathVariable("id") int id) {
		locationReposistory.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Location getLocationById(@PathVariable("id") int id) {	
		
		
		Optional<Location> findById = locationReposistory.findById(id);
		return findById.orElse(null);
	}

}
