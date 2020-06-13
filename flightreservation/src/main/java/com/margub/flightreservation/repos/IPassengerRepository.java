package com.margub.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.margub.flightreservation.entities.Passenger;

public interface IPassengerRepository extends JpaRepository<Passenger, Long> {

}
