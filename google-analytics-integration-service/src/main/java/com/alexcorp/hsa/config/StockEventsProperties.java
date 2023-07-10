package com.alexcorp.hsa.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "clients.google-analytics.stocks")
public class StockEventsProperties {

    private String clientId;
    private String measurementId;
    private String eventName;

}
