package org.lynn.soop.controller.common;

import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.function.FileStoreServiceContact;
import org.lynn.soop.contract.function.SysConfigContract;
import org.lynn.soop.contract.user.dto.QueryCondition;
import org.lynn.soop.entity.SysParameter;
import org.lynn.soop.util.Contants;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import static org.lynn.soop.util.DataHelper.buildErrorMsg;

@Controller
@Path("/service/common")
@Produces({"application/json;charset=UTF-8"})
public class CommonController extends BaseController {

    @Resource
    private FileStoreServiceContact imageStoreService;

    @Resource
    SysConfigContract sysConfigContract;

    @POST
    @Path("/image/upload")
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    @Consumes("multipart/form-data")
    public BaseResponse imageUplload(MultipartFormDataInput input) {
        BaseResponse toReturn;
        try {
            List<InputPart> files = input.getFormDataMap().get("file");
            final InputStream inputStream = files.get(0).getBody(Contants.Http.inputStreamGenericType);

            String destFileName = UUID.randomUUID().toString() + ".png";
            log.info("save file with name:" + destFileName);
            return imageStoreService.saveFile(inputStream, destFileName);

        } catch (Exception e) {
            log.error("error in import batch data.");
            toReturn = BaseResponse.buildServerErrorResponse("图片上传失败");
        }
        return toReturn;
    }

    @POST
    @Path("/config/list")
    @Produces({"application/json;charset=UTF-8"})
    public PageViewDto<SysParameter> configList(QueryCondition queryCondition) {
        PageViewDto toReturn;
        try {
            toReturn = sysConfigContract.getConfigList(queryCondition);
        } catch (Exception e) {
            String errorMsg = buildErrorMsg("获取配置失败" + e.getMessage());
            log.error(errorMsg, e);
            toReturn = PageViewDto.empty();
        }
        return toReturn;
    }

    @POST
    @Path("/config/update")
    @Consumes(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public BaseResponse saveSysConfig(SysParameter sysParameter) {
        BaseResponse toReturn;
        try {
            BaseRequest<SysParameter> request = setupRequest(sysParameter);
            toReturn = sysConfigContract.saveConfig(request);
        } catch (Exception e) {
            String errorMsg = buildErrorMsg("更新参数失败" + e.getMessage());
            log.error(errorMsg, e);
            toReturn = BaseResponse.buildServerErrorResponse(errorMsg);
        }
        return toReturn;

    }


}
