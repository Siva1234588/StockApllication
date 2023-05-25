package com.zensar.stockpricesapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.stockpricesapp.dto.StockPriceDto;
import com.zensar.stockpricesapp.entity.StockPriceEntity;

@Repository
public interface StockPriceRepository extends JpaRepository<StockPriceEntity, Integer> {
	
	public StockPriceEntity findByName(String name);
	//public StockPriceDto findByName(String name);
}
