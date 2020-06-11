package com.margub.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.margub.flightreservation.entities.Reservation;

public interface IReservationRepository extends JpaRepository<Reservation, Long> {

}
