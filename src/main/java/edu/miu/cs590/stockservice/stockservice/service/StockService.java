package edu.miu.cs590.stockservice.stockservice.service;

import edu.miu.cs590.stockservice.stockservice.dto.StockDto;
import edu.miu.cs590.stockservice.stockservice.util.ServerResponse;
import org.springframework.http.ResponseEntity;

public interface StockService {

    ResponseEntity<ServerResponse> addStock(StockDto stockDto);

    ResponseEntity<ServerResponse> updateStock(StockDto stockDto);
}
