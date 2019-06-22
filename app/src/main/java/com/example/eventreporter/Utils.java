package com.example.eventreporter;

import org.apache.commons.codec.binary.Hex;

import java.nio.charset.Charset;
import java.security.MessageDigest;

import static org.apache.commons.codec.binary.Hex.encodeHex;

public class Utils {

    public static String md5Encryption(final String input) {
        String result = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(input.getBytes(Charset.forName("UTF8")));
            byte[] resultByte = messageDigest.digest();
            result = new String(encodeHex(resultByte));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
