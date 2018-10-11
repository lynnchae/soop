package org.lynn.soop.openapi.controller;

import org.lynn.soop.contract.BaseAPIRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.function.FileStoreServiceContact;
import org.lynn.soop.contract.function.SysConfigContract;
import org.lynn.soop.util.Contants;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;

@Controller
@Path("/openapi/common")
@Produces({"application/json;charset=UTF-8"})
public class CommonController extends BaseResource {

    @Resource
    private FileStoreServiceContact imageStoreService;

    @Resource
    SysConfigContract sysConfigContract;

    @GET
    @Path("/config")
    public BaseResponse<String> getConfigValue(@QueryParam("key") final String key) {
        return invoke("获取系统参数", new Callable<BaseResponse<String>>() {
            @Override
            public BaseResponse<String> call() throws Exception {
                BaseAPIRequest<String> request = setupRequest(key, false);
                return sysConfigContract.getConfig(request);
            }
        });

    }

    @POST
    @Path("/file/save")
    @Consumes({"multipart/form-data;charset=utf-8"})
    public BaseResponse<String> saveFile(@FormParam("filePath") final String filePath) {

        return invoke("保存图片", new Callable<BaseResponse<String>>() {
            @Override
            public BaseResponse<String> call() throws Exception {
                return imageStoreService.saveFile(httpRequest.getInputStream(), filePath);
            }
        });

    }

    @GET
    @Path("/file/load")
    public BaseResponse<String> loadFile(@FormParam("filePath") final String filePath) {

        return invoke("加载图片", new Callable<BaseResponse<String>>() {
            @Override
            public BaseResponse<String> call() throws Exception {
                BaseResponse<URL> resp = imageStoreService.loadFile(filePath);
                return BaseResponse.buildSuccessResponse(resp.getData().toString());
            }
        });

    }


    @POST
    @Path("/image/upload")
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    @Consumes("multipart/form-data")
    public BaseResponse importPurchaseResult(MultipartFormDataInput input) {
        BaseResponse toReturn;
        try {
            List<InputPart> files = input.getFormDataMap().get("file");
            final InputStream inputStream = files.get(0).getBody(Contants.Http.inputStreamGenericType);

            return invoke("保存图片", new Callable<BaseResponse<String>>() {
                @Override
                public BaseResponse<String> call() throws Exception {
                    String destFileName = UUID.randomUUID().toString() + ".png";
                    logger.info("save file with name:" + destFileName);
                    return imageStoreService.saveFile(inputStream, destFileName);
                }
            });

        } catch (Exception e) {
            logger.error("error in import batch data.");
            toReturn = BaseResponse.buildServerErrorResponse("图片上传失败");
        }
        return toReturn;
    }

}
