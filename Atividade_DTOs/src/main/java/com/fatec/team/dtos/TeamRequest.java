package com.fatec.team.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TeamRequest(
    @NotBlank(message = "O nome do time não pode ser vazio")
    @Size(min = 2, max = 100, message = "O nome do time deve ter entre 2 e 100 caracteres")
    String name,

    @NotBlank(message = "A cidade não pode ser vazia")
    @Size(min = 2, max = 100, message = "A cidade deve ter entre 2 e 100 caracteres")
    String city,

    @NotBlank(message = "O estado não pode ser vazio")
    @Size(min = 2, max = 50, message = "O estado deve ter entre 2 e 50 caracteres")
    String state,

    @NotNull(message = "O ano de fundação é obrigatório")
    @Min(value = 1850, message = "O ano de fundação deve ser a partir de 1850")
    @Max(value = 2100, message = "O ano de fundação não pode exceder o ano 2100")
    Integer foundationYear,

    @NotBlank(message = "O estádio não pode ser vazio")
    @Size(min = 2, max = 100, message = "O estádio deve ter entre 2 e 100 caracteres")
    String stadium,

    @NotBlank(message = "O técnico não pode ser vazio")
    @Size(min = 2, max = 100, message = "O técnico deve ter entre 2 e 100 caracteres")
    String coach
) {

}
