package org.lynn.soop.service.user;

import com.alibaba.dubbo.config.annotation.Service;
import org.lynn.soop.business.user.UserBusiness;
import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.user.UserServiceContact;
import org.lynn.soop.contract.user.dto.AddMemberRequest;
import org.lynn.soop.contract.user.dto.QueryCondition;
import org.lynn.soop.entity.User;
import org.lynn.soop.service.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserService extends BaseService implements UserServiceContact {

    @Autowired
    UserBusiness userBusiness;

    public BaseResponse addMember(AddMemberRequest addMemberRequest) {
        boolean isSuccess = userBusiness.addMember(addMemberRequest);
        BaseResponse toReturn;
        if (isSuccess) {
            toReturn = BaseResponse.buildSuccessResponse("success");
        } else {
            toReturn = BaseResponse.buildClientErrorResponse("添加会员失败");
        }
        return toReturn;
    }

    public PageViewDto<User> listUser(QueryCondition queryCondition) {
        return userBusiness.listUser(queryCondition);
    }

    public BaseResponse removeMember(BaseRequest<Long> request) {
        return userBusiness.removeMember(request);
    }

    public BaseResponse batchRemoveMember(BaseRequest<List<Long>> removeUserRequest) {
        return userBusiness.batchRemoveMember(removeUserRequest);
    }

    public BaseResponse updateUserInfo(BaseRequest<User> updateRequest) {
        return userBusiness.updateUserInfo(updateRequest);
    }

    @Override
    public BaseResponse getUserAddressList(String userId) {
        return userBusiness.getUserAddressList(userId);
    }
}
