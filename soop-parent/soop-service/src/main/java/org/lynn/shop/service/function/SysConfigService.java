package org.lynn.soop.service.function;

import com.alibaba.dubbo.config.annotation.Service;
import org.lynn.soop.business.common.SysConfigBusiness;
import org.lynn.soop.contract.BaseAPIRequest;
import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.function.SysConfigContract;
import org.lynn.soop.contract.user.dto.QueryCondition;
import org.lynn.soop.entity.SysParameter;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SysConfigService implements SysConfigContract {

    @Autowired
    SysConfigBusiness sysConfigBusiness;

    
    public BaseResponse<String> getConfig(BaseAPIRequest<String> request) {
        return sysConfigBusiness.getConfig(request);
    }

    
    public PageViewDto<SysParameter> getConfigList(QueryCondition queryCondition) {
        return sysConfigBusiness.getConfigList(queryCondition);
    }

    
    public BaseResponse saveConfig(BaseRequest<SysParameter> request) {
        return sysConfigBusiness.saveConfig(request);
    }

    
    public BaseResponse syncExchangeRate() {
        return sysConfigBusiness.syncExchangeRate();
    }
}
