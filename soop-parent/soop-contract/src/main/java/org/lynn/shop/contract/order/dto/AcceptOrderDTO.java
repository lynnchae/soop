package org.lynn.soop.contract.order.dto;


import org.springframework.util.CollectionUtils;

import java.util.List;

public class AcceptOrderDTO {
    private Long address_id;
    private List<ProductOrderItem> product_list;
    private int total_product_number;
    private int total_weight; //单位：磅
    private int freight; //总运费
    private int payable_amount;

    public String validate() {
        StringBuilder toReturn = new StringBuilder();
        if (address_id == null) {
            // Mark: 2017.1.12 租房项目不存在收货地址
            //toReturn.append("地址信息不能为空");
        }
        if (CollectionUtils.isEmpty(product_list)) {
            toReturn.append("商品列表不能为空");
        }
        return toReturn.toString();
    }

    public static class ProductOrderItem {
        private long product_id;
        private int product_price;
        private int number;

        public void setProduct_id(long product_id) {
            this.product_id = product_id;
        }

        public void setProduct_price(int product_price) {
            this.product_price = product_price;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public long getProduct_id() {
            return product_id;
        }

        public int getNumber() {
            return number;
        }

        public int getProduct_price() {
            return product_price;
        }
    }

    public void setAddress_id(long address_id) {
        this.address_id = address_id;
    }

    public void setProduct_list(List<ProductOrderItem> product_list) {
        this.product_list = product_list;
    }

    public void setTotal_product_number(int total_product_number) {
        this.total_product_number = total_product_number;
    }

    public void setTotal_weight(int total_weight) {
        this.total_weight = total_weight;
    }

    public void setFreight(int freight) {
        this.freight = freight;
    }

    public void setPayable_amount(int payable_amount) {
        this.payable_amount = payable_amount;
    }

    public long getAddress_id() {
        return address_id;
    }

    public List<ProductOrderItem> getProduct_list() {
        return product_list;
    }

    public int getTotal_product_number() {
        return total_product_number;
    }

    public int getTotal_weight() {
        return total_weight;
    }

    public int getFreight() {
        return freight;
    }

    public int getPayable_amount() {
        return payable_amount;
    }
}
