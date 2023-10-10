package com.project.apptarefas.controllers;

import com.project.apptarefas.tarefa.dto.TarefaDL;
import com.project.apptarefas.tarefa.dto.TarefaDPO;
import com.project.apptarefas.tarefa.dto.TarefaDTO;
import com.project.apptarefas.tarefa.entity.Tarefa;
import com.project.apptarefas.tarefa.enums.Prioridade;
import com.project.apptarefas.tarefa.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@RestController
@RequestMapping("/")
public class TarefaController {

    @Autowired
    private TarefaRepository repository;

    @GetMapping
    public String teste(){
        return "Está conectado. :)";
    }

    @PostMapping("/cadastrar")
    @Transactional
    public void cadastrar(@RequestBody @Valid TarefaDTO dados){

        repository.save(new Tarefa(dados));
    }

    @GetMapping("/lista")
    public ResponseEntity<List<TarefaDL>> listar(){
        ResponseEntity<List<TarefaDL>> ok = ResponseEntity.ok(repository.findBySituacao(FALSE)
                .stream()
                .map(TarefaDL::new)
                .collect(Collectors.toList()));
        return ok;
    }

    @GetMapping("/lista/concluidas")
    public ResponseEntity<List<TarefaDL>> listarConcluidas(){
        ResponseEntity<List<TarefaDL>> ok = ResponseEntity.ok(repository.findBySituacao(TRUE)
                .stream()
                .map(TarefaDL::new)
                .collect(Collectors.toList()));
        return ok;
    }

    @GetMapping("/lista/por-prioridade/{prioridade}")
    public ResponseEntity<List<TarefaDL>>  listarPorPrioridade(@PathVariable Prioridade prioridade){

//        ResponseEntity<List<TarefaDL>> ok = ResponseEntity.ok(repository.findByPrioridade(prioridade)
//                .stream()
//                .map(TarefaDL::new)
//                .collect(Collectors.toList()));
//        return ok;

        List<TarefaDL> listaEmAndamento = repository.findBySituacao(FALSE)
                .stream()
                .map(TarefaDL::new)
                .collect(Collectors.toList());

        List<TarefaDL> listaPorPrioridade = new ArrayList<>();

        listaEmAndamento.forEach(tarefaDL -> {
            if(tarefaDL.getPrioridade() == prioridade){
                listaPorPrioridade.add(tarefaDL);
            }
        });

        return ResponseEntity.ok(listaPorPrioridade);
    }

    @PutMapping("/atualizar")
    @Transactional
    public ResponseEntity<String> atualizar(@RequestBody @Valid TarefaDPO dados){
        var tarefa = repository.getReferenceById(dados.getId());
        tarefa.putTarefa(dados);

        return ResponseEntity.ok("Tarefa atualizada com sucesso.");
    }

    @PutMapping("/concluir/{id}")
    @Transactional
    public ResponseEntity<Void> concluir(@PathVariable Long id){
        repository.getReferenceById(id).setSituacao(TRUE);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/excluir/{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }


}
