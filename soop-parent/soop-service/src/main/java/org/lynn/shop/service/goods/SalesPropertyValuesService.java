package org.lynn.soop.service.goods;

import org.lynn.soop.business.goods.SalesPropertyValuesBusiness;
import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.goods.SalesPropertyValuesServiceContract;
import org.lynn.soop.entity.SalesPropertyValues;
import org.lynn.soop.service.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gaoguoxiang on 2016/7/13
 */
@Service
public class SalesPropertyValuesService extends BaseService implements SalesPropertyValuesServiceContract {
    @Autowired
    private SalesPropertyValuesBusiness salesPropertyValuesBusiness;

    @Override
    public BaseResponse updateSalesPropertyValues(BaseRequest request) {
        return salesPropertyValuesBusiness.updateSalesPropertyValues(request);
    }

    @Override
    public PageViewDto<SalesPropertyValues> listSalesPropertyValues(Long spId) {
        return salesPropertyValuesBusiness.listSalesPropertyValues(spId);
    }

    @Override
    public BaseResponse removeSalesPropertyValues(BaseRequest<Long> request) {
        return salesPropertyValuesBusiness.removeSalesPropertyValues(request);
    }
}
