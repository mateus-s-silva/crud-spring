package com.project.apptarefas.tarefa.repository;

import com.project.apptarefas.tarefa.entity.Tarefa;
import com.project.apptarefas.tarefa.enums.Prioridade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findByPrioridade(Prioridade prioridade);

    List<Tarefa> findBySituacao(Boolean situacao);
}
