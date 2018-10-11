package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.ProductPrice;
import org.lynn.soop.entity.handwrite.ProductPriceExtend;

public class ProductPriceOriginBuilder extends ProductPrice {

    public static ProductPriceExtend buildOrigin(ProductPrice origin) {
        ProductPriceExtend returnValue=new ProductPriceExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setProduct_id(origin.getProduct_id());
        returnValue.setProduct_name_cn(origin.getProduct_name_cn());
        returnValue.setSource(origin.getSource());
        returnValue.setOverseas_price(origin.getOverseas_price());
        returnValue.setDomestic_price(origin.getDomestic_price());
        returnValue.setProduct_price(origin.getProduct_price());
        returnValue.setSource_id(origin.getSource_id());
        returnValue.setPrice_on_sale(origin.getPrice_on_sale());
        return returnValue;
    }
}