package org.lynn.soop.contract.goods.dto;

import org.lynn.soop.contract.dto.BaseQueryRequest;

public class GoodsQueryRequest extends BaseQueryRequest {


    private Long goodsId;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
}
