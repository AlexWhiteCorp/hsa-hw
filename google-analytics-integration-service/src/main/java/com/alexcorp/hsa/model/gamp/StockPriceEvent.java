package com.alexcorp.hsa.model.gamp;

import com.alexcorp.hsa.model.Stock;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@ToString
public class StockPriceEvent implements EventPayload {

    private final String name;
    private final Map<String, String> params = new HashMap<>();

    public StockPriceEvent(String name, List<? extends Stock> stocks) {
        this.name = name;
        stocks.forEach(stock -> params.put(stock.getSymbol(), stock.getPrice()));
    }
}
