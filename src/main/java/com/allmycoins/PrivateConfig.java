package com.allmycoins;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

import com.allmycoins.exception.AllMyCoinsException;

public final class PrivateConfig {

	private static final Properties PROP = new Properties();

	public static void clearConfiguration() {
		PROP.clear();
	}

	public static Optional<String> get(String propKey) {
		return Optional.ofNullable(PROP.getProperty(propKey)).map(String::trim);
	}

	public static void loadConfiguration() {
		try (FileInputStream fileInputStream = new FileInputStream("privateConfig.properties")) {
			PROP.load(fileInputStream);
		} catch (IOException ex) {
			throw new AllMyCoinsException(ex.getMessage());
		}
	}

	public static void loadConfigurationFromClassLoader() {
		try {
			PROP.load(PrivateConfig.class.getClassLoader().getResourceAsStream("privateConfig.properties"));
		} catch (IOException ex) {
			throw new AllMyCoinsException(ex.getMessage());
		}
	}

}
