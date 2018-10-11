package org.lynn.soop.contract.function;

import java.util.List;

/**
 * Created by chenwen on 5/15/16.
 *
 * see http://www.kuaidi100.com/openapi/api_post.shtml
 */
public class KuaidiResp {
    public static final String STATUS_OK = "1";

    public boolean isSuccess() {
        return STATUS_OK.equals(status);
    }

    /**
     * <pre>
     查询结果状态：
     0：物流单暂无结果，
     1：查询成功，
     2：接口出现异常，
     * </pre>
     */
    String status;
    String message;

    /**
     * <pre>
     快递单当前的状态 ：　
     0：在途，即货物处于运输过程中；
     1：揽件，货物已由快递公司揽收并且产生了第一条跟踪信息；
     2：疑难，货物寄送过程出了问题；
     3：签收，收件人已签收；
     4：退签，即货物由于用户拒签、超区等原因退回，而且发件人已经签收；
     5：派件，即快递正在进行同城派件；
     6：退回，货物正处于退回发件人的途中；
     该状态还在不断完善中，若您有更多的参数需求，欢迎发邮件至 kuaidi@kingdee.com 提出。
     * </pre>
     */
    String state;
    List<Data> data;


    /**
     * <pre>
            日期时间	服务地点	详细内容
            2015-12-01 14:11	洛杉矶　	包裹进入洛杉矶操作中心　
     * </pre>
     */
    public static class Data {
        /** 每条跟踪信息的时间 : 2012-07-07 13:35:14 */
        String time;
        String site;
        String context;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getContext() {
            return context;
        }

        public void setContext(String context) {
            this.context = context;
        }

        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
