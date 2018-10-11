package org.lynn.soop.service.common;

import org.lynn.soop.contract.BaseDto;
import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.util.JsonHelper;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by chenwen on 4/23/16.
 */
public class JsonDataRequestWrapper {

    private BaseRequest original;
    private Class<? extends BaseDto> dataType;

    public JsonDataRequestWrapper(BaseRequest original, Class<? extends BaseDto> dataType) {
        this.original = original;
        this.dataType = dataType;
    }


    public BaseDto getDataFromJson() {
        if (StringUtils.isBlank(original.getDto())) {
            return null;
        }
        return JsonHelper.fromJSON(original.getDto(), dataType);
    }

    public BaseRequest getOriginal() {
        return original;
    }

    public Class<? extends BaseDto> getDataType() {
        return dataType;
    }
}
