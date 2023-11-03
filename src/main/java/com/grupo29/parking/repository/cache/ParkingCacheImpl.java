package com.grupo29.parking.repository.cache;

import com.grupo29.parking.model.Estacionamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingCacheImpl implements ParkingCache {

  private static final String CACHE_NAME = "parkingCache";

  private final CacheManager cacheManager;

  @Autowired
  public ParkingCacheImpl(CacheManager cacheManager) {
    this.cacheManager = cacheManager;
  }


  @Override
  public List<Estacionamento> getParkingCache(String placa) {
    Cache cache = cacheManager.getCache(CACHE_NAME);
    if (cache != null) {
      Cache.ValueWrapper valueWrapper = cache.get(placa);
      if (valueWrapper != null) {
        return (List<Estacionamento>) valueWrapper.get();
      }
    }
    return new ArrayList<>();
  }

  @Override
  public void setParkingCache(String placa, Estacionamento estacionamento) {
    Cache cache = cacheManager.getCache(CACHE_NAME);
    if (cache != null) {
      cache.put(placa, estacionamento);
    }
  }
}
