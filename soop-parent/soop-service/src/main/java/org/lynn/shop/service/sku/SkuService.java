package org.lynn.soop.service.sku;

import com.alibaba.dubbo.config.annotation.Service;
import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.sku.SkuServiceContact;

@Service
public class SkuService implements SkuServiceContact {
    public BaseResponse test(BaseRequest abc) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(200);
        baseResponse.setMessage("success");
        return baseResponse;
    }
}
