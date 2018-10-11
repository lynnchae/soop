package org.lynn.soop.openapi.controller;

import org.lynn.soop.contract.BaseAPIRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.PageRequest;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.member.CartServiceContact;
import org.lynn.soop.contract.member.dto.CartDetailsDto;
import org.lynn.soop.contract.product.ProductServiceContact;
import org.lynn.soop.contract.product.dto.HomePageResponseDTO;
import org.lynn.soop.contract.product.dto.IndexHomeReqDto;
import org.lynn.soop.contract.product.dto.ProductDto;
import org.lynn.soop.entity.UserSession;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import static com.google.common.base.Preconditions.checkNotNull;

@Controller
@Path("/openapi")
@Produces({"application/json;charset=UTF-8"})
public class GoodsController extends BaseResource {
    @Resource
    private ProductServiceContact productService;
    @Resource
    private CartServiceContact cartService;
    @Resource
    Map<String, String> indexPageTypeMap;

    /**
     * 首页列表
     *
     * @param limit 列表限制
     * @return
     */
    @GET
    @Path("/goodsList")
    public BaseResponse<HomePageResponseDTO> index(@QueryParam("limit") @DefaultValue("10") final int limit) {
        logger.info("-------------------------------------------------------");
    	return invoke("加载首页", new Callable<BaseResponse<HomePageResponseDTO>>() {
            @Override
            public BaseResponse<HomePageResponseDTO> call() throws Exception {
                IndexHomeReqDto reqDto = new IndexHomeReqDto();
                reqDto.setLimit(limit);
                reqDto.setCategoryNameIdMap(indexPageTypeMap);

                BaseAPIRequest<IndexHomeReqDto> req = setupRequest(reqDto, false);
                return productService.indexView(req);
            }
        });
    }

    /**
     * 通过属性（热销，新品）加载商品列表
     *
     * @param attrId
     * @param limit
     * @return
     */
    @GET
    @Path("/goodsList/searchByAttributes")
    public BaseResponse<PageViewDto<ProductDto>> listByAttributes(@QueryParam("attrId") final long attrId,
                                                                  @QueryParam("limit") @DefaultValue("10") final int limit,
                                                                  @QueryParam("offset") @DefaultValue("0") final int offset) {
        return invoke("加载特性商品列表", new Callable<BaseResponse<PageViewDto<ProductDto>>>() {
            @Override
            public BaseResponse<PageViewDto<ProductDto>> call() throws Exception {
                PageRequest req = new PageRequest();
                req.setLimit(limit);
                req.setOffset(offset);
                req.setSearch(String.valueOf(attrId));
                return productService.listByAttr(req);
            }
        });
    }




    /**
     * 通过类型查询商品列表
     *
     * @param classId
     * @param limit
     * @return
     */
    @GET
    @Path("/goodsList/searchByClasses")
    public BaseResponse<PageViewDto<ProductDto>> listByClasses(@QueryParam("classId") final long classId,
                                                               @QueryParam("limit") @DefaultValue("10") final int limit,
                                                               @QueryParam("offset") @DefaultValue("0") final int offset) {
        return invoke("加载类别商品列表", new Callable<BaseResponse<PageViewDto<ProductDto>>>() {
            @Override
            public BaseResponse<PageViewDto<ProductDto>> call() throws Exception {
                PageRequest req = new PageRequest();
                req.setLimit(limit);
                req.setOffset(offset);
                req.setSearch(String.valueOf(classId));
                BaseAPIRequest<PageRequest> request = setupRequest(req, false);
                return productService.listByCategory(request);
            }
        });
    }

    /**
     * 获取单个商品信息
     *
     * @param productId
     * @return
     */
    @GET
    @Path("/goodsBasicInfo/search")
    public BaseResponse<ProductDto> getBasicDetail(@QueryParam("id") final Long productId) {
        return invoke("加载商品详情", new Callable<BaseResponse<ProductDto>>() {
            @Override
            public BaseResponse<ProductDto> call() throws Exception {
                BaseAPIRequest<Long> request = setupRequest(productId, false);
                return productService.getBasicDetail(request);
            }
        });
    }

    /**
     * 通过一组product id获取商品详情信息
     *
     * @param ids 商品id列表，逗号分割
     * @return
     */
    @GET
    @Path("/goodsBasicInfo/search/multiple")
    public BaseResponse<List<ProductDto>> getMultipuleGoodDetail(@NotNull @QueryParam("productIds") final String ids) {
        return invoke("加载商品详情", new Callable<BaseResponse<List<ProductDto>>>() {
            @Override
            public BaseResponse<List<ProductDto>> call() throws Exception {
                String[] idList = ids.split(",");
                BaseAPIRequest<String[]> request = setupRequest(idList, false);
                return productService.getMultipuleGoodDetail(request);
            }
        });
    }

    /**
     * 获取当前登录用户购物车详情
     *
     * @return
     */
    @GET
    @Path("/goodsList/searchByUser")
    public BaseResponse<CartDetailsDto> cartDetails() {
        return invoke("展示购物车商品列表", new Callable<BaseResponse<CartDetailsDto>>() {
            @Override
            public BaseResponse<CartDetailsDto> call() throws Exception {
                UserSession session = checkLogin();

                return cartService.details(session.getUser_id());
            }
        });
    }

    @GET
    @Path("/goodsList/searchByName")
    public BaseResponse<PageViewDto<ProductDto>> searchByName(@QueryParam("productName") final String productName) {
        return invoke("根据名字搜索商品", new Callable<BaseResponse<PageViewDto<ProductDto>>>() {
            @Override
            public BaseResponse<PageViewDto<ProductDto>> call() throws Exception {
                checkNotNull(productName, "商品名称为空");
                BaseAPIRequest<String> request = setupRequest(productName, false);
                return productService.searchByName(request);
            }
        });
    }

    @GET
    @Path("/goodsList/searchBySalesPropery")
    public BaseResponse<Long> searchBySalesPropery(
            @QueryParam("goodsId") final Long goodsId,
            @QueryParam("salesPropery") final String salesPropery,
            @QueryParam("merchantsCode") final String merchants_code) {
        return invoke("根据销售属性搜索商品", new Callable<BaseResponse<Long>>() {
            @Override
            public BaseResponse<Long> call() throws Exception {
                return productService.searchBySalesPropery(goodsId, salesPropery, merchants_code);
            }
        });
    }
}
