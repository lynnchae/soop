package org.lynn.soop.service.function;

import com.alibaba.dubbo.config.annotation.Service;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.function.FileStoreServiceContact;
import org.lynn.soop.service.common.BaseService;
import org.lynn.soop.util.ExceptionUtil;
import org.apache.commons.io.IOUtils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.Callable;

/**
 * Created by chenwen on 5/06/16.
 */
@Service
public class QiniuCloudStoreService extends BaseService implements FileStoreServiceContact {

    // todo load values from config file
    protected String getAccessKey() {
        return "zkfbP7uQDpNuRAwWi2pkG4iR3tpHy1RANV95g0nF";
    }
    protected String getSecretKey() {
        return "LG9cfSXTWWuOe18erqbM908cOPGkiMPQC7Nl3qyt";
    }
    protected String getBucketname() {
        return "gggg";
    }
    protected String getBucketnameDownloadBaseURL() {
        return "http://7xthb5.com2.z0.glb.clouddn.com/";
    }


    //密钥配置
    protected Auth auth;
    //上传对象
    protected UploadManager uploadManager;

    @PostConstruct
    public void init() {
        auth = Auth.create(getAccessKey(), getSecretKey());
        uploadManager = new UploadManager();
    }

    @PreDestroy
    public void destory() {
        // do nothing for the moment
    }


    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    protected String getUpToken(){
        return auth.uploadToken(getBucketname());
    }

    /**
     * @param source //上传文件的路径
     * @param destFileName //上传到七牛后保存的文件名
     */
    public BaseResponse<String> saveFile(InputStream source, String destFileName) {
        try {
            //调用put方法上传
            Response res = uploadManager.put(IOUtils.toByteArray(source), destFileName, getUpToken());
            //打印返回的信息
            String hashKey = res.bodyString();

            logger.debug("upload image result: [" + hashKey + "]");
            /* ****** sample response ******
            {"hash":"Fqj9wgWp8ZzBx1B6YMTwGxPRHX_Q","key":"my-test.txt"}
             */
            return BaseResponse.buildSuccessResponse(hashKey);

        } catch (Exception e) {
            Throwable ee = ExceptionUtil.getRootCause(e);
            String errorMsg = String.valueOf(ee);
            if (ee instanceof QiniuException) {
                Response r = ((QiniuException)ee).response;
                errorMsg = r.toString();    // 请求失败时打印的异常的信息
            }
            logger.error("saveFile() error: [" + errorMsg + "]");
            return BaseResponse.buildServerErrorResponse(errorMsg);
        }
    }

    //TODO 可能有延迟...
    public BaseResponse<URL> loadFile(final String destFileName){
        return service("", new Callable<URL>() {
            public URL call() throws Exception {
                String baseURL = getBucketnameDownloadBaseURL() + destFileName;
                return new URL(baseURL);
            }
        });


//        try {
//            //调用privateDownloadUrl方法生成下载链接,第二个参数可以设置Token的过期时间(秒)
//            String downloadRUL = auth.privateDownloadUrl(baseURL, 3600 * 24);   // 默认24小时过期
//            logger.debug("generate download URL: [" + downloadRUL + "]");
//
//            //sample >>  http://7xthb5.com2.z0.glb.clouddn.com/my-test2.txt?attname=&e=1462556577&token=zkfbP7uQDpNuRAwWi2pkG4iR3tpHy1RANV95g0nF:P8Q-mlfG6VxWJLyL7y7VbeAqB78
//
//            URL url = new URL(downloadRUL);
//
//            return BaseResponse.buildSuccessResponse(url);
//        } catch (Exception e) {
//            Throwable ee = ExceptionUtil.getRootCause(e);
//            logger.error("generate download URL failed: " + ee , e);
//            return BaseResponse.buildServerErrorResponse(ee+"");
//        }
    }

}
