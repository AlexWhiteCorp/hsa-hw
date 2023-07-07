package com.alexcorp.hsa.publisher;

import com.alexcorp.hsa.client.YahooFinanceClient;
import com.alexcorp.hsa.service.GoogleAnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StockPricePublisher {

    private final YahooFinanceClient yahooFinanceClient;
    private final GoogleAnalyticsService googleAnalyticsService;

    @Value("${clients.yahoo-finance.symbols}")
    private List<String> symbols;

    @Scheduled(fixedDelayString = "${clients.google-analytics.stocks.delay}")
    public void publishStockPricesEvent() {
        var stocks = symbols.stream()
                .parallel()
                .map(yahooFinanceClient::getStockPrice)
                .toList();

        googleAnalyticsService.publishStockPrices(stocks);
    }

}
