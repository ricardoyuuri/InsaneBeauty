package com.ricardo.InsaneBeauty.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
public record Agendamento(Long id, String nome_completo, String telefone, String servico, LocalDate data, LocalTime hora) {

        public Agendamento(Long id, String nome_completo, String telefone, String servico, LocalDate data, LocalTime hora){
            var key = (id != null) ? id : Math.abs( new Random().nextLong());
            this.id = key;
            this.nome_completo = nome_completo;
            this.telefone = telefone;
            this.servico = servico;
            this.data = data;
            this.hora = hora;
        }
    
}
