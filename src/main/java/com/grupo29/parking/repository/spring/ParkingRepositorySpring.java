package com.grupo29.parking.repository.spring;

import com.grupo29.parking.model.Estacionamento;
import com.grupo29.parking.model.StatusTransacao;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ParkingRepositorySpring extends MongoRepository<Estacionamento, String> {

  List<Estacionamento> findByPlacaAndStatus(String placa, StatusTransacao status);
}
