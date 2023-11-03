package com.grupo29.parking.service;

import com.grupo29.parking.model.Estacionamento;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class ProcessPaymentParking {

  BigDecimal execute(Estacionamento parking) {
    LocalDateTime horaEntrada = parking.getHoraEntrada();
    LocalDateTime horaSaida = parking.getHoraSaida();

    long diferencaEmHoras = Duration.between(horaEntrada, horaSaida).toHours();

    BigDecimal valor = BigDecimal.valueOf(3.00);

    if (diferencaEmHoras > 2) {
      long horasAdicionais = diferencaEmHoras - 2;
      BigDecimal valorAdicional = BigDecimal.valueOf(1.50).multiply(BigDecimal.valueOf(horasAdicionais));
      valor = valor.add(valorAdicional);
    }

    return valor;
  }
}
