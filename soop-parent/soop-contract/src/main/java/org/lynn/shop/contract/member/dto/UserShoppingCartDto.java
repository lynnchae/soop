package org.lynn.soop.contract.member.dto;

import org.lynn.soop.contract.product.dto.ProductDto;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by chenwen on 5/08/16.
 */
public class UsersooppingCartDto extends ProductDto {

    @JsonProperty("number")
    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
