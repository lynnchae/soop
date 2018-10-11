package org.lynn.soop.contract.member.dto;

public class ProductCalResponse {
    private int totalCount; //总商品个数

    private long totalWeight;//总毛重

    private long totalProductAmount;//总共商品费用

    private long freight;//包装费用

    private String productRoutine; //商品发货线路

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public long getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(long totalWeight) {
        this.totalWeight = totalWeight;
    }

    public long getTotalProductAmount() {
        return totalProductAmount;
    }

    public void setTotalProductAmount(long totalProductAmount) {
        this.totalProductAmount = totalProductAmount;
    }

    public long getFreight() {
        return freight;
    }

    public void setFreight(long freight) {
        this.freight = freight;
    }

    public String getProductRoutine() {
        return productRoutine;
    }

    public void setProductRoutine(String productRoutine) {
        this.productRoutine = productRoutine;
    }
}
