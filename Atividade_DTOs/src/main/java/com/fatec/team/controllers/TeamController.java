package com.fatec.team.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.team.dtos.TeamRequest;
import com.fatec.team.dtos.TeamResponse;
import com.fatec.team.services.TeamService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamService service;

    TeamController(TeamService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TeamResponse>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<TeamResponse> getById(@PathVariable long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<TeamResponse> save(@Valid @RequestBody TeamRequest team) {
        TeamResponse t = service.save(team);

        URI location = ServletUriComponentsBuilder
                       .fromCurrentRequest()
                       .path("/{id}")
                       .buildAndExpand(t.id())
                       .toUri();

        return ResponseEntity.created(location).body(t);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable long id,
                                       @Valid @RequestBody TeamRequest team) {
        service.update(team, id);
        return ResponseEntity.noContent().build();
    }

}
