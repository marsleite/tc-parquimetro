package com.grupo29.parking.repository.cache;

import com.grupo29.parking.model.Estacionamento;

import java.util.List;

public interface ParkingCache {

  List<Estacionamento> getParkingCache(String placa);

  void setParkingCache(String placa, Estacionamento estacionamento);
}
