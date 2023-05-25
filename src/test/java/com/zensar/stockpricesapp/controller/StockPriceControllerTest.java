package com.zensar.stockpricesapp.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zensar.stockpricesapp.dto.StockPriceDto;
import com.zensar.stockpricesapp.service.StockPriceService;




@WebMvcTest(StockPriceController.class)
public class StockPriceControllerTest {
	
	@Autowired
	ObjectMapper objectMapper;
	@Autowired
	MockMvc mockMvc;
	@MockBean
	StockPriceService stockPriceService;
	@Test
	public void getAllStocksTest() throws Exception {
		List<StockPriceDto> stockList = new ArrayList<StockPriceDto>();
        stockList.add(new StockPriceDto(1,"IBM",29));
       
        when(stockPriceService.getAllStocks()).thenReturn(stockList);

        MvcResult mvcResult = this.mockMvc
                .perform(get("http://localhost:8004/stock/stocks")).andExpect(status().isOk()).andReturn();
	}
	
}
