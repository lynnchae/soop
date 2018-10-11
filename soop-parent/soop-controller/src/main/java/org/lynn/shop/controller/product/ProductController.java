package org.lynn.soop.controller.product;

import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.BaseQueryRequest;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.product.ProductServiceContact;
import org.lynn.soop.controller.common.BaseController;
import org.lynn.soop.controller.common.exception.NoLoginException;
import org.lynn.soop.controller.product.dto.ProductSalesPropertyDto;
import org.lynn.soop.entity.Product;
import org.lynn.soop.entity.ProductPrice;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataMultiPart;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;
import java.util.List;

import static org.lynn.soop.util.JsonHelper.toJSON;

/**
 * Created with IntelliJ IDEA.
 * User         : ethan
 * Date         : 5/6/16
 * Time         : 3:39 PM
 * Description  : describe your class here
 */
@Controller
@Path("/service/product")
@Produces({"application/json;charset=UTF-8"})
public class ProductController extends BaseController {
    @Resource
    ProductServiceContact productServiceContact;


    @POST
    @Path("/update")
    @Consumes({"application/json;charset=UTF-8"})
    public BaseResponse updateProduct(Product product) {
        log.info("start to update product :" + toJSON(product));

        BaseResponse result;
        try {
            BaseRequest<Product> request = setupRequest(product);
            result = productServiceContact.updateProduct(request);
        } catch (NoLoginException e) {
            log.error("operation not allowed for no login user.");
            result = BaseResponse.buildResponse(ERP_CONTEXT_PATH + "login.html", 302);
        } catch (Exception e) {
            log.error("error in update product info.", e);
            result = BaseResponse.buildClientErrorResponse("添加或更新信息失败");
        }
        return result;
    }

    /**
     * to update product attribute batch, login required.
     *
     * @return
     */
    @POST
    @Path("/sysproductattribute")
    public BaseResponse syncProductAttribute(List<Long> ids) {
        log.info("start to syncProductAttribute");

        BaseResponse result;
        try {
            BaseRequest<List<Long>> request = setupRequest(ids);
            result = productServiceContact.syncProductAttribute(request);
        } catch (NoLoginException e) {
            log.error("operation not allowed for no login user.");
            result = BaseResponse.buildResponse(ERP_CONTEXT_PATH + "login.html", 302);
        } catch (Exception e) {
            log.error("error in syncProductAttribute.", e);
            result = BaseResponse.buildClientErrorResponse("同步更新信息失败");
        }
        return result;
    }


    @POST
    @Path("/list")
    public PageViewDto listProduct(BaseQueryRequest queryCondition) {
        log.info("start handle list product request:" + toJSON(queryCondition));
        PageViewDto<org.lynn.soop.entity.dto.ProductDto> toReturn;
        try {
            toReturn = productServiceContact.listProduct(queryCondition);
        } catch (Exception e) {
            log.error("error in list product.", e);
            toReturn = PageViewDto.empty();
        }
        log.info("complete handle list product request with response: " + toJSON(toReturn));

        return toReturn;
    }


    @POST
    @Path("/remove/batch")
    public BaseResponse batchRemoveProduct(List<Long> ids) {
        log.info("start to remove product :" + toJSON(ids));

        BaseResponse result;
        try {
            BaseRequest<List<Long>> request = setupRequest(ids);
            result = productServiceContact.batchRemoveProduct(request);
        } catch (NoLoginException e) {
            log.error("operation not allowed for no login user.");
            result = BaseResponse.buildResponse(ERP_CONTEXT_PATH + "login.html", 302);
        } catch (Exception e) {
            log.error("error in remove product.", e);
            result = BaseResponse.buildClientErrorResponse("删除失败");
        }
        return result;
    }

    @POST
    @Path("/price/update")
    @Consumes({"application/json;charset=UTF-8"})
    public BaseResponse updateProductPrice(ProductPrice productPrice) {
        log.info("start to update product price:" + toJSON(productPrice));

        BaseResponse result;
        try {
            BaseRequest<ProductPrice> request = setupRequest(productPrice);
            result = productServiceContact.updateProductPrice(request);
        } catch (NoLoginException e) {
            log.error("operation not allowed for no login user.");
            result = BaseResponse.buildResponse(ERP_CONTEXT_PATH + "login.html", 302);
        } catch (Exception e) {
            log.error("error in update product price.", e);
            result = BaseResponse.buildClientErrorResponse("添加或更新信息失败");
        }
        return result;
    }

    @POST
    @Path("/price/list")
    public PageViewDto listProductPrice(BaseQueryRequest queryCondition) {
        log.info("start handle list product price request:" + toJSON(queryCondition));
        PageViewDto<ProductPrice> toReturn;
        try {
            toReturn = productServiceContact.listProductPrice(queryCondition);
        } catch (Exception e) {
            log.error("error in list product price.", e);
            toReturn = PageViewDto.empty();
        }
        log.info("complete handle list product price request with response: " + toJSON(toReturn));

        return toReturn;
    }

    @POST
    @Path("/batch/upload")
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    @Consumes(MediaType.MULTIPART_FORM_DATA + "; charset=utf-8")
    public BaseResponse batchUpload(FormDataMultiPart multiPart) {
        BaseResponse toReturn;
        try {
            FormDataBodyPart file = multiPart.getField("file");
            InputStream inputStream = file.getValueAs(InputStream.class);
            BaseRequest<InputStream> request = setupRequest(inputStream);
            return productServiceContact.batchUpload(request);
        } catch (Exception e) {
            log.error("error in batch upload product", e);
            toReturn = BaseResponse.buildClientErrorResponse("批量导入商品信息失败:" + e.getMessage());
        }
        return toReturn;
    }


    @POST
    @Path("/sp/update")
    @Consumes({"application/json;charset=UTF-8"})
    public BaseResponse updateProductSalesProperty(ProductSalesPropertyDto productSalesPropertyDto) {
        log.info("start to update product :" + toJSON(productSalesPropertyDto));

        BaseResponse result ;
        try {
            Product product = new Product();
            product.setId(productSalesPropertyDto.getId());
            product.setStock_count(productSalesPropertyDto.getStock_count());
            product.setDate_updated(productSalesPropertyDto.getDate_updated());
            product.setUpdated_by(productSalesPropertyDto.getUpdated_by());
            product.setPrice_on_sale(productSalesPropertyDto.getPrice_on_sale());
            product.setIs_online(productSalesPropertyDto.getIs_online());
            BaseRequest<Product> request = setupRequest(product);
            result = productServiceContact.updateProductAndSp(request,productSalesPropertyDto.getSpList());

        } catch (Exception e) {
            log.error("error in update product info.", e);
            result = BaseResponse.buildClientErrorResponse("添加或更新信息失败");
        }
        return result;
    }
}
