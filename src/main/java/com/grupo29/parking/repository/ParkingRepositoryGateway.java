package com.grupo29.parking.repository;

import com.grupo29.parking.model.Estacionamento;

import java.util.List;

public interface ParkingRepositoryGateway {

  Estacionamento parkingCheckin(Estacionamento parking);

  Estacionamento parkingCheckout(String placa);

  List<Estacionamento> findAllPark(String placa);
}
