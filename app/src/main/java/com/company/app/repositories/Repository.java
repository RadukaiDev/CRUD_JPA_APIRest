package com.company.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.app.models.Persona;

public interface Repository extends JpaRepository<Persona, Long> {

}
