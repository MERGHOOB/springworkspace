package com.margub.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.margub.flightreservation.entities.Passanger;

public interface IPassangerRepository extends JpaRepository<Passanger, Long> {

}
