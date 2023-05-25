package com.zensar.stockpricesapp.scheduler;

import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zensar.stockpricesapp.dto.StockPriceDto;
import com.zensar.stockpricesapp.entity.StockPriceEntity;
import com.zensar.stockpricesapp.repository.StockPriceRepository;
@Component
public class StockPriceScheduler {
	@Autowired
	StockPriceRepository stockPriceRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	
	 
	@Scheduled(fixedDelay = 3000)
	public void updateStockPriceJob1() {
		Random ran=new Random();
		int p=ran.nextInt(100);
		StockPriceEntity stockPriceEntity = this.stockPriceRepository.findByName("Apple");
		stockPriceEntity.setPrice(p);
		StockPriceEntity spe1 = this.stockPriceRepository.save(stockPriceEntity);
		StockPriceDto sde1=modelMapper.map(spe1, StockPriceDto.class);
	
		
	
	}
	
	@Scheduled(fixedDelay = 3000)
	public void updateStockPriceJob2() {
		Random ra=new Random();
		int p=ra.nextInt(100);
		StockPriceEntity stockPriceEntity = this.stockPriceRepository.findByName("IBM");
		stockPriceEntity.setPrice(p);
		StockPriceEntity spe1 = this.stockPriceRepository.save(stockPriceEntity);
		StockPriceDto sde1=modelMapper.map(spe1, StockPriceDto.class);
		
		
	
	}
	
	@Scheduled(fixedDelay = 3000)
	public void updateStockPriceJob3() {
		Random randm=new Random();
		int p=randm.nextInt(100);
		StockPriceEntity stockPriceEntity = this.stockPriceRepository.findByName("Infosys");
		stockPriceEntity.setPrice(p);
		StockPriceEntity spe1 = this.stockPriceRepository.save(stockPriceEntity);
		StockPriceDto sde1=modelMapper.map(spe1, StockPriceDto.class);
		
	
	}
	
	@Scheduled(fixedDelay = 3000)
	public void updateStockPriceJob4() {
		
		Random random=new Random();
		int p=random.nextInt(100);
		StockPriceEntity stockPriceEntity = this.stockPriceRepository.findByName("Reliance");
		stockPriceEntity.setPrice(p);
		StockPriceEntity spe1 = this.stockPriceRepository.save(stockPriceEntity);
		StockPriceDto sde1=modelMapper.map(spe1, StockPriceDto.class);
		
		
	
	}
	
	@Scheduled(fixedDelay = 3000)
	public void updateStockPriceJob5() {
		Random random=new Random();
		int p=random.nextInt(100);
		StockPriceEntity stockPriceEntity = this.stockPriceRepository.findByName("Zensar");
		stockPriceEntity.setPrice(p);
		StockPriceEntity spe1 = this.stockPriceRepository.save(stockPriceEntity);
		StockPriceDto sde1=modelMapper.map(spe1, StockPriceDto.class);
		
		
	
	}
}
