package com.fatec.team.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.team.entities.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
