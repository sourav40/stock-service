package edu.miu.cs590.stockservice.stockservice.serviceImpl;

import edu.miu.cs590.stockservice.stockservice.dto.StockDto;
import edu.miu.cs590.stockservice.stockservice.entity.Stock;
import edu.miu.cs590.stockservice.stockservice.repository.StockRepository;
import edu.miu.cs590.stockservice.stockservice.service.StockService;
import edu.miu.cs590.stockservice.stockservice.util.ResponseUtility;
import edu.miu.cs590.stockservice.stockservice.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public ResponseEntity<ServerResponse> addStock(StockDto stockDto) {
        try {
            Stock stock = Stock.builder()
                    .productId(stockDto.getProductId())
                    .productName(stockDto.getProductName())
                    .units(stockDto.getUnit())
                    .build();
            stockRepository.save(stock);
            ServerResponse serverResponse = ResponseUtility.getSuccessfulServerResponse("Stock saved.");
            return new ResponseEntity<ServerResponse>(serverResponse, serverResponse.getHttpStatus());
        } catch (Exception e) {
            ServerResponse serverResponse = ResponseUtility.getFailedServerResponse("Unable to save stock at this time.");
            return new ResponseEntity<ServerResponse>(serverResponse, serverResponse.getHttpStatus());
        }
    }

    @Override
    public ResponseEntity<ServerResponse> updateStock(StockDto stockDto) {
        Optional<Stock> stock = stockRepository.findByProductId(stockDto.getProductId());
        if (stock.isPresent()) {
            Stock stockToUpdate = stock.get();
            stockToUpdate.setUnits(stockToUpdate.getUnits() - stockDto.getUnit());
            stockRepository.save(stockToUpdate);
            ServerResponse serverResponse = ResponseUtility.getSuccessfulServerResponse("Stock updated.");
            return new ResponseEntity<ServerResponse>(serverResponse, serverResponse.getHttpStatus());
        }
        ServerResponse serverResponse = ResponseUtility.getFailedServerResponse("Unable to update stock at this time.");
        return new ResponseEntity<ServerResponse>(serverResponse, serverResponse.getHttpStatus());
    }
}
