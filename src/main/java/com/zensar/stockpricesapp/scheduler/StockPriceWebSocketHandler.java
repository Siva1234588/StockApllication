package com.zensar.stockpricesapp.scheduler;

import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.transaction.Transactional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zensar.stockpricesapp.Generated;
import com.zensar.stockpricesapp.dto.StockPriceDto;
import com.zensar.stockpricesapp.service.StockPriceService;


@Component
@Transactional
@ComponentScan("com.zensar.stockpricesapp")
@Generated
public class StockPriceWebSocketHandler implements WebSocketHandler {


	
    private final StockPriceService stockService;
    
    public StockPriceWebSocketHandler(StockPriceService stockService) {
        this.stockService = stockService;
    }

	private WebSocketSession session;
	private Timer timer;

	@Override
	public void afterConnectionEstablished(WebSocketSession session) {
		this.session = session;
		startSendingStockPrices();
	}

	public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
		// Handle incoming text messages from the client, if needed
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
		stopSendingStockPrices();
	}

	private void startSendingStockPrices() {
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// Your logic to fetch the latest stock prices of all companies
				List<StockPriceDto> stocks = stockService.getAllStocks();

				if (session.isOpen()) {
					try {
						String stockPricesJson = convertStockPricesToJson(stocks);
						session.sendMessage(new TextMessage(stockPricesJson));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}, 0, 3000); // Update stock prices every 5 seconds (adjust as needed)
	}

	private void stopSendingStockPrices() {
		if (timer != null) {
			timer.cancel();
			timer = null;
		}
	}

	

	private String convertStockPricesToJson(List<StockPriceDto> stocks) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(stocks);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			// Handle the exception as per your application's requirements
			return null;
		}

		// Convert the list of Stock objects to JSON format
		// You can use a library like Jackson or Gson for this conversion
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}


}
