package org.lynn.soop.service.function;

import com.alibaba.dubbo.config.annotation.Service;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.function.KuaidiResp;
import org.lynn.soop.contract.function.KuaidiServiceContact;
import org.lynn.soop.service.common.BaseService;
import org.lynn.soop.util.JsonHelper;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by chenwen on 5/15/16.
 */
@Service
public class Kuaidi100Service extends BaseService implements KuaidiServiceContact {

    // todo 配置
    Map<String, String> kuaidi100ConfMap;


    public BaseResponse<KuaidiResp> query(final String com, final String nu) {
        return service("运单查询", new Callable<KuaidiResp>() {
            public KuaidiResp call() throws Exception {

                String urlTpl = "http://api.kuaidi100.com/api?id=%1$s&com=%2$s&nu=%3$s&show=%4$s&muti=%5$s&order=%6$s";

                String a_id身份授权key = "803ade7a8764dea1";  //todo 配置化
                String b_com要查询的快递公司代码 = com;   //"tiantian";
                String c_no要查询的快递单号 = nu;        //"11111";
                /*
                        返回类型：
                0：返回json字符串，
                1：返回xml对象，
                2：返回html对象，     ["text/html"]
                3：返回text文本。
                如果不填，默认返回json字符串。
                 */
                String d_show返回类型 = "0";
                String e_muti返回信息数量 = "1";
                String f_order排序 = "desc";

                String urlStr = String.format(urlTpl, a_id身份授权key, b_com要查询的快递公司代码, c_no要查询的快递单号, d_show返回类型, e_muti返回信息数量, f_order排序);


                URL url= new URL(urlStr);
                URLConnection con=url.openConnection();
                con.setAllowUserInteraction(false);
                InputStream urlStream = url.openStream();
                String type = con.guessContentTypeFromStream(urlStream);
                String charSet="UTF-8";
                if (type == null) {
                    type = con.getContentType();
                }

                System.out.println("type: [" + type + "]");
                if (type == null || type.trim().length() == 0 || type.trim().indexOf("text/html") < 0) {
                    //return ;
                }

                if(type != null && type.indexOf("charset=") > 0) {
                    charSet = type.substring(type.indexOf("charset=") + 8);
                    System.out.println("charset: [" + charSet + "]");
                }

                String content = IOUtils.toString(urlStream, charSet);
                System.out.println("content: [" + content + "]");
                urlStream.close();

                KuaidiResp resp = JsonHelper.fromJSON(content, KuaidiResp.class);
                return resp;
            }
        });
    }

}
