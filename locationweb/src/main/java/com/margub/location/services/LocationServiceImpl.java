package com.margub.location.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.margub.location.entities.Location;
import com.margub.location.repos.ILocationReposistory;

public class LocationServiceImpl implements ILocationService {
	
	@Autowired
	ILocationReposistory locationRepository;

	@Override
	public Location saveLocation(Location location) {
		return locationRepository.save(location);
		
	}

	@Override
	public Location updateLocation(Location location) {
		// TODO Auto-generated method stub
		return locationRepository.save(location);
	}

	@Override
	public void deleteLocation(Location location) {
		// TODO Auto-generated method stub
		 locationRepository.delete(location);
		
	}

	@Override
	public Location getLocationById(int id) {
		// TODO Auto-generated method stub
		Optional<Location> findById = locationRepository.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Location> getAllLocations() {
		// TODO Auto-generated method stub
		
		return locationRepository.findAll();
	}

}
