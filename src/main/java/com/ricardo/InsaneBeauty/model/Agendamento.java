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

import com.ricardo.InsaneBeauty.validation.TipoServico;

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

    @TipoServico
    @NotBlank(message = "{agendamento.servico.notblank}")
    private String servico;

    @NotNull(message = "{agendamento.data.notnull}")
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    @Future(message = "{agendamento.data.future}") 
    private LocalDate data;

    @NotNull(message = "{agendamento.hora.notnull}")
    @DateTimeFormat(pattern = "HH:MM:SS")
    //@Pattern(regexp = "^([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$", message = "{agendamento.hora.pattern}")
    private LocalTime hora;

}
