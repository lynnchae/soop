package org.lynn.soop.contract.member.dto;

import java.util.HashMap;
import java.util.Map;

public class ProductCalRequest {
    //key = productId, value = quantity
    private Map<Long, Integer> productList;

    public ProductCalRequest() {
        this.productList = new HashMap<Long, Integer>();
    }

    public Map<Long, Integer> getProductList() {
        return productList;
    }
}
