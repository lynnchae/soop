package org.lynn.soop.util;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.dao.DuplicateKeyException;

/**
 * Created by chenwen on 4/23/16.
 */
public abstract class ExceptionUtil {

    public static Throwable getRootCause(Throwable e) {
        Throwable t = ExceptionUtils.getRootCause(e);
        return t == null ? e : t;
    }

    public static boolean isConflictUK(Throwable e) {
        if (e instanceof DuplicateKeyException) {
            return true;
        }
        return ExceptionUtils.indexOfType(e, DuplicateKeyException.class) > 0;
    }

}
