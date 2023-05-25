package com.zensar.stockpricesapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.zensar.stockpricesapp.dto.StockPriceDto;
import com.zensar.stockpricesapp.entity.StockPriceEntity;
import com.zensar.stockpricesapp.repository.StockPriceRepository;

@WebMvcTest(StockPriceServiceImpl.class)
public class StockPriceServiceTest {

	@Autowired
	StockPriceService stockPriceService;

	@MockBean
	ModelMapper modelMapper;
	@MockBean
	StockPriceRepository stockPriceRepository;

	@Test
	public void getAllStocks() throws Exception {
		StockPriceServiceImpl impl = new StockPriceServiceImpl();
		impl.modelMapper = this.modelMapper;
		impl.stockPriceRepository = this.stockPriceRepository;

		List<StockPriceDto> l1 = new ArrayList<>();
		List<StockPriceEntity> l2 = new ArrayList<>();
		StockPriceDto stockPriceDto = new StockPriceDto(1, "Apple", 45);
		l1.add(stockPriceDto);

		StockPriceEntity stockPriceEntity = new StockPriceEntity(1, "Apple", 45);
		l2.add(stockPriceEntity);
		when(stockPriceRepository.save(stockPriceEntity)).thenReturn(stockPriceEntity);
		when(stockPriceRepository.findAll()).thenReturn(l2);

		when(modelMapper.map(any(StockPriceDto.class), eq(StockPriceEntity.class))).thenReturn(stockPriceEntity);
		when(modelMapper.map(any(StockPriceEntity.class), eq(StockPriceDto.class))).thenReturn(stockPriceDto);

		assertEquals(l1, impl.getAllStocks());
	}
	
	}
