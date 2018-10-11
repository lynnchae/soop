package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.VerificationCode;
import org.lynn.soop.entity.handwrite.originEntityBuilder.VerificationCodeOriginBuilder;

public class VerificationCodeExtend extends VerificationCode {

    public static VerificationCodeExtend generateFromOriginEntity(VerificationCode origin) {
        return VerificationCodeOriginBuilder.buildOrigin(origin);
    }

    public enum Type {
        IMAGE(4, 180),
        SMS(6, 240);
        private final int length;
        private final int expiredTimeInSecond;

        Type(int length, int expiredTimeInSecond) {
            this.length = length;
            this.expiredTimeInSecond = expiredTimeInSecond;
        }

        public int getLength() {
            return length;
        }

        public int getExpiredTimeInSecond() {
            return expiredTimeInSecond;
        }
    }
}