package com.allmycoins;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

import com.allmycoins.exception.AllMyCoinsException;

public final class PrivateConfig {

	private static final Properties PROP = new Properties();

	public static Optional<String> get(String propKey) {
		return Optional.ofNullable(PROP.getProperty(propKey));
	}

	public static void loadConfiguration() {
		try {
			PROP.load(new FileInputStream("privateConfig.properties"));
		} catch (IOException ex) {
			throw new AllMyCoinsException(ex.getMessage());
		}
	}

}
