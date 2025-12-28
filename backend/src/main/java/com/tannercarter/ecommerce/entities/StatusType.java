package com.tannercarter.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum StatusType {

    @JsonProperty("pending")
    PENDING,

    @JsonProperty("ordered")
    ORDERED,

    @JsonProperty("cancelled")
    CANCELLED
}
