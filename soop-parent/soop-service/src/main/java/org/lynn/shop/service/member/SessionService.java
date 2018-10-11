package org.lynn.soop.service.member;

import com.alibaba.dubbo.config.annotation.Service;
import org.lynn.soop.business.member.MemberBusiness;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.member.SessionServiceContact;
import org.lynn.soop.entity.UserSession;
import org.lynn.soop.service.common.BaseService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.Callable;

/**
 * Created by chenwen on 5/06/16.
 */
@Service
public class SessionService extends BaseService implements SessionServiceContact {

    @Resource
    private MemberBusiness memberBusiness;


    @Transactional
     
    public BaseResponse<UserSession> create(final String userId, final String sessionId) {
        return service("创建会话", new Callable<UserSession>() {
             
            public UserSession call() throws Exception {
                return memberBusiness.createSession(userId, sessionId);
            }
        });
    }

     
    public BaseResponse<UserSession> check(final String sessionId) {
        return service("创建会话", new Callable<UserSession>() {
             
            public UserSession call() throws Exception {
                return memberBusiness.checkSession(sessionId);
            }
        });
    }

    @Transactional
     
    public BaseResponse<UserSession> invalid(final String sessionId) {
        return service("销毁会话", new Callable<UserSession>() {
             
            public UserSession call() throws Exception {
                return memberBusiness.invalidSession(sessionId);
            }
        });
    }

}
