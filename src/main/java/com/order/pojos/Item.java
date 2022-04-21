package com.order.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    protected String type;

    protected String volumeOrNumber;

    @JsonCreator
    public Item(@JsonProperty("type") String type, @JsonProperty("volumeOrNumber") String volumeOrNumber) {
        this.type = type;
        this.volumeOrNumber = volumeOrNumber;
    }

    public String getType() {
        return type;
    }

    public String getVolumeOrNumber() {
        return volumeOrNumber;
    }

    @Override
    public String toString() {
        return "Item{" +
                "type='" + type + '\'' +
                ", volumeOrNumber='" + volumeOrNumber + '\'' +
                '}';
    }
}
