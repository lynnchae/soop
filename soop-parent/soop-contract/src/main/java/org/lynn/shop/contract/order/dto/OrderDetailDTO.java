package org.lynn.soop.contract.order.dto;



import org.lynn.soop.contract.product.dto.ProductDto;
import org.lynn.soop.entity.Order;
import org.lynn.soop.entity.OrderDeliverRoutine;
import org.lynn.soop.entity.OrderDelivery;

import java.util.List;

public class OrderDetailDTO {
    private Order order;
    private List<ProductDto> productDtoList;
    private OrderDelivery orderDelivery;
    private OrderDeliverRoutine orderDeliverRoutine;

    public OrderDeliverRoutine getOrderDeliverRoutine() {
        return orderDeliverRoutine;
    }

    public void setOrderDeliverRoutine(OrderDeliverRoutine orderDeliverRoutine) {
        this.orderDeliverRoutine = orderDeliverRoutine;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<ProductDto> getProductDtoList() {
        return productDtoList;
    }

    public void setProductDtoList(List<ProductDto> productDtoList) {
        this.productDtoList = productDtoList;
    }

    public OrderDelivery getOrderDelivery() {
        return orderDelivery;
    }

    public void setOrderDelivery(OrderDelivery orderDelivery) {
        this.orderDelivery = orderDelivery;
    }
}
