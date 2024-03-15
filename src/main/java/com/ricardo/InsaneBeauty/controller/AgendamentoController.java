package com.ricardo.InsaneBeauty.controller;


import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

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

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("agendamento")
@Slf4j
public class AgendamentoController {

    @Autowired
    AgendamentoRepository agendamentoRepository;

    @GetMapping
    public List<Agendamento> index(){
        return agendamentoRepository.findAll();
    }
    
    @PostMapping
    @ResponseStatus(CREATED)
    public Agendamento create(@RequestBody Agendamento agendamento){
        log.info("Cadastrando agendamento: {}", agendamento);
        return agendamentoRepository.save(agendamento);
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
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id){
        log.info("Apagando agendamento {}", id);

        verificarSeExisteAgendamento(id);

        agendamentoRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public Agendamento update(@PathVariable Long id, @RequestBody Agendamento agendamento){
        log.info("Atualizando agendamento id {} para {}", id, agendamento);

        verificarSeExisteAgendamento(id);

        agendamento.setId(id);
        return agendamentoRepository.save(agendamento);
}

    private void verificarSeExisteAgendamento(Long id) {
        agendamentoRepository
          .findById(id)
          .orElseThrow(
              () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento não encontrado" )
        );
}

}