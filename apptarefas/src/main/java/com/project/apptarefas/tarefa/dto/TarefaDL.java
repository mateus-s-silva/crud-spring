package com.project.apptarefas.tarefa.dto;

import com.project.apptarefas.tarefa.entity.Tarefa;
import com.project.apptarefas.tarefa.enums.Prioridade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Enumerated;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TarefaDL {

    private Long id;
    @NotBlank
    private String titulo;

    @NotBlank
    private String responsavel;

    private String descricao;

    @Enumerated
    private Prioridade prioridade;

    @Future
    private Date deadline;

    @NotNull
    private String situacao;

    public TarefaDL(Tarefa tarefa) {
        this.titulo = tarefa.getTitulo();
        this.descricao = tarefa.getDescricao();
        this.responsavel = tarefa.getResponsavel();
        this.prioridade = tarefa.getPrioridade();
        this.deadline = tarefa.getDeadline();
        this.situacao = tarefa.getSituacao() ? "Concluído" : "Em andamento";
        this.id = tarefa.getId();
    }
}
