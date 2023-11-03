package com.grupo29.parking.repository;

import com.grupo29.parking.model.Estacionamento;

public interface ParkingRepositoryGateway {

  Estacionamento parkingCheckin(Estacionamento parking);

  Estacionamento parkingCheckout(String placa);
}
