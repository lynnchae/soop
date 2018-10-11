package org.lynn.soop.contract.product.dto;


import org.lynn.soop.contract.dto.NamableDto;
import org.lynn.soop.entity.ProductAttribute;

import javax.validation.constraints.NotNull;

/**
 * Created by chenwen on 4/22/16.
 */
public class ProductAttributeDto extends NamableDto {

    @NotNull
    private Long productCategoryId;
    @NotNull
    private String value;
    @NotNull
    private String valueType;


    public static ProductAttribute fromDto(ProductAttributeDto dto) {
        ProductAttribute po = new ProductAttribute();
        po.setId(dto.getId());
        po.setAttr_name(dto.getNameCN());
        po.setAttr_value(dto.getValue());
        po.setAttr_type(dto.getValueType());
        po.setProduct_category_id(dto.getProductCategoryId());
        return po;
    }

    public static ProductAttributeDto toDto(ProductAttribute po) {
        ProductAttributeDto dto = new ProductAttributeDto();
        dto.setId(po.getId());
        dto.setNameCN(po.getAttr_name());
        dto.setValue(po.getAttr_value());
        dto.setValueType(po.getAttr_type());
        dto.setProductCategoryId(po.getProduct_category_id());
        return dto;
    }


    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }
}
