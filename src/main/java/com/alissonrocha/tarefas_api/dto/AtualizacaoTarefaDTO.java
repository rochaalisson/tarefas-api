package com.alissonrocha.tarefas_api.dto;

import java.time.LocalDate;

public record AtualizacaoTarefaDTO(
        String titulo,
        LocalDate dataEntrega,
        String responsavel
) {
}
