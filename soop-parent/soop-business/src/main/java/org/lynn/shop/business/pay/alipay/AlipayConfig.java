package org.lynn.soop.business.pay.alipay;

/**
 * Created by chenwen on 5/13/16.
 */
public class AlipayConfig {


    // 合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://b.alipay.com/order/pidAndKey.htm
    public String partner = "2088911973210566";

    // 收款支付宝账号，以2088开头由16位纯数字组成的字符串，一般情况下收款账号就是签约账号
    public String seller_id = partner;

    // MD5密钥，安全检验码，由数字和字母组成的32位字符串，查看地址：https://b.alipay.com/order/pidAndKey.htm
    public String key = "c183n6159dfb0xxd5bfoxey51qzldags";


    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public String notify_url = "http://商户网址/openapi/pay/alipay/notify-result";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public String return_url = "http://商户网址/alipay.wap.create.direct.pay.by.user-JAVA-UTF-8/return_url.jsp";

    // 签名方式
    public String sign_type = "MD5";

    // 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
    public String log_path = "/tmp/alipay";

    // 字符编码格式 目前支持utf-8
    public String input_charset = "utf-8";

    // 支付类型 ，无需修改
    public String payment_type = "1";

    // 调用的接口名，无需修改
    public String service = "alipay.wap.create.direct.pay.by.user";


}
