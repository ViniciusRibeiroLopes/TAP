package com.fatec.team.mappers;

import com.fatec.team.dtos.TeamRequest;
import com.fatec.team.dtos.TeamResponse;
import com.fatec.team.entities.Team;

public class TeamMapper {

    public static Team toEntity(TeamRequest request) {
        Team team = new Team();
        team.setName(request.name());
        team.setCity(request.city());
        team.setState(request.state());
        team.setFoundationYear(request.foundationYear());
        team.setStadium(request.stadium());
        team.setCoach(request.coach());
        return team;
    }

    public static TeamResponse toDTO(Team team) {
        return new TeamResponse(
            team.getId(),
            team.getName(),
            team.getCity(),
            team.getState(),
            team.getFoundationYear(),
            team.getStadium(),
            team.getCoach()
        );
    }
}
