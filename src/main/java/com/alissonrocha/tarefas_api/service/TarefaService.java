package com.alissonrocha.tarefas_api.service;

import com.alissonrocha.tarefas_api.dto.AtualizacaoTarefaDTO;
import com.alissonrocha.tarefas_api.dto.CriacaoTarefaDTO;
import com.alissonrocha.tarefas_api.dto.TarefaDTO;

import java.util.List;

public interface TarefaService {
    List<TarefaDTO> obterTodas();
    void criar(CriacaoTarefaDTO novaTarefa);
    void atualizar(Integer id, AtualizacaoTarefaDTO tarefaAtualizada);
    void excluir(Integer id);
}
