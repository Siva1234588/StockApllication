package com.zensar.stockpricesapp.service;

import java.net.http.WebSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import com.zensar.stockpricesapp.dto.StockPriceDto;
import com.zensar.stockpricesapp.entity.StockPriceEntity;
import com.zensar.stockpricesapp.repository.StockPriceRepository;




@Service
public class StockPriceServiceImpl implements StockPriceService {
	@Autowired
	StockPriceRepository stockPriceRepository;
	
	@Autowired 
	ModelMapper modelMapper;

	@Override
	public List<StockPriceDto> getAllStocks() {
		List<StockPriceEntity> l1=stockPriceRepository.findAll();
		
		List<StockPriceDto> l2=new ArrayList<>();
		for(StockPriceEntity spe:l1) {
			StockPriceDto s1 = this.modelMapper.map(spe, StockPriceDto.class);
			l2.add(s1);
		}
		return l2;
	}
	
	

}
