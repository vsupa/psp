package com.vsupa.security;

/**
 * @author Maxwell.Lee
 * @date 2018-02-05 17:27
 * @since   1.0.0
 */
public class DigestedPassword {

    private String  digest;

    private String  salt;

    public DigestedPassword(String digest, String salt) {
        this.digest = digest;
        this.salt = salt;
    }

    public String getDigest() {
        return digest;
    }

    public String getSalt() {
        return salt;
    }

    @Override
    public String toString() {
        return "DigestedPassword{" +
                "digest='" + digest + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}
