package org.lynn.soop.controller.product.dto;

import org.lynn.soop.entity.ProductBrand;
import org.lynn.soop.entity.ProductCategory;

import java.util.ArrayList;
import java.util.List;

public class SelectKeyValueDTO {
    private String value;
    private String display_text;

    public static SelectKeyValueDTO from(ProductCategory productCategory) {
        SelectKeyValueDTO toReturn = new SelectKeyValueDTO();
        toReturn.setValue(String.valueOf(productCategory.getId()));
        toReturn.setDisplay_text(productCategory.getCategory_name());
        return toReturn;
    }

    public static List<SelectKeyValueDTO> fromList(List<ProductCategory> productCategory) {
        ArrayList<SelectKeyValueDTO> toReturn = new ArrayList<SelectKeyValueDTO>();
        for (ProductCategory category : productCategory) {
            toReturn.add(from(category));
        }
        return toReturn;
    }


    public void setValue(String value) {
        this.value = value;
    }

    public void setDisplay_text(String display_text) {
        this.display_text = display_text;
    }

    public String getValue() {
        return value;
    }

    public String getDisplay_text() {
        return display_text;
    }

    public static List<SelectKeyValueDTO> fromBrandList(List<ProductBrand> dataList) {
        ArrayList<SelectKeyValueDTO> toReturn = new ArrayList<SelectKeyValueDTO>();
        for (ProductBrand category : dataList) {
            SelectKeyValueDTO dto = new SelectKeyValueDTO();
            dto.value = String.valueOf(category.getId());
            dto.display_text = category.getBrand_name_cn();
            toReturn.add(dto);
        }
        return toReturn;
    }
}
