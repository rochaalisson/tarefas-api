package com.alissonrocha.tarefas_api.service.impl;

import com.alissonrocha.tarefas_api.dto.AtualizacaoTarefaDTO;
import com.alissonrocha.tarefas_api.dto.CriacaoTarefaDTO;
import com.alissonrocha.tarefas_api.dto.TarefaDTO;
import com.alissonrocha.tarefas_api.entity.Tarefa;
import com.alissonrocha.tarefas_api.exception.NotFoundException;
import com.alissonrocha.tarefas_api.repository.TarefaRepository;
import com.alissonrocha.tarefas_api.service.TarefaService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TarefaServiceImpl implements TarefaService {
    private final TarefaRepository tarefaRepository;

    @Override
    public List<TarefaDTO> obterTodas() {
        return tarefaRepository.findAll().stream()
                .map(t -> new TarefaDTO(t.getId(), t.getTitulo(), t.getDataEntrega(), t.getResponsavel()))
                .toList();
    }

    @Override
    @Transactional
    public void criar(CriacaoTarefaDTO novaTarefa) {
        Tarefa tarefa = Tarefa.builder()
                .titulo(novaTarefa.titulo())
                .dataEntrega(novaTarefa.dataEntrega())
                .responsavel(novaTarefa.responsavel())
                .build();
        tarefaRepository.save(tarefa);
    }

    @Override
    @Transactional
    public void atualizar(Integer id, AtualizacaoTarefaDTO tarefaAtualizada) {
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(NotFoundException::new);

        if (tarefaAtualizada.titulo() != null) {
            tarefa.setTitulo(tarefaAtualizada.titulo());
        }
        if (tarefaAtualizada.dataEntrega() != null) {
            tarefa.setDataEntrega(tarefaAtualizada.dataEntrega());
        }
        if (tarefaAtualizada.responsavel() != null) {
            tarefa.setResponsavel(tarefaAtualizada.responsavel());
        }

        tarefaRepository.save(tarefa);
    }

    @Override
    @Transactional
    public void excluir(Integer id) {
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(NotFoundException::new);

        tarefaRepository.delete(tarefa);
    }
}
