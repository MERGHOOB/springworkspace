package com.margub.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.margub.flightreservation.entities.User;

public interface IUserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
