package org.lynn.soop.contract.stock.dto;

import org.lynn.soop.entity.Product;

import java.util.List;

public class PurchaseRequestListDTO {
    private Long batchId;
    private List<PurchaseDetailItem> detailItemList;

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public List<PurchaseDetailItem> getDetailItemList() {
        return detailItemList;
    }

    public void setDetailItemList(List<PurchaseDetailItem> detailItemList) {
        this.detailItemList = detailItemList;
    }

    public static class PurchaseDetailItem {
        private Product product;
        private int number;

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }
}
