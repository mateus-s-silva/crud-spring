package com.project.apptarefas.tarefa.entity;

import com.project.apptarefas.tarefa.dto.TarefaDPO;
import com.project.apptarefas.tarefa.dto.TarefaDTO;
import com.project.apptarefas.tarefa.enums.Prioridade;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Setter
@Getter
@ToString
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor


@Entity
public class Tarefa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private String responsavel;

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    private Date deadline;

    private Boolean situacao;

    public Tarefa(TarefaDTO dados){
        this.titulo = dados.getTitulo();
        this.descricao = dados.getDescricao();
        this.responsavel = dados.getResponsavel();
        this.prioridade = dados.getPrioridade();
        this.deadline = dados.getDeadline();
        this.situacao = false;
    }

    public void putTarefa(TarefaDPO tarefa) {
        this.titulo = Objects.nonNull(tarefa.getTitulo()) ? tarefa.getTitulo() : this.titulo;
        this.deadline = Objects.nonNull(tarefa.getDeadline()) ? tarefa.getDeadline() : this.deadline;
        this.responsavel = Objects.nonNull(tarefa.getResponsavel()) ? tarefa.getResponsavel() : this.responsavel;
        this.prioridade = Objects.nonNull(tarefa.getPrioridade()) ? tarefa.getPrioridade() : this.prioridade;
        this.descricao = Objects.nonNull(tarefa.getDescricao()) ? tarefa.getDescricao() : this.descricao;
        this.situacao = Objects.nonNull(tarefa.getSituacao()) ? tarefa.getSituacao() : this.situacao;
    }
}
