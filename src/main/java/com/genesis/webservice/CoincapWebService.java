package com.genesis.webservice;

import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.genesis.pojo.Wallet;
import com.genesis.pojo.coincap.asset.Assets;
import com.genesis.pojo.coincap.asset.Datum;
import com.genesis.pojo.coincap.history.History;
import com.genesis.thread.ProcessCsv;
import com.genesis.utils.ConfigResourcesUtils;

public class CoincapWebService implements Runnable {

	private Wallet wallet;

	public CoincapWebService(Wallet wallet) {
		this.wallet = wallet;
	}

	private final CloseableHttpClient httpClient = HttpClients.createDefault();

	@Override
	public void run() {
		try {
			
			System.out.println("Submitted request " + wallet.getSymbol() + " at " + new Date());
			Assets assets = getAssets(wallet.getSymbol());
			for (Datum data : assets.getData()) {
				History history = getHistory(data.getId());
				if (history.getData().size() == 1) {
					ProcessCsv.process(wallet.getSymbol(), history.getData().get(0).getPriceUsd(), wallet.getQuantity(), wallet.getPrice());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	private Assets getAssets(String symbol) throws Exception {

		// return variable
		Assets ret = null;

		String u = ConfigResourcesUtils.coincapAssetUrl;
		u += "?search=" + symbol;

		HttpGet request = new HttpGet(u);
		request.addHeader("Authorization", "Bearer " + ConfigResourcesUtils.coincapToken);
		try (CloseableHttpResponse response = httpClient.execute(request)) {

			HttpEntity entity = response.getEntity();

			if (entity != null) {

				// return it as a String
				String result = EntityUtils.toString(entity);
				ObjectMapper mapper = new ObjectMapper();
				ret = mapper.readValue(result, Assets.class);

			}

		}

		return ret;

	}

	private History getHistory(String id) throws Exception {

		// return variable
		History ret = null;

		String u = ConfigResourcesUtils.coincapAssetUrl;
		u += "/" + id + "/history?interval=d1&start=1617753600000&end=1617753601000";

		HttpGet request = new HttpGet(u);
		request.addHeader("Authorization", "Bearer " + ConfigResourcesUtils.coincapToken);
		try (CloseableHttpResponse response = httpClient.execute(request)) {

			HttpEntity entity = response.getEntity();

			if (entity != null) {

				// return it as a String
				String result = EntityUtils.toString(entity);
				ObjectMapper mapper = new ObjectMapper();
				ret = mapper.readValue(result, History.class);

			}

		}

		return ret;

	}

}
