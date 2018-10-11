package org.lynn.soop.contract;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

/**
 * Created by chenwen on 4/23/16.
 */
public class BaseDto implements Serializable, Cloneable {

    /** PK */
    private Long id;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    @Override
    public BaseDto clone() {
        try {
            return (BaseDto) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalArgumentException(e);
        }
    }


    /**
     * 检查参数
     * @return 非法的[参数名,原因描述]
     */
    public Map<String, String> checkArgs() {
        // todo 引入校验框架
        return Collections.emptyMap();
    }

    /**
     * 根据使用场景检查参数
     * @param useCaseList 使用场景集
     * @see #checkArgs()
     */
    public Map<String, String> checkArgs(String... useCaseList) {
        // todo 参数定制检查
        return Collections.emptyMap();
    }

    public enum BasicUseCase {
        C, R, U, D, TRX
    }

}
