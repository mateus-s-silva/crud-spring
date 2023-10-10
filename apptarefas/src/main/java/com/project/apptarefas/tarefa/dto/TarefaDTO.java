package com.project.apptarefas.tarefa.dto;


import com.project.apptarefas.tarefa.enums.Prioridade;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Enumerated;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import java.util.Date;
@Getter
@Setter
@ToString
public class TarefaDTO {


    @NotBlank
    private String titulo;

    @NotBlank
    private String responsavel;

    private String descricao;

    @Enumerated
    private Prioridade prioridade;

    @Future
    private Date deadline;

}
