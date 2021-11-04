package com.genesis.thread;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.genesis.pojo.Wallet;
import com.genesis.utils.FileResourcesUtils;
import com.genesis.webservice.CoincapWebService;

public class ThreadPool {

	public void start() throws Exception {
		
		FileResourcesUtils csvUtil = new FileResourcesUtils();
		List<Wallet> wallets = csvUtil.getFileFromResource("wallet.csv");
		
		System.out.println("Now is " + new Date());

		// creating a pool of 3 threads
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
		for (Wallet wallet : wallets) {
			
			// Verify if pool have free threads
			boolean showLog = true;
			while (executor.getActiveCount() == 3) {
				if (showLog) {
					System.out.println("(program hangs, waiting for some of the previous requests to finish)");
					showLog = false;
				}
			}
			
			System.out.println("Submitted request " + wallet.getSymbol() + " at " + new Date());
			
			Runnable worker = new CoincapWebService(wallet);
			executor.execute(worker);// calling execute method of ExecutorService
		}

		// No more threads can be submitted to the executor service!
		executor.shutdown();

		// Blocks until all submitted threads have finished!
		executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES);

		System.out.println("Finished all threads");
	}
}
