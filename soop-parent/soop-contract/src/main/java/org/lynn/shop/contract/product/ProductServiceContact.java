package org.lynn.soop.contract.product;

import org.lynn.soop.contract.BaseAPIRequest;
import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.BaseQueryRequest;
import org.lynn.soop.contract.dto.PageRequest;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.product.dto.*;
import org.lynn.soop.entity.*;

import org.atmosphere.config.service.Post;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Path("/service/product")
@Produces({"application/json;charset=UTF-8"})
@Consumes("application/json;charset=UTF-8")
public interface ProductServiceContact {

    @POST
    @Path("/save-brand")
    BaseResponse<Long> saveBrand(BaseRequest req);

    @POST
    @Path("/save-category")
    BaseResponse<Long> saveCategory(BaseRequest req);

    @POST
    @Path("/save-attr")
    BaseResponse<Long> saveAttribute(BaseRequest req);


    @POST
    @Path("/delete-brand")
    BaseResponse<Long> deleteBrand(BaseRequest req);

    @POST
    @Path("/delete-category")
    BaseResponse<Long> deleteCategory(BaseRequest req);

    @POST
    @Path("/delete-attr")
    BaseResponse<Long> deleteAttribute(BaseRequest req);

    @POST
    @Path("/delete")
    BaseResponse<Long> delete(BaseRequest req);


    @POST
    @Path("/page-brand")
    BaseResponse<PageViewDto<ProductBrandDto>> pageBrand(BaseRequest req);

    @POST
    @Path("/page-category")
    BaseResponse<PageViewDto<ProductCategoryDto>> pageCategory(BaseRequest req);

    @POST
    @Path("/page-attr")
    BaseResponse<PageViewDto<ProductAttributeDto>> listAttributesOfCategory(BaseRequest req);

    @POST
    @Path("/page")
    BaseResponse<PageViewDto<ProductDto>> page(BaseRequest req);

    @POST
    @Path("/brand/update")
    BaseResponse updateBrand(BaseRequest<ProductBrand> request);


    @POST
    @Path("/brand/list")
    PageViewDto<ProductBrand> listBrand(BaseQueryRequest queryCondition);

    @POST
    @Path("/brand/batch/remove")
    BaseResponse batchRemoveBrand(BaseRequest<List<Long>> removeRequest);

    @POST
    @Path("/category/update")
    BaseResponse updateCategory(BaseRequest<ProductCategory> request);

    @POST
    @Path("/category/main/list")
    PageViewDto<ProductCategory> listCategory(CategoryQueryRequest queryCondition);

    @POST
    @Path("/category/remove")
    BaseResponse batchRemoveCategory(BaseRequest<List<Long>> request);

    @POST
    @Path("/category/sub/list")
    PageViewDto<ProductCategory> listSubCategory(BaseQueryRequest queryCondition);


    @POST
    @Path("/attribute/update")
    BaseResponse updateAttribute(BaseRequest<ProductAttribute> request);


    @POST
    @Path("/attribute/list")
    PageViewDto<ProductAttribute> listCategoryAttribute(Long categoryId);

    @POST
    @Path("/attribute/remove")
    BaseResponse removeAttribute(BaseRequest<Long> request);


    @POST
    @Path("/goodsList")
    BaseResponse<HomePageResponseDTO> indexView(BaseAPIRequest<IndexHomeReqDto> req);

    @POST
    @Path("/list-by-attr")
    BaseResponse<PageViewDto<ProductDto>> listByAttr(PageRequest req);

    @POST
    @Path("/list-by-category")
    BaseResponse<PageViewDto<ProductDto>> listByCategory(BaseAPIRequest<PageRequest> req);

    @POST
    @Path("/get-basic-detail")
    BaseResponse<ProductDto> getBasicDetail(BaseAPIRequest<Long> request);

    @POST
    @Path("/product/update")
    BaseResponse updateProduct(BaseRequest<Product> request);

    @POST
    @Path("/product/list")
    PageViewDto<org.lynn.soop.entity.dto.ProductDto> listProduct(BaseQueryRequest queryCondition);

    @POST
    @Path("/product/remove/batch")
    BaseResponse batchRemoveProduct(BaseRequest<List<Long>> request);

    @POST
    @Path("/brand/list/all")
    List<ProductBrand> listAllBrand();

    @POST
    @Path("/product/update/price")
    BaseResponse updateProductPrice(BaseRequest<ProductPrice> request);

    @POST
    @Path("/product/list/price")
    PageViewDto<ProductPrice> listProductPrice(BaseQueryRequest queryCondition);

    @POST
    @Path("/product/batch/upload")
    BaseResponse batchUpload(BaseRequest<InputStream> request);

    @POST
    @Path("/product/search-by-name")
    BaseResponse<PageViewDto<ProductDto>> searchByName(BaseAPIRequest<String> req);
    
    @POST
    @Path("/product/search-by-name")
    BaseResponse<Long> searchBySalesPropery(Long goodsId, String salesPropery, String merchants_code);


    /**
     * 首页展示数据内容
     *
     * @param request
     * @return
     */
    @POST
    @Path("/product/home/hybird/data")
    BaseResponse<HomePageResponseDTO> loadIndexPageData(BaseAPIRequest<IndexViewReqDto> request);

    @POST
    @Path("/product/detail/multipule")
    BaseResponse<List<ProductDto>> getMultipuleGoodDetail(BaseAPIRequest<String[]> request);

    @POST
    @Path("/product/syncattribute")
    BaseResponse syncProductAttribute(BaseRequest<List<Long>> request);

    @Post
    @Path("/product/updateProductAndSp")
    BaseResponse updateProductAndSp(BaseRequest<Product> request, Map<Long, String> spList);

    @Post
    @Path("/main/list")
    List<ProductCategory> listMainCategory();
}
