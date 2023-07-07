package com.alexcorp.hsa.client;

import com.alexcorp.hsa.model.gamp.EventsPayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "google-analytics", url = "${clients.google-analytics.url}")
public interface GoogleAnalyticsClient {

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/mp/collect?api_secret={apiSecret}&measurement_id={measurementId}",
            produces = "application/json")
    void publishEvent(@PathVariable String apiSecret,
                      @PathVariable String measurementId,
                      EventsPayload payload);

}
