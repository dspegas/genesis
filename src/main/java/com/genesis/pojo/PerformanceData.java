package com.genesis.pojo;

public class PerformanceData {

	public PerformanceData(Float total, String bestAsset, Float bestPerformance, String worstAsset,
			Float worstPerformance) {
		super();
		this.total = total;
		this.bestAsset = bestAsset;
		this.bestPerformance = bestPerformance;
		this.worstAsset = worstAsset;
		this.worstPerformance = worstPerformance;
	}
	
	
	private Float total;
	private String bestAsset;
	private Float bestPerformance;
	private String worstAsset;
	private Float worstPerformance;
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	public String getBestAsset() {
		return bestAsset;
	}
	public void setBestAsset(String bestAsset) {
		this.bestAsset = bestAsset;
	}
	public Float getBestPerformance() {
		return bestPerformance;
	}
	public void setBestPerformance(Float bestPerformance) {
		this.bestPerformance = bestPerformance;
	}
	public String getWorstAsset() {
		return worstAsset;
	}
	public void setWorstAsset(String worstAsset) {
		this.worstAsset = worstAsset;
	}
	public Float getWorstPerformance() {
		return worstPerformance;
	}
	public void setWorstPerformance(Float worstPerformance) {
		this.worstPerformance = worstPerformance;
	}
	
	
}
