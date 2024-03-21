package com.ricardo.InsaneBeauty.model;


import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class Cadastro {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "{cadastro.nome_completo.notblank}")
    private String nome_completo;

    @NotBlank(message = "{cadastro.telefone.notblank}")
    @Pattern(regexp = "\\d{10,11}", message = "{cadastro.telefone.pattern}")
    private String telefone;

    @NotBlank(message = "{cadastro.email.notblank}")
    @Email(message = "{cadastro.email.email}")
    private String email;

    @NotBlank(message = "{cadastro.senha.notblank}")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$", message = "{cadastro.senha.pattern}")
    private String senha;

    @NotBlank(message = "{cadastro.cpf.notblank}")
    @CPF(message = "{cadastro.cpf.cpf}")
    private String cpf;

    @NotBlank(message = "{cadastro.cep.notblank}")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "{cadastro.cep.pattern}")
    private String cep;

    @NotBlank(message = "{cadastro.numero_residencial.notblank}")
    private String numero_residencial;
}
