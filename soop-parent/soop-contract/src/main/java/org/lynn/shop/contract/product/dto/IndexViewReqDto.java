package org.lynn.soop.contract.product.dto;


import org.lynn.soop.contract.BaseDto;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenwen on 5/03/16.
 */
public class IndexViewReqDto extends BaseDto {

    private Map<String, Integer> attributes;
    private Map<String, Integer> classses;
    private int limit;
    private Map<String, String> categoryNameIdMap;

    public IndexViewReqDto() {
        this.classses = new HashMap<String, Integer>();
    }


    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Map<String, String> getCategoryNameIdMap() {
        return categoryNameIdMap;
    }

    public void setCategoryNameIdMap(Map<String, String> categoryNameIdMap) {
        this.categoryNameIdMap = categoryNameIdMap;
    }

    public Map<String, Integer> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Integer> attributes) {
        this.attributes = attributes;
    }

    public Map<String, Integer> getClassses() {
        return classses;
    }

    public void setClassses(Map<String, Integer> classses) {
        this.classses = classses;
    }

}
