package com.grupo29.parking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "estacionamento")
public class Estacionamento {

  @Id
  private String id;
  private String placa;
  private LocalDateTime horaEntrada;
  private LocalDateTime horaSaida;
  private BigDecimal valor;
  private StatusTransacao status;

  public Estacionamento(String placa, LocalDateTime horaEntrada) {
    this.id = UUID.randomUUID().toString();
    this.placa = placa;
    this.horaEntrada = horaEntrada;
    this.horaSaida = null;
    this.status = StatusTransacao.ATIVA;
  }
}
