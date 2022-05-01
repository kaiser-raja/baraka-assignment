package com.baraka.assignment.utils;

import java.security.SecureRandom;
import java.util.Base64;

public class CommonUtils {

    private static final SecureRandom secureRandom = new SecureRandom();

    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

    private CommonUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static String generateAccountNumber() {
        final byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }
}
