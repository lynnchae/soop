package org.lynn.soop.service.product;

import com.alibaba.dubbo.config.annotation.Service;
import org.lynn.soop.business.member.CartBusiness;
import org.lynn.soop.business.product.ProductCrudBusiness;
import org.lynn.soop.business.product.ProductSalesPropertyBusiness;
import org.lynn.soop.business.product.ProductTrxBusiness;
import org.lynn.soop.contract.BaseAPIRequest;
import org.lynn.soop.contract.BaseDto;
import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.BaseQueryRequest;
import org.lynn.soop.contract.dto.PageRequest;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.product.ProductServiceContact;
import org.lynn.soop.contract.product.dto.*;
import org.lynn.soop.entity.*;
import org.lynn.soop.entity.dto.ProductSalesPropertyAndValuesDto;
import org.lynn.soop.service.common.BaseService;
import org.lynn.soop.service.common.JsonDataRequestWrapper;
import org.lynn.soop.service.common.JsonExampleViewDtoWrapper;
import org.lynn.soop.util.ExceptionUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.io.InputStream;
import java.util.*;
import java.util.concurrent.Callable;

import static org.lynn.soop.util.JsonHelper.toJSON;

/**
 * Created by chenwen on 4/23/16.
 */
@Service
public class ProductService extends BaseService implements ProductServiceContact {

    @Autowired
    ProductCrudBusiness productCrudBusiness;
    @Autowired
    ProductTrxBusiness productTrxBusiness;
    @Autowired
    CartBusiness cartBusiness;

    @Autowired
    ProductSalesPropertyBusiness productSalesPropertyBusiness;


    public BaseResponse<Long> saveBrand(BaseRequest req) {
        JsonDataRequestWrapper dataReq = new JsonDataRequestWrapper(req, ProductBrandDto.class);
        ProductBrandDto dto = (ProductBrandDto) dataReq.getDataFromJson();

        Map<String, String> illegalArgs = dto.checkArgs();
        if (!CollectionUtils.isEmpty(illegalArgs)) {
            return BaseResponse.buildClientErrorResponse("illegalArgs: " + illegalArgs);
        }
        if (dto.getId() == null) {
            illegalArgs = dto.checkArgs(BaseDto.BasicUseCase.C.name());
        } else {
            illegalArgs = dto.checkArgs(BaseDto.BasicUseCase.U.name());
        }
        if (!CollectionUtils.isEmpty(illegalArgs)) {
            return BaseResponse.buildClientErrorResponse("illegalArgs: " + illegalArgs);
        }

        try {
            ProductBrand pb = ProductBrandDto.fromDto(dto);
            productCrudBusiness.save(pb);
            return BaseResponse.buildSuccessResponse(pb.getId());
        } catch (RuntimeException e) {
            logger.error("saveBrand() error: " + ExceptionUtil.getRootCause(e), e);
            return BaseResponse.buildServerErrorResponse(e.toString());
        }
    }

    public BaseResponse<Long> saveCategory(BaseRequest req) {
        JsonDataRequestWrapper dataReq = new JsonDataRequestWrapper(req, ProductCategoryDto.class);
        ProductCategoryDto dto = (ProductCategoryDto) dataReq.getDataFromJson();

        Map<String, String> illegalArgs = dto.checkArgs();
        if (!CollectionUtils.isEmpty(illegalArgs)) {
            return BaseResponse.buildClientErrorResponse("illegalArgs: " + illegalArgs);
        }
        if (dto.getId() == null) {
            illegalArgs = dto.checkArgs(BaseDto.BasicUseCase.C.name());
        } else {
            illegalArgs = dto.checkArgs(BaseDto.BasicUseCase.U.name());
        }
        if (!CollectionUtils.isEmpty(illegalArgs)) {
            return BaseResponse.buildClientErrorResponse("illegalArgs: " + illegalArgs);
        }

        try {
            ProductCategory pc = ProductCategoryDto.fromDto(dto);
            productCrudBusiness.save(pc);
            return BaseResponse.buildSuccessResponse(pc.getId());
        } catch (RuntimeException e) {
            logger.error("saveCategory() error: " + ExceptionUtil.getRootCause(e), e);
            return BaseResponse.buildServerErrorResponse(e.toString());
        }
    }

    public BaseResponse<Long> saveAttribute(BaseRequest req) {
        JsonDataRequestWrapper dataReq = new JsonDataRequestWrapper(req, ProductAttributeDto.class);
        ProductAttributeDto dto = (ProductAttributeDto) dataReq.getDataFromJson();

        Map<String, String> illegalArgs = dto.checkArgs();
        if (!CollectionUtils.isEmpty(illegalArgs)) {
            return BaseResponse.buildClientErrorResponse("illegalArgs: " + illegalArgs);
        }
        if (dto.getId() == null) {
            illegalArgs = dto.checkArgs(BaseDto.BasicUseCase.C.name());
        } else {
            illegalArgs = dto.checkArgs(BaseDto.BasicUseCase.U.name());
        }
        if (!CollectionUtils.isEmpty(illegalArgs)) {
            return BaseResponse.buildClientErrorResponse("illegalArgs: " + illegalArgs);
        }

        try {
            ProductAttribute pa = ProductAttributeDto.fromDto(dto);
            productCrudBusiness.save(pa);
            return BaseResponse.buildSuccessResponse(pa.getId());
        } catch (RuntimeException e) {
            logger.error("saveAttribute() error: " + ExceptionUtil.getRootCause(e), e);
            return BaseResponse.buildServerErrorResponse(e.toString());
        }
    }


    public BaseResponse<Long> deleteBrand(BaseRequest req) {
        JsonDataRequestWrapper dataReq = new JsonDataRequestWrapper(req, BaseDto.class);
        BaseDto dto = dataReq.getDataFromJson();
        try {
            boolean ok = productCrudBusiness.delete(dto.getId(), ProductBrand.class);
            if (ok) {
                return BaseResponse.buildSuccessResponse(dto.getId());
            } else {
                return BaseResponse.buildClientErrorResponse("maybe record not exists!");
            }
        } catch (RuntimeException e) {
            logger.error("deleteBrand() error: " + ExceptionUtil.getRootCause(e), e);
            return BaseResponse.buildServerErrorResponse(e.toString());
        }
    }

    public BaseResponse<Long> deleteCategory(BaseRequest req) {
        JsonDataRequestWrapper dataReq = new JsonDataRequestWrapper(req, BaseDto.class);
        BaseDto dto = dataReq.getDataFromJson();
        try {
            boolean ok = productCrudBusiness.delete(dto.getId(), ProductCategory.class);
            if (ok) {
                return BaseResponse.buildSuccessResponse(dto.getId());
            } else {
                return BaseResponse.buildClientErrorResponse("maybe record not exists!");
            }
        } catch (RuntimeException e) {
            logger.error("deleteCategory() error: " + ExceptionUtil.getRootCause(e), e);
            return BaseResponse.buildServerErrorResponse(e.toString());
        }
    }

    public BaseResponse<Long> deleteAttribute(BaseRequest req) {
        JsonDataRequestWrapper dataReq = new JsonDataRequestWrapper(req, BaseDto.class);
        BaseDto dto = dataReq.getDataFromJson();
        try {
            boolean ok = productCrudBusiness.delete(dto.getId(), ProductAttribute.class);
            if (ok) {
                return BaseResponse.buildSuccessResponse(dto.getId());
            } else {
                return BaseResponse.buildClientErrorResponse("maybe record not exists!");
            }
        } catch (RuntimeException e) {
            logger.error("deleteAttribute() error: " + ExceptionUtil.getRootCause(e), e);
            return BaseResponse.buildServerErrorResponse(e.toString());
        }
    }

    public BaseResponse<Long> delete(BaseRequest req) {
        JsonDataRequestWrapper dataReq = new JsonDataRequestWrapper(req, BaseDto.class);
        BaseDto dto = dataReq.getDataFromJson();
        try {
            boolean ok = productCrudBusiness.delete(dto.getId(), Product.class);
            if (ok) {
                return BaseResponse.buildSuccessResponse(dto.getId());
            } else {
                return BaseResponse.buildClientErrorResponse("maybe record not exists!");
            }
        } catch (RuntimeException e) {
            logger.error("delete() error: " + ExceptionUtil.getRootCause(e), e);
            return BaseResponse.buildServerErrorResponse(e.toString());
        }
    }


    public BaseResponse<PageViewDto<ProductBrandDto>> pageBrand(BaseRequest req) {
        JsonDataRequestWrapper dataReq = new JsonDataRequestWrapper(req, PageViewDto.class);
        PageViewDto<ProductBrandDto> dto = (PageViewDto) dataReq.getDataFromJson();

        String name = dto.getNameCN();
        if (StringUtils.isBlank(name)) {
            name = dto.getNameEN();
        }
        try {
            Map.Entry<Long, List<ProductBrand>> kv = productCrudBusiness.pageBrand(dto.getPageIndex(), dto.getPageSize(), name);
            long totalNumber = kv.getKey();
            dto.setTotalNumber(totalNumber);
            if (totalNumber < 1) {
                return BaseResponse.buildSuccessResponse(dto);
            }

            List<ProductBrandDto> voList = new ArrayList<ProductBrandDto>();
            for (ProductBrand po : kv.getValue()) {
                voList.add(ProductBrandDto.toDto(po));
            }
            dto.setDataList(voList);

            //todo 查询附加信息: 如,产品数据量
            return BaseResponse.buildSuccessResponse(dto);
        } catch (RuntimeException e) {
            logger.error("pageBrand() error: " + ExceptionUtil.getRootCause(e), e);
            return BaseResponse.buildServerErrorResponse(e.toString());
        }
    }

    public BaseResponse<PageViewDto<ProductCategoryDto>> pageCategory(BaseRequest req) {
        JsonDataRequestWrapper dataReq = new JsonDataRequestWrapper(req, PageViewDto.class);
        PageViewDto<ProductCategoryDto> dto = (PageViewDto) dataReq.getDataFromJson();
        JsonExampleViewDtoWrapper dtoWrapper = new JsonExampleViewDtoWrapper(dto, ProductCategoryDto.class);

        try {
            Long parentId = null;
            ProductCategoryDto example = (ProductCategoryDto) dtoWrapper.getExampleFromJson();
            if (example != null) {
                parentId = example.getParentId();
            }
            Map.Entry<Long, List<ProductCategory>> kv = productCrudBusiness.pageCategory(dto.getPageIndex(), dto.getPageSize(), parentId);
            long totalNumber = kv.getKey();
            dto.setTotalNumber(totalNumber);
            if (totalNumber < 1) {
                return BaseResponse.buildSuccessResponse(dto);
            }

            List<ProductCategoryDto> voList = new ArrayList<ProductCategoryDto>();
            for (ProductCategory po : kv.getValue()) {
                voList.add(ProductCategoryDto.toDto(po));
            }
            dto.setDataList(voList);

            //todo 查询附加信息: 如,产品数据量
            return BaseResponse.buildSuccessResponse(dto);
        } catch (RuntimeException e) {
            logger.error("pageCategory() error: " + ExceptionUtil.getRootCause(e), e);
            return BaseResponse.buildServerErrorResponse(e.toString());
        }
    }

    public BaseResponse<PageViewDto<ProductAttributeDto>> listAttributesOfCategory(BaseRequest req) {
        JsonDataRequestWrapper dataReq = new JsonDataRequestWrapper(req, PageViewDto.class);
        PageViewDto<ProductAttributeDto> dto = (PageViewDto) dataReq.getDataFromJson();
        JsonExampleViewDtoWrapper dtoWrapper = new JsonExampleViewDtoWrapper(dto, ProductCategoryDto.class);

        try {
            ProductAttributeDto example = (ProductAttributeDto) dtoWrapper.getExampleFromJson();
            if (example == null || example.getProductCategoryId() == null) {
                BaseResponse.buildClientErrorResponse("missing condition: 'exampleDto.categoryId'!");
            }
            Map.Entry<Long, List<ProductAttribute>> kv = productCrudBusiness.countAndListAttributes(example.getProductCategoryId(), false);
            long totalNumber = kv.getKey();
            dto.setTotalNumber(totalNumber);
            if (totalNumber < 1) {
                return BaseResponse.buildSuccessResponse(dto);
            }

            List<ProductAttributeDto> voList = new ArrayList<ProductAttributeDto>();
            for (ProductAttribute po : kv.getValue()) {
                voList.add(ProductAttributeDto.toDto(po));
            }
            dto.setDataList(voList);

            return BaseResponse.buildSuccessResponse(dto);
        } catch (RuntimeException e) {
            logger.error("listAttributesOfCategory() error: " + ExceptionUtil.getRootCause(e), e);
            return BaseResponse.buildServerErrorResponse(e.toString());
        }
    }

    public BaseResponse<PageViewDto<ProductDto>> page(BaseRequest req) {
        JsonDataRequestWrapper dataReq = new JsonDataRequestWrapper(req, PageViewDto.class);
        PageViewDto<ProductDto> dto = (PageViewDto) dataReq.getDataFromJson();
        JsonExampleViewDtoWrapper dtoWrapper = new JsonExampleViewDtoWrapper(dto, ProductDto.class);

        String name = dto.getNameCN();
        if (StringUtils.isBlank(name)) {
            name = dto.getNameEN();
        }
        try {
            ProductDto example = (ProductDto) dtoWrapper.getExampleFromJson();
            if (example == null) {
                example = new ProductDto();
            } else if (StringUtils.isBlank(name)) {
                name = example.getNameCN();
                if (StringUtils.isBlank(name)) {
                    name = example.getNameEN();
                }
            }
            Map.Entry<Long, List<Product>> kv = productCrudBusiness.page(
                    dto.getPageIndex(), dto.getPageSize(),
                    name, example.getSource(), example.getIs_new(), example.getIs_hot(), example.getIs_online(), example.getRecommendIndex()
            );
            long totalNumber = kv.getKey();
            dto.setTotalNumber(totalNumber);
            if (totalNumber < 1) {
                return BaseResponse.buildSuccessResponse(dto);
            }

            List<ProductDto> voList = new ArrayList<ProductDto>();
            for (Product po : kv.getValue()) {
                voList.add(ProductDto.toDto(po));
            }
            dto.setDataList(voList);

            return BaseResponse.buildSuccessResponse(dto);
        } catch (RuntimeException e) {
            logger.error("page() error: " + ExceptionUtil.getRootCause(e), e);
            return BaseResponse.buildServerErrorResponse(e.toString());
        }
    }

    public BaseResponse updateBrand(BaseRequest<ProductBrand> request) {
        return productCrudBusiness.saveBrand(request);
    }

    /**
     * 分页返回品牌数据
     *
     * @param queryCondition
     * @return
     */
    public PageViewDto<ProductBrand> listBrand(BaseQueryRequest queryCondition) {
        return productCrudBusiness.listBrand(queryCondition);
    }

    public BaseResponse batchRemoveBrand(BaseRequest<List<Long>> removeRequest) {
        return productCrudBusiness.batchRemoveBrand(removeRequest);
    }

    public BaseResponse updateCategory(BaseRequest<ProductCategory> request) {
        return productCrudBusiness.updateCategory(request);
    }

    public PageViewDto<ProductCategory> listCategory(CategoryQueryRequest queryCondition) {
        return productCrudBusiness.listCategory(queryCondition);
    }

    public BaseResponse batchRemoveCategory(BaseRequest<List<Long>> request) {
        return productCrudBusiness.batchRemoveCategory(request);
    }

    public PageViewDto<ProductCategory> listSubCategory(BaseQueryRequest queryCondition) {
        return productCrudBusiness.listSubCategory(queryCondition);
    }

    public BaseResponse updateAttribute(BaseRequest<ProductAttribute> request) {
        return productCrudBusiness.updateAttribute(request);
    }

    public PageViewDto<ProductAttribute> listCategoryAttribute(Long categoryId) {
        return productCrudBusiness.listCategoryAttribute(categoryId);
    }

    public BaseResponse removeAttribute(BaseRequest<Long> request) {
        return productCrudBusiness.removeAttribute(request);
    }


    public BaseResponse<HomePageResponseDTO> indexView(final BaseAPIRequest<IndexHomeReqDto> req) {
        return service("加载首页", new Callable<HomePageResponseDTO>() {
             
            public HomePageResponseDTO call() throws Exception {
                HomePageResponseDTO resp = new HomePageResponseDTO();
                int limit = req.getData().getLimit();
                {
                    ProductDto.Attr attr = ProductDto.Attr.HOT;
                    List<ProductDto> dtoList = productCrudBusiness.listProductByAttribute(attr, 1, limit);
                    resp.setRecommend(dtoList);
                }

                List<ProductDto> productList = productCrudBusiness.listProductByAttribute(ProductDto.Attr.NORMAL, 1, limit);
                resp.setProductList(productList);

                /*for (Map.Entry<String, String> kv : req.getData().getCategoryNameIdMap().entrySet()) {
                    List<ProductDto> dtoList = productCrudBusiness.listProductByCategoryL1Id(Long.parseLong(kv.getValue()), 1, limit);
                    resp.addCategory(kv.getKey(), dtoList);
                }*/

                if (req.getUser() != null) {
                    int cnt = cartBusiness.detailsCount(req.getUser());
                    resp.setCartNumber(cnt);
                }

                return resp;
            }
        });
    }

     
    public BaseResponse<PageViewDto<ProductDto>> listByAttr(PageRequest req) {
        ProductDto.Attr attr = ProductDto.Attr.parse(req.getSearch());
        int pageCount = req.getLimit();
        int pageIndex = req.getOffset() / pageCount + 1;

        List<ProductDto> dtoList = productCrudBusiness.listProductByAttribute(attr, pageIndex, pageCount);

        PageViewDto<ProductDto> respDto = new PageViewDto<ProductDto>();
        respDto.setPageSize(pageCount);
        respDto.setPageIndex(pageIndex);
        respDto.setDataList(dtoList);

        return BaseResponse.buildSuccessResponse(respDto);
    }

     
    public BaseResponse<PageViewDto<ProductDto>> listByCategory(BaseAPIRequest<PageRequest> request) {
        PageRequest req = request.getData();
        String categoryId = req.getSearch();
        int pageCount = req.getLimit();
        int pageIndex = req.getOffset() / pageCount + 1;

        List<ProductDto> dtoList = productCrudBusiness.listProductByCategory(categoryId, pageIndex, pageCount);

        PageViewDto<ProductDto> respDto = new PageViewDto<ProductDto>();
        respDto.setPageSize(pageCount);
        respDto.setPageIndex(pageIndex);
        respDto.setDataList(dtoList);

        return BaseResponse.buildSuccessResponse(respDto);
    }

     
    public BaseResponse<ProductDto> getBasicDetail(final BaseAPIRequest<Long> request) {
        return service("加载商品基本信息", new Callable<ProductDto>() {
             
            public ProductDto call() throws Exception {
                ProductDto dto = productCrudBusiness.getById(request);
                return dto;
            }
        });
    }

     
    public BaseResponse updateProduct(BaseRequest<Product> request) {
        return productCrudBusiness.updateProduct(request);
    }

     
    public PageViewDto<org.lynn.soop.entity.dto.ProductDto> listProduct(BaseQueryRequest queryCondition) {
        return productCrudBusiness.listProduct(queryCondition);
    }

     
    public BaseResponse batchRemoveProduct(BaseRequest<List<Long>> request) {
        return productCrudBusiness.batchRemoveProduct(request);
    }

     
    public List<ProductBrand> listAllBrand() {
        return productCrudBusiness.listAllBrand();
    }

     
    public BaseResponse updateProductPrice(BaseRequest<ProductPrice> request) {
        return productCrudBusiness.updateProductPrice(request);
    }

     
    public PageViewDto<ProductPrice> listProductPrice(BaseQueryRequest queryCondition) {
        return productCrudBusiness.listProductPrice(queryCondition);
    }

     
    public BaseResponse batchUpload(BaseRequest<InputStream> request) {
        return productCrudBusiness.batchUpload(request);
    }

     
    public BaseResponse<PageViewDto<ProductDto>> searchByName(final BaseAPIRequest<String> request) {
        return service("根据名字搜索商品", new Callable<PageViewDto<ProductDto>>() {
             
            public PageViewDto<ProductDto> call() throws Exception {
                String name = request.getData();
                int pageSize = 100;
                int pageIndex = 1;

                boolean is_online = true;
                Map.Entry<Long, List<Product>> kv = productCrudBusiness.page(pageIndex, pageSize, name, null, null, null, is_online, null);
                PageViewDto<ProductDto> pageViewDto = new PageViewDto<ProductDto>();
                pageViewDto.setPageIndex(pageIndex);
                pageViewDto.setPageSize(pageSize);
                pageViewDto.setTotalNumber(kv.getKey());
                if (kv.getKey() > 0) {
                    List<ProductDto> list = new ArrayList<ProductDto>();
                    for (Product po : kv.getValue()) {
                        ProductDto dto = new ProductDto();
                        ProductDto.fromPO2DTO(po, dto);

                        list.add(dto);
                    }
                    pageViewDto.setDataList(list);
                }
                return pageViewDto;
            }
        });
    }
    
	public BaseResponse<Long> searchBySalesPropery(Long goodsId, String salesPropery, String merchants_code) {
		List<Long> productIdList = productCrudBusiness.listProudctByGoodsId(goodsId, merchants_code);

		for (Long productId : productIdList) {
			List<ProductSalesPropertyAndValuesDto> psList = productSalesPropertyBusiness.listProductSalesProperty(
					productId).getDataList();
			Set<Long> spSet = new TreeSet<Long>();
			for (ProductSalesPropertyAndValuesDto pspd : psList) {
				spSet.add(pspd.getSpv_id());
			}
			String[] propertys = salesPropery.split(",");
			Set<Long> targetSet = new TreeSet<Long>();
			for (String String : propertys) {
				targetSet.add(Long.valueOf(String));
			}
			if (spSet.toString().equals(targetSet.toString())) {
				return BaseResponse.buildSuccessResponse(productId);
			}
		}
		return BaseResponse.buildClientErrorResponse("库存不足!");
	}

    /**
     * 加载首页数据
     *
     * @param request
     * @return
     */
     
    public BaseResponse<HomePageResponseDTO> loadIndexPageData(BaseAPIRequest<IndexViewReqDto> request) {
        Long userId = request.getUser();
        IndexViewReqDto requestData = request.getData();
        HomePageResponseDTO toReturn = new HomePageResponseDTO();

        if (userId != null) {
            //set cart number
        } else {
            toReturn.setCartNumber(0);
        }
        //load recommend product
        toReturn.setRecommend(new ArrayList<ProductDto>());

        //load category product
        Map<String, String> categoryNameIdMap = requestData.getCategoryNameIdMap();
        for (Map.Entry<String, String> entry : categoryNameIdMap.entrySet()) {
            String categoryName = entry.getKey();
            String categoryId = entry.getValue();
            //load top product bty category id
            //toReturn.put(categoryName, productDto)
        }

        BaseResponse<HomePageResponseDTO> homePageResponseDTOBaseResponse = BaseResponse.buildSuccessResponse(toReturn);
        logger.info("inner data is:" + toJSON(toReturn));
        logger.info("response is:" + toJSON(homePageResponseDTOBaseResponse));
        return homePageResponseDTOBaseResponse;
    }

     
    public BaseResponse<List<ProductDto>> getMultipuleGoodDetail(BaseAPIRequest<String[]> request) {
        return productCrudBusiness.getMultipuleGoodDetail(request);

    }

     
    public BaseResponse syncProductAttribute(BaseRequest<List<Long>> request) {
        return productCrudBusiness.syncProductAttribute(request);
    }

    @Override
    public BaseResponse updateProductAndSp(BaseRequest<Product> request, Map<Long, String> spList) {
        return productSalesPropertyBusiness.updateProductAndSp(request,spList);
    }

    @Override
    public List<ProductCategory> listMainCategory() {
        return productCrudBusiness.listMainCategory();
    }

}
