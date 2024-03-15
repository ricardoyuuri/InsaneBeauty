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

    @NotBlank
    private String nome_completo;

    @NotBlank 
    @Pattern(regexp = "\\d{10,11}", message = "Por favor, forneça um número de telefone válido com 10 ou 11 dígitos.")
    private String telefone;

    @NotBlank  @Email(message = "Por favor, forneça um endereço de e-mail válido.")
    private String email;

    @NotBlank 
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$", 
             message = "A senha deve conter pelo menos 8 caracteres, incluindo pelo menos uma letra maiúscula, uma letra minúscula, um número e um caractere especial.")
    private String senha;

    @NotBlank @CPF(message = "Por favor, forneça um CPF válido.")
    private String cpf;

    @NotBlank
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "Por favor, forneça um CEP válido no formato XXXXX-XXX.")
    private String cep;

    @NotBlank
    private String numero_residencial;
}
