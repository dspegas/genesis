
package com.genesis.pojo.coincap.history;

import java.util.HashMap;
import java.util.Map;

public class Datum {

    private String priceUsd;
    private Long time;
    private String date;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(String priceUsd) {
        this.priceUsd = priceUsd;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
