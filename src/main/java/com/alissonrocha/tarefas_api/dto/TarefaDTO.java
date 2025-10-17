package com.alissonrocha.tarefas_api.dto;

import java.time.LocalDate;

public record TarefaDTO(
        Integer id,
        String titulo,
        LocalDate dataEntrega,
        String responsavel
) {
}
