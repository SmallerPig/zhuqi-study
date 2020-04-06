package com.chinamobile.iot;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * mqtt密码加密处理
 *
 * @author
 */
public class SecurityUtil {
    private final MessageDigest messageDigest;
    private final SecureRandom random = new SecureRandom();
    private final byte[] secret;
    private final int iterations;
    private final int saltKeyLength;
    private static final int DEFAULT_ITERATIONS = 1024;
    private static final int DEFAULT_SALT_KEY_LENGTH = 8;
    private static final String DEFAULT_ALGORITHM = "SHA-256";
    private static final String DEFAULT_SECRET = "minivision";

    public SecurityUtil(String algorithm, String secret) {
        this.messageDigest = createDigest(algorithm);
        this.secret = Utf8.encode(secret);
        this.iterations = 1024;
        this.saltKeyLength = DEFAULT_SALT_KEY_LENGTH;
    }

    public SecurityUtil(String secret) {
        this(DEFAULT_ALGORITHM, secret);
    }

    public SecurityUtil() {
        this(DEFAULT_ALGORITHM, DEFAULT_SECRET);
    }

    private static MessageDigest createDigest(String algorithm) {
        try {
            return MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No such hashing algorithm", e);
        }
    }

    /**
     * 加密密码
     *
     * @param rawPassword
     * @return
     */
    public String encode(CharSequence rawPassword) {
        byte[] digest = digest(rawPassword, generateSalt());
        return new String(Hex.encode(digest));
    }

    private byte[] digest(CharSequence rawPassword, byte[] salt) {
        byte[] digest = digest(concatenate(salt, secret, Utf8.encode(rawPassword)));
        System.out.println(new String(Hex.encode(digest)));
        System.out.println(new String(Hex.encode(salt)));
        return concatenate(salt, digest);
    }

    private byte[] generateSalt() {
        byte[] bytes = "asdddasd".getBytes();

//        random.nextBytes(bytes);
        return bytes;
    }

    public byte[] digest(byte[] value) {
        for (int i = 0; i < 1024; i++) {
            value = messageDigest.digest(value);
            System.out.println(new String(Hex.encode(value)));
        }
        return value;
    }

    private byte[] concatenate(byte[]... arrays) {
        int length = 0;
        for (byte[] array : arrays) {
            length += array.length;
        }
        byte[] newArray = new byte[length];
        int destPos = 0;
        for (byte[] array : arrays) {
            System.arraycopy(array, 0, newArray, destPos, array.length);
            destPos += array.length;
        }
        return newArray;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        CharSequence charSequence = "pad::18088037200019";
        SecurityUtil securityUtil = new SecurityUtil();
//        String sn = "b860773139d8b7bdb0c8d1e9541342df25d579fe647e05b55ccf305b5076f110";
//        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
//        System.out.println(new String(Hex.encode(messageDigest.digest(Utf8.encode(sn)))));
        String encode = securityUtil.encode(charSequence);
        System.out.println(encode);
    }

}
