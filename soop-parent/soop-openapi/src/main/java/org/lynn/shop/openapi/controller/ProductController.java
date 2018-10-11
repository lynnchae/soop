package org.lynn.soop.openapi.controller;

import org.lynn.soop.contract.product.ProductServiceContact;
import org.lynn.soop.contract.product.dto.MainCategoryDto;
import org.lynn.soop.entity.ProductCategory;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright @ 2013QIANLONG.
 * All right reserved.
 * Class Name : org.lynn.soop.openapi.controller
 * Description :
 * Author : cailinfeng
 * Date : 2016/7/25
 */
@Controller
@Path("/openapi/product")
@Produces({"application/json;charset=UTF-8"})
public class ProductController extends BaseResource {

    @Resource
    private ProductServiceContact productServiceContact;

    @GET
    @Path("/category/main/list")
    public List<MainCategoryDto> listMainCategory(){
        logger.info("start to listMainCategory");
        List<MainCategoryDto> result;
        try {
            List<ProductCategory> list = productServiceContact.listMainCategory();
            result = MainCategoryDto.fromList(list);
        }catch (Exception e) {
            logger.error("error in listMainCategory.", e);
            result = new ArrayList<>();
        }
        return result;
    }

}
