package com.ricardo.InsaneBeauty.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.InsaneBeauty.model.Agendamento;

@RestController
@RequestMapping("agendamento")
public class AgendamentoController {

    Logger log = LoggerFactory.getLogger(getClass());

    List<Agendamento>  repository = new ArrayList<>();

    @GetMapping
    public List<Agendamento> index(){
        return repository;
    }
    
    @PostMapping
    public ResponseEntity<Agendamento> create(@RequestBody Agendamento agendamento){
        log.info("Cadastrando agendamento: {}", agendamento);
        repository.add(agendamento);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(agendamento);
    }

    @GetMapping("{id}")
    public ResponseEntity<Agendamento> get(@PathVariable Long id){
        log.info("Buscar por id: {}", id);

        var optionalAgendamento = buscarAgendamentoPorId(id);

        if (optionalAgendamento.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(optionalAgendamento.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        log.info("Apagando agendamento {}", id);

        var optionalAgendamento = buscarAgendamentoPorId(id);

        if (optionalAgendamento.isEmpty())
            return ResponseEntity.notFound().build();

        repository.remove(optionalAgendamento.get());

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Agendamento agendamento){
        log.info("Atualizando agendamento id {} para {}", id, agendamento);

        var optionalAgendamento = buscarAgendamentoPorId(id);

        if (optionalAgendamento.isEmpty())
            return ResponseEntity.notFound().build();

        var agendamentoEncontrado = optionalAgendamento.get();
        var agendamentoAtualizado = new Agendamento(id, agendamento.nome_completo(), agendamento.telefone(), agendamento.servico(), agendamento.data(), agendamento.hora());
        repository.remove(agendamentoEncontrado);
        repository.add(agendamentoAtualizado);

        return ResponseEntity.ok().body(agendamentoAtualizado);
    
}

    private Optional<Agendamento> buscarAgendamentoPorId(Long id){
        var optionalAgendamento = repository
                .stream()
                .filter(c -> c.id().equals(id))
                .findFirst();
        return optionalAgendamento;
    }

}