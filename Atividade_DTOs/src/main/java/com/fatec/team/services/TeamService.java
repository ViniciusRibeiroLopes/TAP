package com.fatec.team.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fatec.team.dtos.TeamRequest;
import com.fatec.team.dtos.TeamResponse;
import com.fatec.team.entities.Team;
import com.fatec.team.mappers.TeamMapper;
import com.fatec.team.repositories.TeamRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TeamService {

    private final TeamRepository repository;

    TeamService(TeamRepository repository) {
        this.repository = repository;
    }

    public List<TeamResponse> findAll() {
        return repository.findAll()
                         .stream()
                         .map(TeamMapper::toDTO)
                         .toList();
    }

    public TeamResponse findById(Long id) {
        Team team = repository.findById(id)
                              .orElseThrow(() -> new EntityNotFoundException("Time não cadastrado"));
        return TeamMapper.toDTO(team);
    }

    public void deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Time não cadastrado");
        }
    }

    public TeamResponse save(TeamRequest team) {
        Team t = repository.save(TeamMapper.toEntity(team));
        return TeamMapper.toDTO(t);
    }

    public void update(TeamRequest team, Long id) {
        Team t = repository.findById(id)
                           .orElseThrow(() -> new EntityNotFoundException("Time não cadastrado"));

        t.setName(team.name());
        t.setCity(team.city());
        t.setState(team.state());
        t.setFoundationYear(team.foundationYear());
        t.setStadium(team.stadium());
        t.setCoach(team.coach());

        repository.save(t);
    }
}
