package com.genesis.webservice;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import com.genesis.pojo.coincap.asset.Assets;
import com.genesis.pojo.coincap.history.History;

public class WebServiceTest {

	@Test
	public static void checkAsset() {

		Assets asset = new Assets();
		Method privateMethod;
		try {
			privateMethod = CoincapWebService.class.getDeclaredMethod("getAssets", String.class);
			privateMethod.setAccessible(true);
			asset = (Assets) privateMethod.invoke("BTC");
			if (asset != null) {
				assertTrue(true);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertTrue(false);
		}

	}
	
	@Test
	public static void checkHistoryt() {

		History history = new History();
		Method privateMethod;
		try {
			privateMethod = CoincapWebService.class.getDeclaredMethod("getHistory", String.class);
			privateMethod.setAccessible(true);
			history = (History) privateMethod.invoke("BitCoin");
			if (history != null) {
				assertTrue(true);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertTrue(false);
		}

	}
}
