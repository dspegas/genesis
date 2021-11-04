package com.genesis.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.genesis.pojo.Wallet;

public class FileResourcesUtils {

	public List<Wallet> getFileFromResource(String fileName) throws Exception {

		List<Wallet> csvRead = new ArrayList<Wallet>();

		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		InputStream is = classLoader.getResourceAsStream(fileName);

		Scanner scanner = null;
		try {

			// Variable to indicate csv file header
			boolean header = true;

			scanner = new Scanner(is);
			while (scanner.hasNextLine()) {

				if (header) {
					scanner.nextLine();
					header = false;
				} else {
					String[] line = scanner.nextLine().split(",");
					Wallet walletLine = new Wallet();
					walletLine.setSymbol(line[0]);
					walletLine.setQuantity(Float.valueOf(line[1]));
					walletLine.setPrice(Float.valueOf(line[2]));
					csvRead.add(walletLine);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (scanner != null) {
			scanner.close();
		}

		return csvRead;

	}
}
