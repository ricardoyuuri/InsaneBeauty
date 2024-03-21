package com.ricardo.InsaneBeauty.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
public class Agendamento {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "{agendamento.nome_completo.notblank}")
    private String nome_completo;

    @NotBlank(message = "{agendamento.telefone.notblank}")
    @Pattern(regexp = "\\d{10,11}", message = "{agendamento.telefone.pattern}")
    private String telefone;

    @NotBlank(message = "{agendamento.servico.notblank}")
    private String servico;

    @NotNull(message = "{agendamento.data.notnull}")
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    @Future(message = "{agendamento.data.future}") 
    private LocalDate data;

    private LocalTime hora;

}
