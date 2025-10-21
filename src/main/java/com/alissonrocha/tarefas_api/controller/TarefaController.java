package com.alissonrocha.tarefas_api.controller;

import com.alissonrocha.tarefas_api.dto.CriacaoTarefaDTO;
import com.alissonrocha.tarefas_api.dto.TarefaDTO;
import com.alissonrocha.tarefas_api.dto.AtualizacaoTarefaDTO;
import com.alissonrocha.tarefas_api.entity.Tarefa;
import com.alissonrocha.tarefas_api.repository.TarefaRepository;
import com.alissonrocha.tarefas_api.service.TarefaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tarefas")
public class TarefaController {
    private final TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> obterTodas() {
        List<TarefaDTO> tarefas = tarefaService.obterTodas();

        return ResponseEntity.ok(tarefas);
    }

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody @Valid CriacaoTarefaDTO novaTarefa) {
        tarefaService.criar(novaTarefa);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Integer id, @RequestBody @Valid AtualizacaoTarefaDTO tarefaAtualizada) {
        tarefaService.atualizar(id, tarefaAtualizada);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        tarefaService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
