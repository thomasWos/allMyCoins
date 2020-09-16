package com.allmycoins.utils;

import java.io.File;
import java.io.IOException;

import com.allmycoins.exception.AllMyCoinsException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JacksonUtils {

	/**
	 * Json File to Java, de-serialize.
	 */
	public static final <T> T deserialize(File file, Class<T> valueType) {
		try {
			return new ObjectMapper().readValue(file, valueType);
		} catch (IOException e) {
			throw new AllMyCoinsException("Error deserializing: " + file);
		}
	}

	/**
	 * Json String to Java, de-serialize.
	 */
	public static final <T> T deserialize(String content, Class<T> valueType) {
		try {
			return new ObjectMapper().readValue(content, valueType);
		} catch (JsonProcessingException e) {
			throw new AllMyCoinsException("Error deserializing: " + content);
		}
	}

	/**
	 * Java to Json file.
	 */
	public static final void serializeToFileJson(Object value, File file) {
		try {
			new ObjectMapper().writeValue(file, value);
		} catch (IOException e) {
			throw new AllMyCoinsException("Error serializing json to file: " + value);
		}
	}

	/**
	 * Java to Json String.
	 */
	public static final String serializeToJson(Object value) {
		try {
			return new ObjectMapper().writeValueAsString(value);
		} catch (JsonProcessingException e) {
			throw new AllMyCoinsException("Error serializing to json: " + value);
		}
	}
}
