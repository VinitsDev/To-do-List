package br.com.projects.To_do_List.dtos;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TaskRequest(
        @NotBlank(message = "Nome não pode ser nulo")
        String name,

        @NotBlank(message = "Descrição não pode ser nulo")
        String description,

        @NotNull(message = "Data não pode ser nula")
        @Future(message = "A data deve ser futura")
        LocalDate deadline) {
}
