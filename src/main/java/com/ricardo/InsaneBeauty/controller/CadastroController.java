package com.ricardo.InsaneBeauty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.InsaneBeauty.model.Cadastro;
import com.ricardo.InsaneBeauty.repository.CadastroRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("cadastro")
public class CadastroController {

    @Autowired
    CadastroRepository repository;

    @PostMapping
    public Cadastro create(@RequestBody @Valid Cadastro cadastro){
        return repository.save(cadastro);
    }
    
}
