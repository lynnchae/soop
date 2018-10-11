package org.lynn.soop.contract.product.dto;


import org.lynn.soop.contract.BaseDto;

import java.util.Map;

/**
 * Created by chenwen on 5/03/16.
 */
public class IndexHomeReqDto extends BaseDto {

    private int limit;
    private Map<String, String> categoryNameIdMap;


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

}
