package org.lynn.soop.contract.product.dto;

import org.lynn.soop.contract.dto.BaseQueryRequest;

public class CategoryQueryRequest extends BaseQueryRequest {
    private Long mainCategoryId;

    public Long getMainCategoryId() {
        return mainCategoryId;
    }

    public void setMainCategoryId(Long mainCategoryId) {
        this.mainCategoryId = mainCategoryId;
    }
}
