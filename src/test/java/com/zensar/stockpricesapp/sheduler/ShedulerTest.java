package com.zensar.stockpricesapp.sheduler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.zensar.stockpricesapp.entity.StockPriceEntity;
import com.zensar.stockpricesapp.repository.StockPriceRepository;
import com.zensar.stockpricesapp.scheduler.StockPriceScheduler;
import com.zensar.stockpricesapp.service.StockPriceService;

@WebMvcTest(StockPriceScheduler.class)
public class ShedulerTest {
	@MockBean
	StockPriceService stockPriceService;
	@MockBean
	StockPriceRepository stockRepo;

	@Autowired
	ModelMapper modelMapper;
	
	@Test
	public void testUpdateStockPriceForCompanyApple() {
		StockPriceEntity stockEntity = new StockPriceEntity(1, "apple", 88);
		when(stockRepo.findByName("apple")).thenReturn(stockEntity);
		assertNotEquals(89, stockEntity.getPrice());
	}
	@Test
	public void testUpdateStockPriceForCompanyIbm() {
		StockPriceEntity stockEntity = new StockPriceEntity(1, "IBM", 88);
		when(stockRepo.findByName("IBM")).thenReturn(stockEntity);
		assertNotEquals(86, stockEntity.getPrice());
	}
	@Test
	public void testUpdateStockPriceForCompanyInfosys() {
		StockPriceEntity stockEntity = new StockPriceEntity(1, "Infosys", 88);
		when(stockRepo.findByName("Infosys")).thenReturn(stockEntity);
		assertNotEquals(80, stockEntity.getPrice());
	}
	@Test
	public void testUpdateStockPriceForCompanyReliance() {
		StockPriceEntity stockEntity = new StockPriceEntity(1, "Reliance", 88);
		when(stockRepo.findByName("Reliance")).thenReturn(stockEntity);
		assertNotEquals(90, stockEntity.getPrice());
	}
	@Test
	public void testUpdateStockPriceForCompanyZensar() {
		StockPriceEntity stockEntity = new StockPriceEntity(1, "Zensar", 88);
		when(stockRepo.findByName("Zensar")).thenReturn(stockEntity);
		assertNotEquals(90, stockEntity.getPrice());
	}
	
	
	

	@Test
	public void getAllUpdatedStocksTest() {
		List<StockPriceEntity> stockEntity = new ArrayList<>();
		stockEntity.add(new StockPriceEntity(1, "apple", 23));
		stockEntity.add(new StockPriceEntity(2, "ibm", 35));
		stockEntity.add(new StockPriceEntity(3, "zensar", 95));
		when(stockRepo.findAll()).thenReturn(stockEntity);
		assertEquals(3, stockEntity.size());
	}
	
	

}
