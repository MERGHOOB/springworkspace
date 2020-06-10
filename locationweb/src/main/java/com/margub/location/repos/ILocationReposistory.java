package com.margub.location.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.margub.location.entities.Location;

public interface ILocationReposistory extends JpaRepository<Location, Integer> {

}
