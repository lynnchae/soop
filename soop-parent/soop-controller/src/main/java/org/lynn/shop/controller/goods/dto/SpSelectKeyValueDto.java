package org.lynn.soop.controller.goods.dto;

import org.lynn.soop.entity.SalesProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright @ 2013QIANLONG.
 * All right reserved.
 * Class Name : org.lynn.soop.controller.SalesProperty.dto
 * Description :
 * Author : cailinfeng
 * Date : 2016/7/13
 */
public class SpSelectKeyValueDto {

    private String value;
    private String display_text;

    public static SpSelectKeyValueDto from(SalesProperty SalesProperty) {
        SpSelectKeyValueDto toReturn = new SpSelectKeyValueDto();
        toReturn.setValue(String.valueOf(SalesProperty.getId()));
        toReturn.setDisplay_text(SalesProperty.getSp_name());
        return toReturn;
    }

    public static List<SpSelectKeyValueDto> fromList(List<SalesProperty> SalesProperty) {
        ArrayList<SpSelectKeyValueDto> toReturn = new ArrayList<SpSelectKeyValueDto>();
        for (SalesProperty category : SalesProperty) {
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
