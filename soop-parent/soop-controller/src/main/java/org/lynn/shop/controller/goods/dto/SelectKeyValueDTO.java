package org.lynn.soop.controller.goods.dto;

import org.lynn.soop.entity.Goods;

import java.util.ArrayList;
import java.util.List;

public class SelectKeyValueDTO {
    private String value;
    private String display_text;

    public static SelectKeyValueDTO from(Goods Goods) {
        SelectKeyValueDTO toReturn = new SelectKeyValueDTO();
        toReturn.setValue(String.valueOf(Goods.getId()));
        toReturn.setDisplay_text(Goods.getName());
        return toReturn;
    }

    public static List<SelectKeyValueDTO> fromList(List<Goods> Goods) {
        ArrayList<SelectKeyValueDTO> toReturn = new ArrayList<SelectKeyValueDTO>();
        for (Goods category : Goods) {
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

//    public static List<SelectKeyValueDTO> fromBrandList(List<ProductBrand> dataList) {
//        ArrayList<SelectKeyValueDTO> toReturn = new ArrayList<SelectKeyValueDTO>();
//        for (ProductBrand category : dataList) {
//            SelectKeyValueDTO dto = new SelectKeyValueDTO();
//            dto.value = String.valueOf(category.getId());
//            dto.display_text = category.getBrand_name_cn();
//            toReturn.add(dto);
//        }
//        return toReturn;
//    }
}
