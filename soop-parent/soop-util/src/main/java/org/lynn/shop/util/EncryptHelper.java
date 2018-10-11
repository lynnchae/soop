package org.lynn.soop.util;

import org.apache.commons.codec.binary.Base64;

/**
 * 加密
 */
public final class EncryptHelper {
    /**
     * 密码单向加密
     *
     * @param pasword 明文密码
     * @return 密文密码
     */
    public static String oneWayEncryptPassword(String pasword) {
        //todo: use more complex encrypt method
        return Base64.encodeBase64String(pasword.getBytes(Contants.UTF8));
    }
}
