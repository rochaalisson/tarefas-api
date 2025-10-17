package com.alissonrocha.tarefas_api.controller;

import com.alissonrocha.tarefas_api.dto.TarefaDTO;
import com.alissonrocha.tarefas_api.entity.Tarefa;
import com.alissonrocha.tarefas_api.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tarefas")
public class TarefaController {
    private final TarefaRepository tarefaRepository;

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> obterTodas() {
        List<TarefaDTO> tarefas = tarefaRepository.findAll().stream()
                .map(t -> new TarefaDTO(t.getId(), t.getTitulo(), t.getDataEntrega(), t.getResponsavel()))
                .toList();

        return ResponseEntity.ok(tarefas);
    }
}
