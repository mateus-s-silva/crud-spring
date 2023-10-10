package com.project.apptarefas.tarefa.dto;

import com.project.apptarefas.tarefa.enums.Prioridade;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Enumerated;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Getter
@Setter
public class TarefaDPO {

    @NotNull
    private Long id;

    private String titulo;

    private String responsavel;

    private String descricao;

    @Enumerated
    private Prioridade prioridade;

    @Future
    private Date deadline;

    private Boolean situacao;

}
