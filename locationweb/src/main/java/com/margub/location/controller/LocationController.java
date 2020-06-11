package com.margub.location.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.margub.location.entities.Location;
import com.margub.location.repos.ILocationReposistory;
import com.margub.location.services.ILocationService;
import com.margub.location.utilities.IEmailService;
import com.margub.location.utilities.reports.IReportService;

@Controller
public class LocationController {

	@Autowired
	ILocationService locationService;

	@Autowired
	ILocationReposistory locationRepository;

	@Autowired
	IEmailService emailService;

	@Autowired
	IReportService reportService;

	@Autowired
	ServletContext servletContext;

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}

	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		Location locationSaved = locationService.saveLocation(location);
		String message = "Location saved with id " + locationSaved.getId();
		modelMap.addAttribute("msg", message);

//        emailService.sendEmail("springudemy7@gmail.com", "SAVE LOCATION", message);
		return "createLocation";
	}

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap) {
		List<Location> allLocations = locationService.getAllLocations();
		modelMap.addAttribute("locations", allLocations);
		return "displayLocations";
	}

	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
		locationService.deleteLocation(locationService.getLocationById(id));

		List<Location> allLocations = locationService.getAllLocations();
		modelMap.addAttribute("locations", allLocations);

		return "displayLocations";
	}

	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
		Location location = locationService.getLocationById(id);
		modelMap.addAttribute("location", location);

		return "updateLocation";
	}

	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {

		locationService.updateLocation(location);
		List<Location> locations = locationService.getAllLocations();
		modelMap.addAttribute("locations", locations);

		return "displayLocations";
	}

	/**
	 * To publish report
	 */
	@RequestMapping("/generateReport")
	public String generateReport() {

		String path = servletContext.getRealPath("/");
		List<Object[]> data = locationRepository.findTypeAndTypeCount();
		reportService.generatePiChart(path, data);

		return "report";
	}

}
