package com.ricardo.InsaneBeauty.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;
@Data
@Entity
public class Agendamento {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome_completo;
    private String telefone;
    private String servico;
    private LocalDate data;
    private LocalTime hora;

}
