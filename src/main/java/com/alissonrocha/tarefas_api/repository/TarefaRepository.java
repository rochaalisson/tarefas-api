package com.alissonrocha.tarefas_api.repository;

import com.alissonrocha.tarefas_api.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
}
