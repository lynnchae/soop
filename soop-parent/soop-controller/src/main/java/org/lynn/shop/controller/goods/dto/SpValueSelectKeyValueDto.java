package org.lynn.soop.controller.goods.dto;


import org.lynn.soop.entity.SalesPropertyValues;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright @ 2013QIANLONG.
 * All right reserved.
 * Class Name : org.lynn.soop.controller.SalesPropertyValues.dto
 * Description :
 * Author : cailinfeng
 * Date : 2016/7/13
 */
public class SpValueSelectKeyValueDto {

    private String value;
    private String display_text;

    public static SpValueSelectKeyValueDto from(SalesPropertyValues SalesPropertyValues) {
        SpValueSelectKeyValueDto toReturn = new SpValueSelectKeyValueDto();
        toReturn.setValue(String.valueOf(SalesPropertyValues.getId()));
        toReturn.setDisplay_text(SalesPropertyValues.getSp_value());
        return toReturn;
    }

    public static List<SpValueSelectKeyValueDto> fromList(List<SalesPropertyValues> SalesPropertyValues) {
        ArrayList<SpValueSelectKeyValueDto> toReturn = new ArrayList<SpValueSelectKeyValueDto>();
        for (SalesPropertyValues category : SalesPropertyValues) {
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

//    public static List<SpSelectKeyValueDto> fromBrandList(List<ProductBrand> dataList) {
//        ArrayList<SpSelectKeyValueDto> toReturn = new ArrayList<SpSelectKeyValueDto>();
//        for (ProductBrand category : dataList) {
//            SpSelectKeyValueDto dto = new SpSelectKeyValueDto();
//            dto.value = String.valueOf(category.getId());
//            dto.display_text = category.getBrand_name_cn();
//            toReturn.add(dto);
//        }
//        return toReturn;
//    }
    
}
