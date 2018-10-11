package org.lynn.soop.entity.dto;

import org.lynn.soop.entity.ProductSalesProperty;

/**
 * Created by gaoguoxiang on 2016/7/14
 */
public class ProductSalesPropertyAndValuesDto extends ProductSalesProperty {

    private Long sp_id;

    private String sp_value;

    public Long getSp_id() {
        return sp_id;
    }

    public void setSp_id(Long sp_id) {
        this.sp_id = sp_id;
    }

    @Override
    public String getSp_value() {
        return sp_value;
    }

    @Override
    public void setSp_value(String sp_value) {
        this.sp_value = sp_value;
    }
}
