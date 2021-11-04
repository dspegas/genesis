package com.genesis;

import com.genesis.thread.ProcessCsv;
import com.genesis.thread.ThreadPool;
import com.genesis.utils.ConfigResourcesUtils;

public class App {

	public static void main(String[] args) throws Exception {
		
		// read config properties
		ConfigResourcesUtils config = new ConfigResourcesUtils();
		
		// Start
		ThreadPool t = new ThreadPool();
		t.start();
		
		// Show result
		System.out.println(ProcessCsv.getProcessed());

	}

}
