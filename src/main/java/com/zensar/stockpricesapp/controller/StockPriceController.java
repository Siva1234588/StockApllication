package com.zensar.stockpricesapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.stockpricesapp.dto.StockPriceDto;
import com.zensar.stockpricesapp.service.StockPriceService;

@RestController
@RequestMapping("/stock")
@CrossOrigin(origins="*")
public class StockPriceController {
	
	@Autowired
	StockPriceService stockPriceService;
	
	

	
	@GetMapping(value="/stocks")
	//@MessageMapping("/stockpriceapp")
	//@SendTo("/topic/getall")
	public ResponseEntity<List<StockPriceDto>> getAllStocks(){
		return new ResponseEntity<List<StockPriceDto>>(stockPriceService.getAllStocks(),HttpStatus.OK);
	}

}
