package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.ProductBookmark;
import org.lynn.soop.entity.handwrite.originEntityBuilder.ProductBookmarkOriginBuilder;

public class ProductBookmarkExtend extends ProductBookmark {

    public static ProductBookmarkExtend generateFromOriginEntity(ProductBookmark origin) {
        return ProductBookmarkOriginBuilder.buildOrigin(origin);
    }
}