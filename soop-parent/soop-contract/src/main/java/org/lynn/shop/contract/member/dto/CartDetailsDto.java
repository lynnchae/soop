package org.lynn.soop.contract.member.dto;

import org.lynn.soop.contract.BaseDto;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * Created by chenwen on 5/08/16.
 */
public class CartDetailsDto extends BaseDto {

    private List<UsersooppingCartDto> goodsList;

    @JsonProperty("sum")
    private int totalCount;

    @JsonProperty("totalWeight")
    private long totalWeight;

    @JsonProperty("amountPaid")
    private long totalAmountPaid;

    @JsonProperty("preferential")
    private long totalPreferential;

    @JsonProperty("freight")
    private long totalFreight;

    @JsonProperty("transitLine")
    private String transitLine;


    public void evalTotalInfo(long totalAmountPaid) {
        this.totalAmountPaid = totalAmountPaid;
        long totalAmount = 0;
        if (goodsList != null) {
            for (UsersooppingCartDto d : goodsList) {
                totalCount += d.getQuantity();
                totalWeight += d.getProductWeight();
                totalAmount += d.getProductPrice();
            }
            this.totalPreferential = totalAmount - totalAmountPaid;
        }
    }

    public List<UsersooppingCartDto> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<UsersooppingCartDto> goodsList) {
        this.goodsList = goodsList;
    }

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

    public long getTotalAmountPaid() {
        return totalAmountPaid;
    }

    public void setTotalAmountPaid(long totalAmountPaid) {
        this.totalAmountPaid = totalAmountPaid;
    }

    public long getTotalPreferential() {
        return totalPreferential;
    }

    public void setTotalPreferential(long totalPreferential) {
        this.totalPreferential = totalPreferential;
    }

    public long getTotalFreight() {
        return totalFreight;
    }

    public void setTotalFreight(long totalFreight) {
        this.totalFreight = totalFreight;
    }

    public String getTransitLine() {
        return transitLine;
    }

    public void setTransitLine(String transitLine) {
        this.transitLine = transitLine;
    }
}
