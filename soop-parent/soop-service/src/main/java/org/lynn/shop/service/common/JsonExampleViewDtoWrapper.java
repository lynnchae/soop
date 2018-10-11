package org.lynn.soop.service.common;

import org.lynn.soop.contract.BaseDto;
import org.lynn.soop.contract.dto.ExampleViewDto;
import org.lynn.soop.util.JsonHelper;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by chenwen on 4/24/16.
 */
public class JsonExampleViewDtoWrapper {

    private ExampleViewDto original;
    private Class<? extends BaseDto> dataType;

    public JsonExampleViewDtoWrapper(ExampleViewDto original, Class<? extends BaseDto> dataType) {
        this.original = original;
        this.dataType = dataType;
    }


    public BaseDto getExampleFromJson() {
        if (StringUtils.isBlank(original.getExampleDto())) {
            return null;
        }
        return JsonHelper.fromJSON(original.getExampleDto(), dataType);
    }

}
