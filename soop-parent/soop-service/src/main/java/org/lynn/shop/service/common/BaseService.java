package org.lynn.soop.service.common;

import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.exception.MyBizException;
import org.lynn.soop.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

/**
 * Created by chenwen on 4/23/16.
 */
public abstract class BaseService {

    protected Logger logger = LoggerFactory.getLogger(getClass());


    protected <T> BaseResponse<T> service(String logicName, Callable<T> logic) {
        String logHead = String.format("[%s] service ", logicName);
        logger.info(logHead + "starting...");
        try {

            T respDto = logic.call();

            //logger.info(logHead + "done.");
            //logger.debug(logHead + "result: >>" + respDto + "<<");

            return BaseResponse.buildSuccessResponse(respDto);

        } catch (Throwable e) {
            Throwable ee = ExceptionUtil.getRootCause(e);
            String msg = logHead + "error: " + ee;
            logger.error(msg, e);
            if (ee instanceof MyBizException) {
                return ((MyBizException)ee).getResp();
            } else if (ee instanceof IllegalArgumentException) {
                return BaseResponse.buildClientErrorResponse(msg);
            } else {
                return BaseResponse.buildServerErrorResponse(msg);
            }
        }
    }

}
