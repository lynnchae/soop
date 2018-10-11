package org.lynn.soop.entity.dto;

import org.lynn.soop.entity.Product;


/**
 * Created by gaoguoxiang on 2016/7/14
 */
public class ProductDto extends Product {
    private String properties;

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }
}
