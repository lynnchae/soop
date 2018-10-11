package org.lynn.soop.business.pay;

import org.apache.commons.codec.binary.Hex;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class DigestUtil {

    public static enum Algorithm {
        MD5("MD5"),
        SHA1("SHA-1");

        private String alg;

        Algorithm(String alg) {
            this.alg = alg;
        }

        public String getAlg() {
            return alg;
        }
    }

    public static byte[] digest(byte[] bytes, Algorithm alg) {
        try {
            return MessageDigest.getInstance(alg.getAlg()).digest(bytes);
        } catch (NoSuchAlgorithmException e) {
            //shit happens
            throw new RuntimeException(String.format("shit happens. %s", e), e);
        }
    }

    private static String digestToHex(byte[] bytes,Algorithm alg) {
        return Hex.encodeHexString(digest(bytes, alg));
    }

    public static String digestToHex(String origin, String charset) {
        return digestToHex(origin.getBytes(Charset.forName(charset)), Algorithm.MD5);
    }
}