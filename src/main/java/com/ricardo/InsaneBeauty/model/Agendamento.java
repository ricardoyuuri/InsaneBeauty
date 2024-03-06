package com.ricardo.InsaneBeauty.model;

import java.util.Random;
public record Agendamento(Long id, String nomeCompleto, String telefone, String servico, LocalDate data, LocalDateTime hora) {

        public Agendamento(Long id, String nomeCompleto, String telefone, String servico, LocalDate data, LocalDateTime hora){
            var key = (id != null) ? id : Math.abs( new Random().nextLong());
            this.id = key;
            this.nomeCompleto = nomeCompleto;
            this.telefone = telefone;
            this.servico = servico;
            this.data = data;
            this.hora = hora;
        }
    
}
