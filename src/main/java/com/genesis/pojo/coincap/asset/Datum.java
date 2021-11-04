
package com.genesis.pojo.coincap.asset;

import java.util.HashMap;
import java.util.Map;

public class Datum {

    private String id;
    private String rank;
    private String symbol;
    private String name;
    private String supply;
    private Object maxSupply;
    private Object marketCapUsd;
    private Object volumeUsd24Hr;
    private String priceUsd;
    private Object changePercent24Hr;
    private Object vwap24Hr;
    private String explorer;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupply() {
        return supply;
    }

    public void setSupply(String supply) {
        this.supply = supply;
    }

    public Object getMaxSupply() {
        return maxSupply;
    }

    public void setMaxSupply(Object maxSupply) {
        this.maxSupply = maxSupply;
    }

    public Object getMarketCapUsd() {
        return marketCapUsd;
    }

    public void setMarketCapUsd(Object marketCapUsd) {
        this.marketCapUsd = marketCapUsd;
    }

    public Object getVolumeUsd24Hr() {
        return volumeUsd24Hr;
    }

    public void setVolumeUsd24Hr(Object volumeUsd24Hr) {
        this.volumeUsd24Hr = volumeUsd24Hr;
    }

    public String getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(String priceUsd) {
        this.priceUsd = priceUsd;
    }

    public Object getChangePercent24Hr() {
        return changePercent24Hr;
    }

    public void setChangePercent24Hr(Object changePercent24Hr) {
        this.changePercent24Hr = changePercent24Hr;
    }

    public Object getVwap24Hr() {
        return vwap24Hr;
    }

    public void setVwap24Hr(Object vwap24Hr) {
        this.vwap24Hr = vwap24Hr;
    }

    public String getExplorer() {
        return explorer;
    }

    public void setExplorer(String explorer) {
        this.explorer = explorer;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
