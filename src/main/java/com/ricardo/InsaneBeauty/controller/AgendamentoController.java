package com.ricardo.InsaneBeauty.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ricardo.InsaneBeauty.model.Agendamento;
import com.ricardo.InsaneBeauty.repository.AgendamentoRepository;

@RestController
@RequestMapping("agendamento")
public class AgendamentoController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    AgendamentoRepository agendamentoRepository;

    @GetMapping
    public List<Agendamento> index(){
        return agendamentoRepository.findAll();
    }
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Agendamento create(@RequestBody Agendamento agendamento){
        log.info("Cadastrando agendamento: {}", agendamento);
        agendamentoRepository.save(agendamento);
        return agendamento;
    }

    @GetMapping("{id}")
    public ResponseEntity<Agendamento> get(@PathVariable Long id){
        log.info("Buscar por id: {}", id);

        return agendamentoRepository
            .findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        log.info("Apagando agendamento {}", id);

        verificarSeExisteAgendamento(id);

        agendamentoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Agendamento agendamento){
        log.info("Atualizando agendamento id {} para {}", id, agendamento);

        verificarSeExisteAgendamento(id);

        agendamento.setId(id);
        agendamentoRepository.save(agendamento);
        return ResponseEntity.ok(agendamento);
    
}

    private void verificarSeExisteAgendamento(Long id) {
        agendamentoRepository
          .findById(id)
          .orElseThrow(
              () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento não encontrado" )
        );
}

}