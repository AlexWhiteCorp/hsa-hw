package com.alexcorp.hsa.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
public class YahooStock implements Stock {

    private Summary quoteSummary;

    @Override
    public String getSymbol() {
        return quoteSummary
                .getResult().get(0)
                .getPrice()
                .getSymbol();
    }

    @Override
    public String getPrice() {
        return quoteSummary
                .getResult().get(0)
                .getPrice()
                .getRegularMarketPrice()
                .getRaw();
    }

    @Getter
    @Setter
    @NoArgsConstructor
    private static class Summary {

        private List<Result> result;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    private static class Result {

        private Module price;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    private static class Module {

        private String symbol;
        private Price regularMarketPrice;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    private static class Price {

        private String raw;
        private String fmt;

    }

}
