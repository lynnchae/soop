package org.lynn.soop.business.user;

import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.PageRequest;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.user.dto.AddMemberRequest;
import org.lynn.soop.contract.user.dto.QueryCondition;
import org.lynn.soop.entity.User;
import org.lynn.soop.entity.UserAddress;
import org.lynn.soop.entity.UserAddressExample;
import org.lynn.soop.entity.UserExample;
import org.lynn.soop.repository.persistence.mybatis.handwrite.read.UserAddressReadMapper;
import org.lynn.soop.repository.persistence.mybatis.handwrite.read.UserReadMapper;
import org.lynn.soop.repository.persistence.mybatis.handwrite.write.UserWriteMapper;
import org.lynn.soop.util.EncryptHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static org.lynn.soop.util.DataHelper.generateUniqueToken;
import static org.lynn.soop.util.JsonHelper.toJSON;

@Component
public class UserBusiness {
    private static final Logger log = Logger.getLogger(UserBusiness.class);
    @Autowired
    UserReadMapper userReadMapper;

    @Autowired
    UserWriteMapper userWriteMapper;

    @Autowired
    UserAddressReadMapper userAddressReadMapper;

    public boolean addMember(AddMemberRequest request) {
        User user = new User();
        user.setMobile_no(request.getMobileNo());
        user.setLogin_name(request.getLoginName());
        user.setPassword(EncryptHelper.oneWayEncryptPassword(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setUnique_token(generateUniqueToken());
        user.setDate_created(new Date());
        int effectedRow = userWriteMapper.insert(user);
        if (effectedRow <= 0) {
            throw new RuntimeException("用户添加失败");
        }
        return true;
    }

    public PageViewDto<User> listUser(QueryCondition queryCondition) {
        UserExample userExample = new UserExample();

        if (!StringUtils.isBlank(queryCondition.getPageRequest().getSearch())) {
            userExample.createCriteria().andLogin_nameLike("%"+queryCondition.getPageRequest().getSearch()+"%");
        }

        int totalCount = userReadMapper.countByExample(userExample);

        PageRequest pageRequest = queryCondition.getPageRequest();
        userExample.setPageCount(pageRequest.getLimit());
        userExample.setPageIndex(pageRequest.getOffset() / pageRequest.getLimit() + 1);
        List<User> users = userReadMapper.selectByExample(userExample);
        PageViewDto<User> toReturn = new PageViewDto<User>();
        toReturn.setDataList(users);
        toReturn.setTotalNumber(totalCount);
        return toReturn;
    }

    public BaseResponse removeMember(BaseRequest<Long> request) {
        Long userId = request.getData();
        int effectedRow = userWriteMapper.deleteByPrimaryKey(userId);
        BaseResponse toReturn = BaseResponse.buildSuccessResponse("ok");
        if (effectedRow != 1) {
            log.error(String.format("error in remove member user [%s], with effected row [%s]", userId, effectedRow));
            toReturn = BaseResponse.buildClientErrorResponse("删除用户失败");
        }
        return toReturn;
    }

    public BaseResponse batchRemoveMember(BaseRequest<List<Long>> removeUserRequest) {
        List<Long> userIds = removeUserRequest.getData();
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdIn(userIds);
        int effectedRows = userWriteMapper.deleteByExample(userExample);
        BaseResponse toReturn = BaseResponse.buildSuccessResponse("ok");
        if (effectedRows == 0) {
            log.error(String.format("error in remove member user: [%s]", toJSON(userIds)));
            toReturn = BaseResponse.buildClientErrorResponse("批量删除用户失败");
        }
        return toReturn;
    }

    public BaseResponse updateUserInfo(BaseRequest<User> updateRequest) {
        User user = updateRequest.getData();
        User toUpdated = new User();
        toUpdated.setId(user.getId());
        toUpdated.setMobile_no(user.getMobile_no());
        toUpdated.setEmail(user.getEmail());
        toUpdated.setDate_updated(new Date());
        int effectedRow = userWriteMapper.updateByPrimaryKeySelective(toUpdated);
        BaseResponse toReturn = BaseResponse.buildSuccessResponse("ok");
        if (effectedRow == 0) {
            log.error(String.format("error in update member user: [%s]", toJSON(updateRequest)));
            toReturn = BaseResponse.buildClientErrorResponse("更新用户信息失败");
        }
        return toReturn;
    }

    public BaseResponse getUserAddressList(String userId) {
        //先去user表查询id,再根据查询出的id去user_address表查询数据
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUser_nameEqualTo(userId);
        List<User> users = userReadMapper.selectByExample(userExample);
        Long id = users.get(0).getId();

        UserAddressExample uaExmple = new UserAddressExample();
        uaExmple.createCriteria().andUser_idEqualTo(id);
        List<UserAddress> userAddresses = userAddressReadMapper.selectByExample(uaExmple);
        BaseResponse toReturn = BaseResponse.buildSuccessResponse(userAddresses);
        return toReturn;

    }
}
