package org.lynn.soop.business.product;

import org.lynn.soop.entity.Product;
import org.lynn.soop.entity.ProductExample;
import org.lynn.soop.repository.persistence.mybatis.handwrite.read.*;
import org.lynn.soop.repository.persistence.mybatis.handwrite.write.*;
import org.lynn.soop.util.DataHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by chenwen on 4/23/16.
 */
@Component
public class ProductTrxBusiness {

    @Autowired
    OrderProductListReadMapper productBrandReadMapper;
    @Autowired
    OrderProductListWriteMapper productBrandWriteMapper;

    @Autowired
    PurchaseProductBatchReadMapper purchaseProductBatchReadMapper;
    @Autowired
    PurchaseProductBatchWriteMapper purchaseProductBatchWriteMapper;

    @Autowired
    PurchaseProductRequestReadMapper purchaseProductRequestReadMapper;
    @Autowired
    PurchaseProductRequestWriteMapper purchaseProductRequestWriteMapper;

    @Autowired
    PurchaseProductResultReadMapper purchaseProductResultReadMapper;
    @Autowired
    PurchaseProductResultWriteMapper purchaseProductResultWriteMapper;

    @Autowired
    ProductReadMapper productReadMapper;

    @Autowired
    ProductWriteMapper productWriteMapper;

    public void updateSalePrice(BigDecimal profileRate) {
        ProductExample productExample = new ProductExample();
        List<Product> products = productReadMapper.selectByExample(productExample);
        for (Product product : products) {
            product.setPrice_on_sale(DataHelper.multiple(product.getProduct_price(), profileRate));
            productWriteMapper.updateByPrimaryKeySelective(product);
        }

    }

}
