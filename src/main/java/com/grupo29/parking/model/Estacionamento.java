package com.grupo29.parking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
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
}
