package org.lynn.soop.contract.product.dto;

import org.lynn.soop.entity.ProductCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright @ 2013QIANLONG.
 * All right reserved.
 * Class Name : org.lynn.soop.controller.product.dto
 * Description :
 * Author : cailinfeng
 * Date : 2016/7/25
 */
public class MainCategoryDto {

    private String id;

    private String category_name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public static List<MainCategoryDto> fromList(List<ProductCategory> productCategory) {
        ArrayList<MainCategoryDto> toReturn = new ArrayList<MainCategoryDto>();
        for (ProductCategory category : productCategory) {
            toReturn.add(from(category));
        }
        return toReturn;
    }

    public static MainCategoryDto from(ProductCategory productCategory) {
        MainCategoryDto toReturn = new MainCategoryDto();
        toReturn.setId(String.valueOf(productCategory.getId()));
        toReturn.setCategory_name(productCategory.getCategory_name());
        return toReturn;
    }
}
