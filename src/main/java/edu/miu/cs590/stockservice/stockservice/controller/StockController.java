package edu.miu.cs590.stockservice.stockservice.controller;

import edu.miu.cs590.stockservice.stockservice.dto.StockDto;
import edu.miu.cs590.stockservice.stockservice.service.StockService;
import edu.miu.cs590.stockservice.stockservice.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/add")
    public ResponseEntity<ServerResponse> addStock( @Valid  @RequestBody StockDto stockDto) {
        return stockService.addStock(stockDto);
    }

    @PostMapping("/update")
    public ResponseEntity<ServerResponse> updateStock(@Valid @RequestBody StockDto stockDto) {
        return stockService.updateStock(stockDto);
    }
}
