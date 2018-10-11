package org.lynn.soop.contract.product;

import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.entity.dto.ProductSalesPropertyAndValuesDto;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by gaoguoxiang on 2016/7/14
 */
@Path("/service/product/sales/property")
@Produces({"application/json;charset=UTF-8"})
@Consumes("application/json;charset=UTF-8")
public interface ProductSalesPropertyServiceContact {

  /*  @POST
    @Path("/update")
    BaseResponse<Long> updateProductSalesProperty();*/

    @POST
    @Path("/list")
    PageViewDto<ProductSalesPropertyAndValuesDto> listProductSalesProperty(Long productId);

}
