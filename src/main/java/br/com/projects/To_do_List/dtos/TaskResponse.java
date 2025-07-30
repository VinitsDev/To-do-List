package br.com.projects.To_do_List.dtos;

import java.time.LocalDate;

public record TaskResponse(
        String name,
        String description,
        LocalDate deadline,
        LocalDate createdAt) {
}
