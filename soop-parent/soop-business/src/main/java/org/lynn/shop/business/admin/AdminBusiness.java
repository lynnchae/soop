package org.lynn.soop.business.admin;

import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.entity.AdminUser;
import org.lynn.soop.repository.persistence.mybatis.handwrite.read.AdminUserReadMapper;
import org.lynn.soop.repository.persistence.mybatis.handwrite.write.AdminUserWriteMapper;
import org.lynn.soop.util.EncryptHelper;
import org.lynn.soop.util.HttpClientUtils;
import org.lynn.soop.util.MD5Utils;
import org.lynn.soop.util.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;

@Component
public class AdminBusiness {
    @Autowired
    AdminUserReadMapper adminUserReadMapper;

    @Autowired
    AdminUserWriteMapper adminUserWriteMapper;

    /**
     * 后台管理员登录
     *
     * @param loginName 账号
     * @param password  密码
     * @return 登录不成功返回null
     */
    public String login(String loginName, String password) {
        String result = "";
        try {
            String loginAuthorUrl = PropertyUtils.getValue("loginAuthorUrl");
            HashMap<String, String> params = new HashMap<>();
            params.put("username", loginName);
            params.put("password", MD5Utils.generatePassword(password));
            params.put("module_name", "soop-ERP");
            result = HttpClientUtils.doPost(loginAuthorUrl, params, "UTF-8");
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
       /* AdminUserExample adminUserExample = new AdminUserExample();
        AdminUserExample.Criteria criteria = adminUserExample.createCriteria();
        criteria.andLogin_accountEqualTo(loginName);
        criteria.andPasswordEqualTo(EncryptHelper.oneWayEncryptPassword(password));
        List<AdminUser> adminUsers = adminUserReadMapper.selectByExample(adminUserExample);

        if (adminUsers.size() == 1) {
            AdminUser toReturn = adminUsers.get(0);
            toReturn.setSession_id(UUID.randomUUID().toString());
            toReturn.setSession_expired(new Date());
            adminUserWriteMapper.updateByPrimaryKeySelective(toReturn);
            return toReturn;
        }*/

        return null;
    }

    public String checkSession(String sessionId) {
        String result = "";
        String url = PropertyUtils.getValue("verifyTokenUrl");
        HashMap<String, String> params = new HashMap<>();
        params.put("token", sessionId);
        try {
            result = HttpClientUtils.doPost(url,params);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*AdminUserExample adminUserExample = new AdminUserExample();
        AdminUserExample.Criteria criteria = adminUserExample.createCriteria();
        criteria.andSession_idEqualTo(sessionId);
        List<AdminUser> adminUsers = adminUserReadMapper.selectByExample(adminUserExample);
        if (adminUsers.size() == 1) {
            return adminUsers.get(0);
        }*/
        return null;
    }

    public BaseResponse changePassword(BaseRequest<String> request) {
        AdminUser operator = request.getOperator();
        String newPassword = EncryptHelper.oneWayEncryptPassword(request.getData());
        operator.setPassword(newPassword);
        int effectedRow = adminUserWriteMapper.updateByPrimaryKeySelective(operator);
        if (effectedRow != 1) {
            throw new RuntimeException("密码修改失败");
        }
        return BaseResponse.buildSuccessResponse("ok");
    }
}
