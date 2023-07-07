package com.alexcorp.hsa.service;

import com.alexcorp.hsa.client.GoogleAnalyticsClient;
import com.alexcorp.hsa.config.StockEventsProperties;
import com.alexcorp.hsa.model.Stock;
import com.alexcorp.hsa.model.gamp.EventsPayload;
import com.alexcorp.hsa.model.gamp.StockPriceEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GoogleAnalyticsService {

    private final GoogleAnalyticsClient client;
    private final StockEventsProperties stockEventsProps;

    @Value("${clients.google-analytics.api-secret}")
    private String apiSecret;

    public void publishStockPrices(List<? extends Stock> stocks) {
        var event = new StockPriceEvent(stockEventsProps.getEventName(), stocks);
        var payload = new EventsPayload(stockEventsProps.getClientId(), List.of(event));

        log.info("GAMP::Publish Stock Prices Event: {}", payload);
        client.publishEvent(apiSecret, stockEventsProps.getMeasurementId(), payload);
    }

}
