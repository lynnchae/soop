package org.lynn.soop.contract.product.dto;


import org.lynn.soop.contract.BaseDto;

import java.util.List;
import java.util.Map;

/**
 * Created by chenwen on 5/03/16.
 */
public class IndexViewRespDto extends BaseDto {

    private Map<String, List<ProductDto>> attributes;
    private Map<String, List<ProductDto>> classses;


    public Map<String, List<ProductDto>> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, List<ProductDto>> attributes) {
        this.attributes = attributes;
    }

    public Map<String, List<ProductDto>> getClassses() {
        return classses;
    }

    public void setClassses(Map<String, List<ProductDto>> classses) {
        this.classses = classses;
    }
}
