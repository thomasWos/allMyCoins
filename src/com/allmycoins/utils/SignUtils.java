package com.allmycoins.utils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.allmycoins.exception.AllMyCoinsException;

public final class SignUtils {

	public static String signBase64(SignatureAlgo signatureAlgorithm, String secretKey, String payload) {
		byte[] signature = sign(signatureAlgorithm, secretKey, payload);
		byte[] base64Sign = Base64.getEncoder().encode(signature);
		return new String(base64Sign);
	}

	public static String signHex(SignatureAlgo signatureAlgorithm, String secretKey, String payload) {
		byte[] signature = sign(signatureAlgorithm, secretKey, payload);
		return HexUtils.bytesToHex(signature);
	}

	private static byte[] sign(SignatureAlgo signatureAlgorithm, String secretKey, String payload) {
		try {
			String algoName = signatureAlgorithm.algoName();
			Mac hmacSha = Mac.getInstance(algoName);
			SecretKeySpec secKey = new SecretKeySpec(secretKey.getBytes(), algoName);
			hmacSha.init(secKey);
			return hmacSha.doFinal(payload.getBytes());
		} catch (NoSuchAlgorithmException | InvalidKeyException e) {
			throw new AllMyCoinsException("Error encoding signature: " + payload);
		}
	}

}
