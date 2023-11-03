package com.grupo29.parking.repository;

import com.grupo29.parking.model.Estacionamento;
import com.grupo29.parking.model.StatusTransacao;
import com.grupo29.parking.repository.spring.ParkingRepositorySpring;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ParkingRepositoryGatewayImpl implements ParkingRepositoryGateway {

  private final ParkingRepositorySpring parkingRepositorySpring;

  public ParkingRepositoryGatewayImpl(ParkingRepositorySpring parkingRepositorySpring) {
    this.parkingRepositorySpring = parkingRepositorySpring;
  }

  @Override
  public Estacionamento parkingCheckin(Estacionamento parking) {
    return parkingRepositorySpring.save(new Estacionamento(parking.getPlaca(), LocalDateTime.now()));
  }

  @Override
  public Estacionamento parkingCheckout(String placa) {
    Estacionamento checkoutParking = parkingRepositorySpring.findByPlacaAndStatus(placa, StatusTransacao.ATIVA).get(0);

    if (checkoutParking != null) {
      checkoutParking.setHoraSaida(LocalDateTime.now());
      checkoutParking.setStatus(StatusTransacao.FINALIZADA);

      return parkingRepositorySpring.save(checkoutParking);
    }

    return null;
  }

  @Override
  public List<Estacionamento> findAllPark(String placa) {
    return parkingRepositorySpring.findAll();
  }
}
