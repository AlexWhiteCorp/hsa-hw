package com.alexcorp.hsa.model.gamp;

import java.util.Map;

public interface EventPayload {

    String getName();

    Map<String, String> getParams();

}
