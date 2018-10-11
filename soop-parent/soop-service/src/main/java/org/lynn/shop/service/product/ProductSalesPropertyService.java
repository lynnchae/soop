package org.lynn.soop.service.product;

import org.lynn.soop.business.product.ProductSalesPropertyBusiness;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.product.ProductSalesPropertyServiceContact;
import org.lynn.soop.entity.dto.ProductSalesPropertyAndValuesDto;
import org.lynn.soop.service.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gaoguoxiang on 2016/7/14
 */
@Service
public class ProductSalesPropertyService extends BaseService implements ProductSalesPropertyServiceContact {
    @Autowired
    private ProductSalesPropertyBusiness productSalesPropertyBusiness;
   /* @Override
    public BaseResponse<Long> updateProductSalesProperty() {
        return null;
    }*/

    @Override
    public PageViewDto<ProductSalesPropertyAndValuesDto> listProductSalesProperty(Long productId) {
        return productSalesPropertyBusiness.listProductSalesProperty(productId);
    }
}
