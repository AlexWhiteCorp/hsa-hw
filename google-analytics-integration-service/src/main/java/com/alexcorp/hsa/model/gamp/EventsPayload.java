package com.alexcorp.hsa.model.gamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@RequiredArgsConstructor
public class EventsPayload {

    @JsonProperty("client_id")
    private final String clientId;

    private final List<? extends EventPayload> events;

}
