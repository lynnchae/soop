package org.lynn.soop.service.goods;

import com.alibaba.dubbo.config.annotation.Service;
import org.lynn.soop.business.goods.GoodsBusiness;
import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.BaseQueryRequest;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.goods.GoodsServiceContract;
import org.lynn.soop.entity.Goods;
import org.lynn.soop.service.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Copyright @ 2013QIANLONG.
 * All right reserved.
 * Class Name : org.lynn.soop.service.goods
 * Description :
 * Author : cailinfeng
 * Date : 2016/7/12
 */
@Service
public class GoodsService extends BaseService implements GoodsServiceContract {

    @Autowired
    private GoodsBusiness goodsBusiness;


    @Override
    public BaseResponse<Long> updateGoods(BaseRequest req) {
        return goodsBusiness.updateGoods(req);
    }

    @Override
    public PageViewDto<Goods> listGoods(BaseQueryRequest queryCondition) {
        return goodsBusiness.listGoods(queryCondition);
    }
}
