package com.genesis.thread;

import com.genesis.pojo.PerformanceData;

public class ProcessCsv {

	static PerformanceData performanceData = new PerformanceData(0f, "", 0f, "", 0f);

	public static void process(String symbol, String price, float quantity, float actualPrice) {

		Float total = Float.valueOf(price) * quantity ;
		Float increase = actualPrice / total ;

		performanceData.setTotal(performanceData.getTotal() + total );
		
		if (performanceData.getBestPerformance() < increase) {
			performanceData.setBestPerformance(increase);
			performanceData.setBestAsset(symbol);
		}
		
		if (performanceData.getWorstPerformance() > increase * -1) {
			performanceData.setWorstPerformance(increase);
			performanceData.setWorstAsset(symbol);
		}


	}

	public static String getProcessed() {
		return "total="+performanceData.getTotal()+",best_asset="+performanceData.getBestAsset()+",best_performance="+performanceData.getBestPerformance()+",worst_asset="+performanceData.getWorstAsset()+",worst_performance="+performanceData.getWorstPerformance() ;
	}

}
