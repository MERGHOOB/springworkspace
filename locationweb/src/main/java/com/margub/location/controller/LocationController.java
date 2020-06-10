package com.margub.location.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.margub.location.entities.Location;
import com.margub.location.services.ILocationService;

@Controller
public class LocationController {
	

	@Autowired
	ILocationService locationService;
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}
	
	@RequestMapping("/saveLoc") 
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		Location locationSaved = locationService.saveLocation(location);
		String message = "Location saved with id " + locationSaved.getId();
		modelMap.addAttribute("msg", message);
		return "createLocation";
	}
	
	@RequestMapping("/")
    public String home(){
        return "home";
    }
	
	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap) {
		List<Location> allLocations = locationService.getAllLocations();
		modelMap.addAttribute("locations",allLocations);
		return "displayLocations";
	}
	
	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id")int id, ModelMap modelMap) {
		locationService.deleteLocation(locationService.getLocationById(id));
		
		List<Location> allLocations = locationService.getAllLocations();
		modelMap.addAttribute("locations",allLocations);
		
		return "displayLocations";
	}
	
	@RequestMapping("updateLocation")
	public String showUpdate(@RequestParam("id")int id, ModelMap modelMap) {
		Location location = locationService.getLocationById(id);
		modelMap.addAttribute("locationToBeUpdated", location);
		
		return "editLocation";
	}

}
