package com.alexcorp.hsa.client;

import com.alexcorp.hsa.model.YahooStock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "yahoo-finance", url = "${clients.yahoo-finance.url}")
public interface YahooFinanceClient {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/v10/finance/quoteSummary/{stockSymbol}?modules=price",
            consumes = "application/json")
    YahooStock getStockPrice(@PathVariable String stockSymbol);

}
