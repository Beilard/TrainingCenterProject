package com.study.epamproject.service.encoder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncoder {
    private static final Logger LOGGER = LogManager.getLogger(PasswordEncoder.class);

    public String encode(String pass){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] passBytes = pass.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuffer sb = new StringBuffer();

            for (byte b : digested) {
                sb.append(Integer.toHexString(0xff & b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            LOGGER.error("Encode process exception", ex);
            throw new RuntimeException(ex);
        }
    }
}
