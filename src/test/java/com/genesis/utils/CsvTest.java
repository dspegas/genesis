package com.genesis.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CsvTest {

	static List<String> lines = new ArrayList<String>();

	@BeforeAll
	public static void init() {
		try {
			Scanner scanner = new Scanner(new File("/src/test/resources/wallet.csv"));
			while (scanner.hasNextLine()) {
				lines.add(scanner.nextLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public static void checkSize() {
		if (lines.size() == 3) {
			assertTrue(true);

		} else {
			assertTrue(false);
		}

	}
	
	@Test
	public static void checkHeader() {
		if (lines.get(0).equals("symbol,quantity,price")) {
			assertTrue(true);

		} else {
			assertTrue(false);
		}

	}
	
	
	

}
