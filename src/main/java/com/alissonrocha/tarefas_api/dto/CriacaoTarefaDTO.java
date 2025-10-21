package com.alissonrocha.tarefas_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CriacaoTarefaDTO(
        @NotBlank
        String titulo,
        @NotNull
        LocalDate dataEntrega,
        @NotBlank
        String responsavel
) {
}
