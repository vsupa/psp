package com.vsupa.security;

import com.vsupa.core.ShortCodeGenerator;

/**
 * 密码加密器
 * @author Maxwell.Lee
 * @date 2018-02-05 17:27
 * @since   1.0.0
 */
public class PasswordDigester {

    private ShortCodeGenerator  saltGenerator;

    public PasswordDigester(int saltLength, String saltChars) {
        this.saltGenerator = new ShortCodeGenerator(saltLength, saltChars);
    }

    public DigestedPassword digest(String password) {
        if(password == null) return null;

        String salt = saltGenerator.next();
        String digest = DigestUtil.md5(password, salt);

        return new DigestedPassword(digest, salt);
    }

    /**
     * 判断密码是否相等；
     * @param passwordDigest        加密后的密码，（必要）；
     * @param password              测试的密码，（必要）；
     * @param salt                  加密盐值，（可选）；
     * @return  如果两个密码逻辑上相等，返回true；
     */
    public boolean isPasswordEquals(String passwordDigest, String password, String salt) {
        if (passwordDigest == null || password == null) return false;

        if (salt == null || salt.length() == 0) {
            return passwordDigest.equals(password);
        }

        String digest = DigestUtil.md5(password, salt);

        return (digest.equals(passwordDigest));
    }

}
