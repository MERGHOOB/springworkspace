package com.margub.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.margub.flightreservation.entities.Flight;

public interface IFlightRepository extends JpaRepository<Flight, Long> {

}
