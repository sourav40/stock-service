package edu.miu.cs590.stockservice.stockservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDto {

    @NotNull(message = "Product Id can not be null.")
    private Long productId;

    private String productName;

    @NotNull(message = "Unit can not be null.")
    private int unit;

}
