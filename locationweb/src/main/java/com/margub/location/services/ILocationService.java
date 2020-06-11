package com.margub.location.services;

import com.margub.location.entities.Location;

import java.util.List;

public interface ILocationService {

    Location saveLocation(Location location);

    Location updateLocation(Location location);

    void deleteLocation(Location location);

    Location getLocationById(int id);

    List<Location> getAllLocations();


}
