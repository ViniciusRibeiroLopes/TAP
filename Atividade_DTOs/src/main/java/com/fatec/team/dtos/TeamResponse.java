package com.fatec.team.dtos;

public record TeamResponse(
    Long id,
    String name,
    String city,
    String state,
    Integer foundationYear,
    String stadium,
    String coach
) {

}
