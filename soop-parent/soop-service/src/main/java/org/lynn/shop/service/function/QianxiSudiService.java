package org.lynn.soop.service.function;

import com.alibaba.dubbo.config.annotation.Service;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.function.KuaidiResp;
import org.lynn.soop.contract.function.KuaidiServiceContact;
import org.lynn.soop.service.common.BaseService;
import org.lynn.soop.util.JsonHelper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;

/**
 * Created by chenwen on 5/20/16.
 */
@Service
public class QianxiSudiService extends BaseService implements KuaidiServiceContact {

    public BaseResponse<KuaidiResp> query(String com, final String nu) {
        return service("中国千禧速递查询", new Callable<KuaidiResp>() {
            public KuaidiResp call() throws Exception {
                KuaidiResp resp = new KuaidiResp();

                String url = "http://112.124.119.181/cgi-bin/GInfo.dll?EmmisTrack";     //todo 配置化

                Document doc = Jsoup.connect(url).data(Collections.singletonMap("cno", nu)).post();
                Elements oDetail = doc.select("div#oDetail");
                if (oDetail.size() < 1) {   //数据节点没找到
                    return resp;
                }
                resp.setData(new ArrayList<KuaidiResp.Data>());
                resp.setState(KuaidiResp.STATUS_OK);

                Elements tr = oDetail.select("tr");
                for (int trIdx = 1; trIdx < tr.size(); trIdx ++) {
                    KuaidiResp.Data d = new KuaidiResp.Data();
                    resp.getData().add(d);

                    Elements td = tr.get(trIdx).select("td");
                    for (int tdIdx = 0; tdIdx < td.size(); tdIdx ++) {
                        Element e = td.get(tdIdx);
                        String val = e.text().trim();   //todo 最后有一个不可见字符

                        switch (tdIdx) {
                            case 0: {
                                d.setTime(val);
                                break;
                            }
                            case 1: {
                                d.setSite(val);
                                break;
                            }
                            case 2: {
                                d.setContext(val);
                                break;
                            }
                        }
                    }
                }
                return resp;
            }
        });
    }

   static class test {
       public static void main(String[] args) {
           QianxiSudiService s = new QianxiSudiService();
           BaseResponse<KuaidiResp> resp = s.query("qianxi", "QX900135018");
           System.out.println(JsonHelper.toGson(resp));
           System.out.println(resp);
           System.out.println(resp.isSuccess());
       }
   }

}
