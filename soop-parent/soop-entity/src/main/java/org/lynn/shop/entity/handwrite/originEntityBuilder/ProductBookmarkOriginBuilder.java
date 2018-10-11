package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.ProductBookmark;
import org.lynn.soop.entity.handwrite.ProductBookmarkExtend;

public class ProductBookmarkOriginBuilder extends ProductBookmark {

    public static ProductBookmarkExtend buildOrigin(ProductBookmark origin) {
        ProductBookmarkExtend returnValue=new ProductBookmarkExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setUser_id(origin.getUser_id());
        returnValue.setProduct_id(origin.getProduct_id());
        returnValue.setProduct_name(origin.getProduct_name());
        return returnValue;
    }
}