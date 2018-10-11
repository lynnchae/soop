package org.lynn.soop.service.goods;

import org.lynn.soop.business.goods.SalesPropertyBusiness;
import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.goods.SalesPropertyServiceContract;
import org.lynn.soop.entity.SalesProperty;
import org.lynn.soop.service.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gaoguoxiang on 2016/7/13
 */
@Service
public class SalesPropertyService extends BaseService implements SalesPropertyServiceContract {

    @Autowired
    private SalesPropertyBusiness salesPropertyBusiness;

    @Override
    public BaseResponse<Long> updateSalesProperty(BaseRequest req) {
        return salesPropertyBusiness.updateSalesProperty(req);
    }

    @Override
    public PageViewDto<SalesProperty> listSalesProperty(Long goodsId) {
        return salesPropertyBusiness.listSalesProperty(goodsId);
    }

    @Override
    public BaseResponse removeSalesProperty(BaseRequest<Long> request) {
        return salesPropertyBusiness.removeSalesProperty(request);
    }
}
