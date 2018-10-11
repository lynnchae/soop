package org.lynn.soop.contract.function;

import org.lynn.soop.contract.BaseResponse;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by chenwen on 5/06/16.
 */
@Path("/service/function/file")
@Produces({"application/json;charset=UTF-8"})
public interface FileStoreServiceContact {

    @POST
    @Path("/save")
    BaseResponse<String> saveFile(InputStream source, String destFileName);

    @POST
    @Path("/load")
    BaseResponse<URL> loadFile(String destFileName);

}
