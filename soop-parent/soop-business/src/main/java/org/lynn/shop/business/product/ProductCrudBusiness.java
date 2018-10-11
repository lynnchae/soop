package org.lynn.soop.business.product;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.lynn.framework.dto.ResponseEntity;
import org.lynn.merchants.api.dto.request.CreditConfDto;
import org.lynn.merchants.api.dubbo.DubboMerchantsBaseInfo;
import org.lynn.soop.business.BaseBusiness;
import org.lynn.soop.business.common.SysConfigBusiness;
import org.lynn.soop.business.goods.SalesPropertyBusiness;
import org.lynn.soop.business.goods.SalesPropertyValuesBusiness;
import org.lynn.soop.business.member.CartBusiness;
import org.lynn.soop.business.stock.StockOrderBusiness;
import org.lynn.soop.contract.BaseAPIRequest;
import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.BaseQueryRequest;
import org.lynn.soop.contract.dto.PageRequest;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.contract.exception.MyBizException;
import org.lynn.soop.contract.product.dto.CategoryQueryRequest;
import org.lynn.soop.contract.product.dto.ProductDto;
import org.lynn.soop.contract.product.dto.ProductDto.PropertyInfo;
import org.lynn.soop.contract.product.dto.ProductDto.Supply;
import org.lynn.soop.contract.product.dto.ProductRoutine;
import org.lynn.soop.entity.*;
import org.lynn.soop.entity.dto.ProductSalesPropertyAndValuesDto;
import org.lynn.soop.repository.persistence.mybatis.handwrite.read.*;
import org.lynn.soop.repository.persistence.mybatis.handwrite.write.*;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.lynn.soop.util.DataHelper.multiple;
import static org.lynn.soop.util.JsonHelper.toJSON;
import static org.lynn.soop.util.JsonHelper.toJSONWithNull;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

@Component
public class ProductCrudBusiness extends BaseBusiness {
    @Autowired
    SysConfigBusiness sysConfigBusiness;
    @Autowired
    private ProductBrandReadMapper productBrandReadMapper;
    @Autowired
    private ProductBrandWriteMapper productBrandWriteMapper;

    @Autowired
    private ProductSalesPropertyReadMapper productSalesPropertyReadMapper;

    @Autowired
    private ProductSalesPropertyWriteMapper productSalesPropertyWriteMapper;

    @Autowired
    private SalesPropertyValuesReadMapper salesPropertyValuesReadMapper;

    @Autowired
    private ProductCategoryReadMapper productCategoryReadMapper;
    @Autowired
    private ProductCategoryWriteMapper productCategoryWriteMapper;

    @Autowired
    private ProductAttributeReadMapper productAttributeReadMapper;
    @Autowired
    private ProductAttributeWriteMapper productAttributeWriteMapper;

    @Autowired
    private ProductReadMapper productReadMapper;
    @Autowired
    private ProductWriteMapper productWriteMapper;

    @Autowired
    private ProductPriceWriteMapper productPriceWriteMapper;
    @Autowired
    private ProductPriceReadMapper productPriceReadMapper;

    @Autowired
    private StockOrderBusiness stockOrderBusiness;

    @Autowired
    CartBusiness cartBusiness;
    
    @Autowired
    private SalesPropertyBusiness salesPropertyBusiness;
    @Autowired
    private SalesPropertyValuesBusiness salesPropertyValuesBusiness;
    @Autowired
    private ProductSalesPropertyBusiness productSalesPropertyBusiness;
    @Autowired
    private DubboMerchantsBaseInfo dubboMerchantsBaseInfo;




    public void evalProductFields(ProductDto p) {
		if (p.getProductAttr() != null) {
			try {
				List<ProductAttribute> attibutes = new Gson().fromJson(p.getProductAttr(),new TypeToken<List<ProductAttribute>>() {}.getType());
				p.specialProperties = new HashMap<String, String>();
				for (ProductAttribute attibute : attibutes) {
					p.specialProperties.put(attibute.getAttr_type(), attibute.getAttr_value());
				}
			} catch (RuntimeException e) {
				logger.error("parse JSON failed, from specialProperties: >>" + p.getProductAttr() + "<<", e);
			}
			p.setProductAttr("");
		}
        if (p.getProductImagesList() != null) {
            try {
                p.images = new Gson().fromJson(p.getProductImagesList(), new TypeToken<List<String>>() {
                }.getType());
            } catch (RuntimeException e) {
                logger.error("parse JSON failed, from images: >>" + p.getProductImagesList() + "<<", e);
            }
        }
		if (p.getProductImages() != null) {
			try {
				p.imagesMore = new Gson().fromJson(p.getProductImages(), new TypeToken<List<String>>() {
				}.getType());
			} catch (RuntimeException e) {
				logger.error("parse JSON failed, from images: >>" + p.getProductImages() + "<<", e);
			}
		}
        
        if (p.getIs_new() != null && "b'1'".equals(p.getIs_new())) {
            p.isRecommend = true;
            p.sellAttributes.add(ProductDto.SellAttribute.SELL_NEW);
        }
        if (p.getIs_hot() != null && p.getIs_hot()) {
            p.sellAttributes.add(ProductDto.SellAttribute.SELL_HOT);
        }

        //加载路线
        OrderDeliverRoutine odr = stockOrderBusiness.determineRoutine(p.getRoutine_id());
        if (odr != null) {
            p.logisticsLine = new ProductDto.LogisticsLine(odr.getId() + "", odr.getRoutine_name());
        }
        
        // 加载提示
        if (odr.getId() == ProductRoutine.A.getCode()) {
            String delivery = sysConfigBusiness.getConfig(SysConfigBusiness.DXT_MERCHANTS_DELIVERY, "");
            String tip = sysConfigBusiness.getConfig(SysConfigBusiness.DXT_MERCHANTS_TIP, "");
            p.supply = new Supply(odr.getId(), odr.getRoutine_name(), delivery, tip);
		} else if (odr.getId() == ProductRoutine.B.getCode()) {
			String delivery = sysConfigBusiness.getConfig(SysConfigBusiness.AHS_MERCHANTS_DELIVERY, "");
			String tip = sysConfigBusiness.getConfig(SysConfigBusiness.AHS_MERCHANTS_TIP, "");
			p.supply = new Supply(odr.getId(), odr.getRoutine_name(), delivery, tip);
		}else if (odr.getId() == ProductRoutine.C.getCode()) {
            String delivery = sysConfigBusiness.getConfig(SysConfigBusiness.LK_MERCHANTS_DELIVERY, "");
            String tip = sysConfigBusiness.getConfig(SysConfigBusiness.LK_MERCHANTS_TIP, "");
            p.supply = new Supply(odr.getId(), odr.getRoutine_name(), delivery, tip);
        }

        try {
            ResponseEntity<CreditConfDto> rsp = dubboMerchantsBaseInfo.getCreditConfByMerchantsCode(null, p.getMerchants_code());
            logger.info("dubboMerchantsBaseInfo.getCreditConfByMerchantsCode{}", rsp);
            if (rsp.getData() != null) {
                CreditConfDto confDto = (CreditConfDto) rsp.getData();
                p.setBuy_tip_flag(confDto.getBuyTipFlag().toString());
                p.setBuy_tip_text(confDto.getBuyTipText());
            } else {
                p.setBuy_tip_flag("0");
                p.setBuy_tip_text("");
            }
        } catch (Exception e) {
            logger.error("dubbo接口出错:", e);
            p.setBuy_tip_flag("0");
            p.setBuy_tip_text("");
        }
   }
    
    public void evalSalesProperty(ProductDto p){
		// 默认销售属性
        List<Long> defaultPropertyList = new ArrayList<Long>();
		List<ProductSalesPropertyAndValuesDto> ppropertyList = productSalesPropertyBusiness.listProductSalesProperty(p.getId()).getDataList();
		for (ProductSalesPropertyAndValuesDto valus : ppropertyList) {
			defaultPropertyList.add(valus.getSpv_id());
		}
		
		// 销售属性
		List<SalesProperty> salesPropertyList = salesPropertyBusiness.listSalesProperty(p.getGoods_id()).getDataList();
		for (SalesProperty sp : salesPropertyList) {
			Long spId = sp.getId() == null ? 0 : sp.getId();
			List<SalesPropertyValues> salesPropertyValuesList = salesPropertyValuesBusiness.listSalesPropertyValues(spId).getDataList();
			List<PropertyInfo> list = new ArrayList<PropertyInfo>();
			for (SalesPropertyValues spv : salesPropertyValuesList) {
				Long checked = 0L;
				if(defaultPropertyList.contains(spv.getId())){
					checked = 1L;
				} 
				ProductDto.PropertyInfo pf = new ProductDto.PropertyInfo(spv.getId(), spv.getSp_value(), checked);
				list.add(pf);
			}
			p.sales_property.add(new ProductDto.SalesProperty(sp.getSp_name(), list));
		}
    }

    public boolean save(ProductBrand pb) {
        int rows;
        if (pb.getId() == null) {
            rows = productBrandWriteMapper.insert(pb);
            logger.info(String.format("insert %s result: [%s]", ProductBrand.class.getSimpleName(), rows));
        } else {
            rows = productBrandWriteMapper.updateByPrimaryKey(pb);
            logger.info(String.format("update %s result: [%s]", ProductBrand.class.getSimpleName(), rows));
        }
        return rows == 1;
    }

    public boolean save(ProductCategory pc) {
        int rows;
        if (pc.getId() == null) {
            rows = productCategoryWriteMapper.insert(pc);
            logger.info(String.format("insert %s result: [%s]", ProductCategory.class.getSimpleName(), rows));
        } else {
            rows = productCategoryWriteMapper.updateByPrimaryKey(pc);
            logger.info(String.format("update %s result: [%s]", ProductCategory.class.getSimpleName(), rows));
        }
        return rows == 1;
    }

    public boolean save(ProductAttribute pa) {
        int rows;
        if (pa.getId() == null) {
            rows = productAttributeWriteMapper.insert(pa);
            logger.info(String.format("insert %s result: [%s]", ProductAttribute.class.getSimpleName(), rows));
        } else {
            rows = productAttributeWriteMapper.updateByPrimaryKey(pa);
            logger.info(String.format("update %s result: [%s]", ProductAttribute.class.getSimpleName(), rows));
        }
        return rows == 1;
    }

    public boolean save(Product p) {
        int rows;
        if (p.getId() == null) {
            rows = productWriteMapper.insert(p);
            logger.info(String.format("insert %s result: [%s]", Product.class.getSimpleName(), rows));
        } else {
            rows = productWriteMapper.updateByPrimaryKey(p);
            logger.info(String.format("update %s result: [%s]", Product.class.getSimpleName(), rows));
        }
        return rows == 1;
    }

    public boolean delete(long id, Class<?> type) {
        int rows;
        if (type == ProductBrand.class) {
            rows = productBrandWriteMapper.deleteByPrimaryKey(id);
        } else if (type == ProductCategory.class) {
            rows = productCategoryWriteMapper.deleteByPrimaryKey(id);
        } else if (type == ProductAttribute.class) {
            rows = productAttributeWriteMapper.deleteByPrimaryKey(id);
        } else if (type == Product.class) {
            rows = productWriteMapper.deleteByPrimaryKey(id);
        } else {
            throw new IllegalArgumentException("unsupported data type: [" + type + "]");
        }
        logger.info(String.format("delete %s with id[%s] result: [%s]", type.getSimpleName(), id, rows));
        return rows == 1;
    }


    public Map.Entry<Long, List<ProductBrand>> pageBrand(int pageIndex, int pageSize, String name) {
        ProductBrandExample example = new ProductBrandExample();
        example.setPageIndex(pageIndex);
        example.setPageCount(pageSize);
        example.setOrderByClause(" id asc ");
        if (name != null) {
            ProductBrandExample.Criteria c = example.createCriteria();
            c.andBrand_name_cnLike(buildLikeCause(name));
            ProductBrandExample.Criteria c2 = example.createCriteria();
            c2.andBrand_name_enLike(buildLikeCause(name));
            example.or(c2);
        }
        long totalRecordNumber = productBrandReadMapper.countByExample(example);
        List<ProductBrand> pageRecords = productBrandReadMapper.selectByExample(example);
        logger.info(String.format("pageBrand with pageIndex[%s] & pageSize[%s] result: [%s]", pageIndex, pageSize, totalRecordNumber));
        return new AbstractMap.SimpleEntry<Long, List<ProductBrand>>(totalRecordNumber, pageRecords);
    }

    public Map.Entry<Long, List<ProductCategory>> pageCategory(int pageIndex, int pageSize, Long parentId) {
        ProductCategoryExample example = new ProductCategoryExample();
        example.setPageIndex(pageIndex);
        example.setPageCount(pageSize);
        example.setOrderByClause(" id asc ");
        if (parentId != null) {
            example.createCriteria().andParent_category_idEqualTo(parentId);
        }
        long totalRecordNumber = productCategoryReadMapper.countByExample(example);
        List<ProductCategory> pageRecords = productCategoryReadMapper.selectByExample(example);
        logger.info(String.format("pageCategory with pageIndex[%s] & pageSize[%s] & parentId[%s] result: [%s]", pageIndex, pageSize, parentId, totalRecordNumber));
        return new AbstractMap.SimpleEntry<Long, List<ProductCategory>>(totalRecordNumber, pageRecords);
    }

    public Map.Entry<Long, List<ProductAttribute>> countAndListAttributes(long categoryId, boolean onlyCount) {
        ProductAttributeExample example = new ProductAttributeExample();
        example.setOrderByClause(" id asc ");
        ProductAttributeExample.Criteria c = example.createCriteria();
        c.andProduct_category_idEqualTo(categoryId);
        long totalRecordNumber = productAttributeReadMapper.countByExample(example);
        List<ProductAttribute> pageRecords = Collections.emptyList();
        if (onlyCount) {
            pageRecords = productAttributeReadMapper.selectByExample(example);
        }
        logger.info(String.format("countAndListAttributes with categoryId[%s] & onlyCount[%s] result: [%s]", categoryId, onlyCount, totalRecordNumber));
        return new AbstractMap.SimpleEntry<Long, List<ProductAttribute>>(totalRecordNumber, pageRecords);
    }

    public Map.Entry<Long, List<Product>> page(
            int pageIndex, int pageSize,
            String name, String source, String is_new, Boolean is_hot, Boolean is_online, Integer is_recommend
    ) {
        ProductExample example = new ProductExample();
        example.setPageIndex(pageIndex);
        example.setPageCount(pageSize);
        example.setOrderByClause(" is_new desc, is_hot desc, recommend_index desc, id asc ");
        ProductExample.Criteria c1 = example.createCriteria();
        ProductExample.Criteria c2 = example.createCriteria();
        if (source != null) {
            c1.andSourceLike(buildLikeCause(source));
            c2.andSourceLike(buildLikeCause(source));
        }
        if (is_new != null) {
            c1.andIs_newEqualTo(is_new);
            c2.andIs_newEqualTo(is_new);
        }
        if (is_hot != null) {
            c1.andIs_hotEqualTo(is_hot);
            c2.andIs_hotEqualTo(is_hot);
        }
        if (is_online != null) {
            c1.andIs_onlineEqualTo(is_online);
            c2.andIs_onlineEqualTo(is_online);
        }
        if (is_recommend != null) {
            c1.andRecommend_indexGreaterThanOrEqualTo(is_recommend);
            c2.andRecommend_indexGreaterThanOrEqualTo(is_recommend);
        }
        if (name != null) {
            c1.andProduct_name_cnLike(buildLikeCause(name));
            c2.andProduct_name_enLike(buildLikeCause(name));

            example.or(c2);
        }
        long totalRecordNumber = productReadMapper.countByExample(example);
        List<Product> pageRecords = productReadMapper.selectByExample(example);
        logger.info(String.format("page with pageIndex[%s] & pageSize[%s] result: [%s]", pageIndex, pageSize, totalRecordNumber));
        return new AbstractMap.SimpleEntry<Long, List<Product>>(totalRecordNumber, pageRecords);
    }

    /**
     * 保存商品品牌信息
     *
     * @param request
     * @return
     */
    public BaseResponse saveBrand(BaseRequest<ProductBrand> request) {
        BaseResponse toReturn = null;
        try {
            ProductBrand productBrand = request.getData();
            boolean createNew = productBrand.getId() == null;
            int result = 0;
            if (createNew) {
                result = productBrandWriteMapper.insertSelective(productBrand);
            } else {
                productBrand.setDate_updated(new Date());
                result = productBrandWriteMapper.updateByPrimaryKeySelective(productBrand);

                //同步更新商品表的品牌
                ProductExample productExample = new ProductExample();
                productExample.createCriteria().andBrand_idEqualTo(productBrand.getId());
                List<Product> products = productReadMapper.selectByExample(productExample);
                for (Product p : products) {
                    p.setBrand_name_cn(productBrand.getBrand_name_cn());
                    p.setBrand_name_en(productBrand.getBrand_name_en());
                    productWriteMapper.updateByPrimaryKey(p);
                }
            }

            if (result > 0) {
                toReturn = BaseResponse.buildSuccessResponse("ok");
            } else {
                logger.error(String.format("error in update product brand: [%s]", toJSON(request)));
                toReturn = BaseResponse.buildClientErrorResponse("更新品牌信息失败");
            }
        } catch (Exception e) {
            toReturn = BaseResponse.buildClientErrorResponse("更新品牌信息失败");
        }
        return toReturn;
    }

    /**
     * 查询返回商品品牌列表
     *
     * @param queryCondition
     * @return
     */
    public PageViewDto<ProductBrand> listBrand(BaseQueryRequest queryCondition) {
        ProductBrandExample productBrandExample = new ProductBrandExample();
        int totalCount = productBrandReadMapper.countByExample(productBrandExample);
        if(!StringUtils.isBlank(queryCondition.getPageRequest().getSearch())) {
            productBrandExample.createCriteria().andBrand_name_cnLike("%"+queryCondition.getPageRequest().getSearch()+"%");
        }
        PageRequest pageRequest = queryCondition.getPageRequest();
        productBrandExample.setPageCount(pageRequest.getLimit());
        productBrandExample.setPageIndex(pageRequest.getOffset() / pageRequest.getLimit() + 1);
        List<ProductBrand> result = productBrandReadMapper.selectByExample(productBrandExample);
        PageViewDto<ProductBrand> toReturn = new PageViewDto<ProductBrand>();
        toReturn.setDataList(result);
        toReturn.setTotalNumber(totalCount);
        return toReturn;
    }

    /**
     * 删除品牌信息
     *
     * @param removeRequest
     * @return
     */
    public BaseResponse batchRemoveBrand(BaseRequest<List<Long>> removeRequest) {
        BaseResponse toReturn = null;
        List<Long> ids = removeRequest.getData();
        //删除品牌之前判断有没有对应的商品 如果有 就不能删除
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andBrand_idIn(ids);
        List<Product> products = productReadMapper.selectByExample(productExample);
        if (CollectionUtils.isEmpty(products)) {
            ProductBrandExample example = new ProductBrandExample();
            ProductBrandExample.Criteria criteria = example.createCriteria();
            criteria.andIdIn(ids);
            int effectedRows = productBrandWriteMapper.deleteByExample(example);
            toReturn = BaseResponse.buildSuccessResponse("ok");
            if (effectedRows == 0) {
                logger.error(String.format("error in remove brand: [%s]", toJSON(ids)));
                toReturn = BaseResponse.buildClientErrorResponse("删除品牌信息失败");
            }
        } else {
            toReturn = BaseResponse.buildClientErrorResponse("品牌下有对应商品不能删除！");
        }
        return toReturn;
    }

    public BaseResponse updateCategory(BaseRequest<ProductCategory> request) {
        BaseResponse toReturn = null;
        try {
            ProductCategory productCategory = request.getData();
            boolean createNew = productCategory.getId() == null;
            int result;
            if (createNew) {
                result = productCategoryWriteMapper.insertSelective(productCategory);
            } else {
                //如果该类型是主类，设置parent_category_namew为category_name
                List<ProductCategory> list = productCategoryReadMapper.selectByParentId(productCategory.getId());

                if (!CollectionUtils.isEmpty(list)) {
                    Long parentId = productCategory.getId();
                    String parentCategoryName = productCategory.getCategory_name();
                    productCategoryWriteMapper.updateSubParentCatgoryName(parentId, parentCategoryName);
                }
                productCategory.setDate_updated(new Date());
                result = productCategoryWriteMapper.updateByPrimaryKeySelective(productCategory);


                //根据product_category_l1_id更新product表的product_category_l1 product_category_l1
                String categoryName = productCategory.getCategory_name();
                Long categoryId = productCategory.getId();

                ProductExample productExample = new ProductExample();
                productExample.createCriteria().andProduct_category_l1_idEqualTo(categoryId);
                List<Product> products = productReadMapper.selectByExample(productExample);
                for (Product p : products) {
                    p.setProduct_category_l1(categoryName);
                    productWriteMapper.updateByPrimaryKey(p);
                }

                productExample.createCriteria().andProduct_category_l2_idEqualTo(categoryId);
                List<Product> products2 = productReadMapper.selectByExample(productExample);
                for (Product p : products2) {
                    p.setProduct_category_l2(categoryName);
                    productWriteMapper.updateByPrimaryKey(p);
                }

            }
            if (result > 0) {
                toReturn = BaseResponse.buildSuccessResponse("ok");
            } else {
                logger.error(String.format("error in update product category: [%s]", toJSON(request)));
                toReturn = BaseResponse.buildClientErrorResponse("更新信息失败");
            }
        } catch (Exception e) {
            logger.error(String.format("error in update product category: [%s]", toJSON(request)));
            toReturn = BaseResponse.buildClientErrorResponse("更新信息失败");
        }
        return toReturn;
    }

    /**
     * 主类型
     *
     * @param queryCondition
     * @return
     */
    public PageViewDto<ProductCategory> listCategory(CategoryQueryRequest queryCondition) {
        ProductCategoryExample example = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = example.createCriteria();
        if (queryCondition.getMainCategoryId() == null) {
            criteria.andParent_category_idIsNull();
        } else {
            criteria.andParent_category_idEqualTo(queryCondition.getMainCategoryId());
        }

        if (!StringUtils.isBlank(queryCondition.getPageRequest().getSearch())) {
            criteria.andCategory_nameLike("%"+queryCondition.getPageRequest().getSearch()+"%");
        }

        int totalCount = productCategoryReadMapper.countByExample(example);

        PageRequest pageRequest = queryCondition.getPageRequest();
        example.setPageCount(pageRequest.getLimit());
        example.setPageIndex(pageRequest.getOffset() / pageRequest.getLimit() + 1);
        List<ProductCategory> result = productCategoryReadMapper.selectByExample(example);
        PageViewDto<ProductCategory> toReturn = new PageViewDto<ProductCategory>();
        toReturn.setDataList(result);
        toReturn.setTotalNumber(totalCount);
        return toReturn;
    }

    public BaseResponse batchRemoveCategory(BaseRequest<List<Long>> request) {
        BaseResponse toReturn = null;
        try {
            List<Long> ids = request.getData();


            ProductCategoryExample example = new ProductCategoryExample();
            ProductCategoryExample.Criteria criteria = example.createCriteria();
            //判断该类型下面是否有字类型
            criteria.andParent_category_idIn(ids);
            List<ProductCategory> productCategories = productCategoryReadMapper.selectByExample(example);
            if (!CollectionUtils.isEmpty(productCategories)) {
                toReturn = BaseResponse.buildClientErrorResponse("类型下存在子类 不能删除");
                return toReturn;
            }

            //删除商品类型之前判断和商品有没有关联关系
            ProductExample productExample = new ProductExample();
            productExample.createCriteria().andProduct_category_l1_idIn(ids);
            List<Product> products = productReadMapper.selectByExample(productExample);

            ProductExample productExample2 = new ProductExample();
            productExample2.createCriteria().andProduct_category_l2_idIn(ids);
            List<Product> products2 = productReadMapper.selectByExample(productExample2);

            if (CollectionUtils.isEmpty(products) && CollectionUtils.isEmpty(products2)) {
                ProductCategoryExample example2 = new ProductCategoryExample();
                ProductCategoryExample.Criteria criteria1 = example2.createCriteria();
                criteria1.andIdIn(ids);
                int effectedRows = productCategoryWriteMapper.deleteByExample(example2);
                toReturn = BaseResponse.buildSuccessResponse("ok");
                if (effectedRows == 0) {
                    logger.error(String.format("error in remove category: [%s]", toJSON(ids)));
                    toReturn = BaseResponse.buildClientErrorResponse("删除信息失败");
                }
            } else {
                toReturn = BaseResponse.buildClientErrorResponse("商品类型和商品有关联关系不能删除");
            }
        } catch (Exception e) {
            logger.debug(e.getMessage());
            toReturn = BaseResponse.buildClientErrorResponse("删除信息失败");
        }
        return toReturn;
    }

    public PageViewDto<ProductCategory> listSubCategory(BaseQueryRequest queryCondition) {
        ProductCategoryExample example = new ProductCategoryExample();

        if (!StringUtils.isBlank(queryCondition.getPageRequest().getSearch())) {
            example.createCriteria().andParent_category_idIsNotNull().andCategory_nameLike("%"+queryCondition.getPageRequest().getSearch()+"%");
        } else {
            example.createCriteria().andParent_category_idIsNotNull();
        }

        int totalCount = productCategoryReadMapper.countByExample(example);

        PageRequest pageRequest = queryCondition.getPageRequest();
        example.setPageCount(pageRequest.getLimit());
        example.setPageIndex(pageRequest.getOffset() / pageRequest.getLimit() + 1);
        List<ProductCategory> result = productCategoryReadMapper.selectByExample(example);
        PageViewDto<ProductCategory> toReturn = new PageViewDto<ProductCategory>();
        toReturn.setDataList(result);
        toReturn.setTotalNumber(totalCount);
        return toReturn;
    }

    public BaseResponse updateAttribute(BaseRequest<ProductAttribute> request) {
        ProductAttribute attribute = request.getData();
        boolean createNew = attribute.getId() == null;
        int result;
        if (createNew) {
            result = productAttributeWriteMapper.insertSelective(attribute);
        } else {
            attribute.setDate_updated(new Date());
            result = productAttributeWriteMapper.updateByPrimaryKeySelective(attribute);
        }
        BaseResponse toReturn;
        if (result > 0) {
            toReturn = BaseResponse.buildSuccessResponse("ok");
        } else {
            logger.error(String.format("error in update product attribute: [%s]", toJSON(request)));
            toReturn = BaseResponse.buildClientErrorResponse("更新信息失败");
        }
        //todo: sync product info
        return toReturn;
    }

    public PageViewDto<ProductAttribute> listCategoryAttribute(Long categoryId) {
        ProductAttributeExample example = new ProductAttributeExample();
        example.createCriteria().andProduct_category_idEqualTo(categoryId);
        List<ProductAttribute> attributeList = productAttributeReadMapper.selectByExample(example);
        PageViewDto<ProductAttribute> toReturn = new PageViewDto<ProductAttribute>();
        toReturn.setDataList(attributeList);
        toReturn.setTotalNumber(attributeList.size());
        return toReturn;
    }

    public BaseResponse removeAttribute(BaseRequest<Long> request) {
        Long attributeId = request.getData();
        int effectedRows = productAttributeWriteMapper.deleteByPrimaryKey(attributeId);
        BaseResponse toReturn = BaseResponse.buildSuccessResponse("ok");
        if (effectedRows == 0) {
            logger.error(String.format("error in remove attribute: [%s]", attributeId));
            toReturn = BaseResponse.buildClientErrorResponse("删除信息失败");
        }
        //todo: sync product info
        return toReturn;
    }


    public List<ProductDto> listProductByAttribute(ProductDto.Attr attr, int pageIndex, int pageCount) {
        ProductExample queryExample = new ProductExample();
        queryExample.setPageIndex(pageIndex);
        queryExample.setPageCount(pageCount);
        queryExample.setOrderByClause(" is_new desc, is_hot desc, recommend_index desc, id desc ");
        ProductExample.Criteria c = queryExample.createCriteria();
        c.andIs_onlineEqualTo(true);

        switch (attr) {
            case HOT: {
                c.andIs_hotEqualTo(true);
                break;
            }
            case NEW: {
                c.andIs_newEqualTo("b'1'");
                break;
            }
        }
        List<Product> poList = productReadMapper.selectByExample(queryExample);
        List<ProductDto> dtoList = new ArrayList<ProductDto>();
        if (poList != null) {
            for (Product po : poList) {
                ProductDto dto = ProductDto.toDto(po);
                evalProductFields(dto);
                dtoList.add(dto);
            }
        }
        return dtoList;
    }

    public List<ProductDto> listProductByCategoryL1Id(long categoryId, int pageIndex, int pageCount) {
        ProductExample queryExample = new ProductExample();
        queryExample.setPageIndex(pageIndex);
        queryExample.setPageCount(pageCount);
        queryExample.setOrderByClause(" is_new desc, is_hot desc, recommend_index desc, id desc ");

        ProductExample.Criteria c1 = queryExample.createCriteria();
        c1.andProduct_category_l1_idEqualTo(categoryId);
        c1.andIs_onlineEqualTo(true);

        List<Product> poList = productReadMapper.selectByExample(queryExample);
        List<ProductDto> dtoList = new ArrayList<ProductDto>();
        if (poList != null) {
            for (Product po : poList) {
                ProductDto dto = ProductDto.toDto(po);
                evalProductFields(dto);
                dtoList.add(dto);
            }
        }
        return dtoList;
    }

    public List<ProductDto> listProductByCategory(String categoryId, int pageIndex, int pageCount) {
        ProductExample queryExample = new ProductExample();
        queryExample.setPageIndex(pageIndex);
        queryExample.setPageCount(pageCount);
        queryExample.setOrderByClause(" is_new desc, is_hot desc, recommend_index desc, id asc ");

        ProductExample.Criteria c1 = queryExample.createCriteria();
        Long classId = Long.valueOf(categoryId);
        c1.andProduct_category_l1_idEqualTo(classId);
        c1.andIs_onlineEqualTo(true);

        List<Product> poList = productReadMapper.selectByExample(queryExample);
        List<ProductDto> dtoList = new ArrayList<ProductDto>();
        if (poList != null) {
            for (Product po : poList) {
                ProductDto dto = ProductDto.toDto(po);
                evalProductFields(dto);
                dtoList.add(dto);
            }
        }
        return dtoList;
    }

    @Transactional
    public BaseResponse updateProduct(BaseRequest<Product> request) {
        Product product = request.getData();
        boolean createNew = product.getId() == null;
        //sync brand info
        syncBrandInfo(product);
        //sync category attribute
       // syncCategoryAttribute(product);
        int result;
        if (createNew) {
            result = productWriteMapper.insertSelective(product);
        } else {
            product.setDate_updated(new Date());

            Product oldProduct = productReadMapper.selectByPrimaryKey(product.getId());
            //如果货品id发生变更，则删除原有的销售属性值
            if(product.getGoods_id() != null && oldProduct.getGoods_id() != null && oldProduct.getGoods_id() != product.getGoods_id()){
                ProductSalesPropertyExample productSalesPropertyExample = new ProductSalesPropertyExample();
                productSalesPropertyExample.createCriteria().andProduct_idEqualTo(product.getId());
                productSalesPropertyWriteMapper.deleteByExample(productSalesPropertyExample);
            }
            result = productWriteMapper.updateByPrimaryKeySelective(product);
        }
        BaseResponse toReturn;
        if (result > 0) {
            toReturn = BaseResponse.buildSuccessResponse("ok");
           /* ProductPrice productPrice;
            if (createNew) {//如果新增商品，同时新增商品价格记录
                productPrice = new ProductPrice();
                productPrice.setProduct_id(product.getId());
                productPrice.setProduct_name_cn(product.getProduct_name_cn());
            } else {
                ProductPriceExample example = new ProductPriceExample();
                example.createCriteria().andProduct_idEqualTo(product.getId());
                List<ProductPrice> productPrices = productPriceReadMapper.selectByExample(example);
                if (productPrices.size() == 1) {
                    productPrice = productPrices.get(0);
                } else {
                    throw new RuntimeException("商品价格和商品记录未一一对应");
                }
            }

            productPrice.setSource(product.getSource_channel());
            productPrice.setOverseas_price(product.getOverseas_price());
            productPrice.setProduct_price(product.getProduct_price());
            productPrice.setPrice_on_sale(product.getPrice_on_sale());*/
            /*if (!notSet(product.getPrice_on_sale())) {
                productPrice.setPrice_on_sale(product.getPrice_on_sale());
            } else {
                productPrice.setPrice_on_sale(multiple(product.getProduct_price(), sysConfigBusiness.getProfileRate()));
            }*/

           /* if (createNew) {
                result = productPriceWriteMapper.insert(productPrice);
            } else {
                productPrice.setDate_updated(new Date());
                result = productPriceWriteMapper.updateByPrimaryKeySelective(productPrice);
            }
            if (result != 1) {
                throw new RuntimeException("更新商品信息失败");
            }*/


        } else {
            logger.error(String.format("error in update product: [%s]", toJSON(request)));
            toReturn = BaseResponse.buildClientErrorResponse("更新信息失败");
        }
        return toReturn;
    }

    private void syncBrandInfo(Product product) {
//        checkNotNull(product.getBrand_id(), "品牌id不能为空");
        if (product.getBrand_id() == null) {
            logger.info("品牌id为空");
            return;
        }
        ProductBrand productBrand = productBrandReadMapper.selectByPrimaryKey(product.getBrand_id());
        checkNotNull(productBrand, "无效品牌id" + product.getBrand_id());
        product.setBrand_name_cn(productBrand.getBrand_name_cn());
        product.setBrand_name_en(productBrand.getBrand_name_en());
    }

    private void syncCategoryAttribute(Product product) {
//        if (product.getProduct_category_l1_id() == null) {
//            return;
//        }
//        ProductAttributeExample example = new ProductAttributeExample();
//        ArrayList<Long> ids = new ArrayList<Long>();
//        ids.add(product.getProduct_category_l1_id());
//        ids.add(product.getProduct_category_l2_id());
//        example.createCriteria().andProduct_category_idIn(ids);
//        List<ProductAttribute> attrList = productAttributeReadMapper.selectByExample(example);
//        String product_attr = toJSONWithNull(attrList);
//        product.setProduct_attr(product.getProduct_attr());
        product.setProduct_properties(product.getProduct_attr());
    }
    
    public List<Long> listProudctByGoodsId(Long goodsId, String merchants_code){
    	return productReadMapper.selectProductListByGoodsId(goodsId, merchants_code);
    }

    public PageViewDto<org.lynn.soop.entity.dto.ProductDto> listProduct(BaseQueryRequest queryCondition) {
        ProductExample example = new ProductExample();
        if (!StringUtils.isBlank(queryCondition.getPageRequest().getSearch()))  {
            //example.createCriteria().andProduct_name_cnLike("%"+queryCondition.getPageRequest().getSearch()+"%");
            example.setSearch("%"+queryCondition.getPageRequest().getSearch()+"%");
        } else {
            example.setSearch("%"+"%");
        }

        example.setOrderByClause("id asc");
        PageRequest pageRequest = queryCondition.getPageRequest();

        //int totalCount = productReadMapper.countByExample(example);

        example.setPageCount(pageRequest.getLimit());
        example.setPageIndex(pageRequest.getOffset() / pageRequest.getLimit() + 1);

        int pageStart = (example.getPageIndex() - 1)*example.getPageCount();
        example.setPageStart(pageStart);

        pageRequest.setOrder(" order by id asc ");
        PageViewDto<org.lynn.soop.entity.dto.ProductDto> toReturn = new PageViewDto<>();

        if (example!=null && example.getPageIndex()!=null && example.getPageCount() != null) {
            List<org.lynn.soop.entity.dto.ProductDto> result = productReadMapper.selectProductDtoExample(example);
            Integer count = productReadMapper.selectProductDtoExampleCount(example);
            toReturn.setDataList(result);
            toReturn.setTotalNumber(count);
        }
        return toReturn;
    }

    @Transactional
    public BaseResponse batchRemoveProduct(BaseRequest<List<Long>> request) {
        List<Long> ids = request.getData();
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        int effectedRows = productWriteMapper.deleteByExample(example);
        BaseResponse toReturn = BaseResponse.buildSuccessResponse("ok");
        if (effectedRows == 0) {
            logger.error(String.format("error in remove product: [%s]", toJSON(ids)));
            toReturn = BaseResponse.buildClientErrorResponse("删除信息失败");
        }
        ProductPriceExample productPriceExample = new ProductPriceExample();
        productPriceExample.createCriteria().andProduct_idIn(ids);
        productPriceWriteMapper.deleteByExample(productPriceExample);
        return toReturn;
    }

    public List<ProductBrand> listAllBrand() {
        return productBrandReadMapper.selectByExample(new ProductBrandExample());
    }

    public BaseResponse updateProductPrice(BaseRequest<ProductPrice> request) {
        ProductPrice price = request.getData();
        checkNotNull(price.getProduct_price(), "成本价格不能为空");
        if (price.getPrice_on_sale() == null) {
            price.setPrice_on_sale(multiple(price.getProduct_price(), sysConfigBusiness.getProfileRate()));
        }
        price.setDate_updated(new Date());
        int effectedRow = productPriceWriteMapper.updateByPrimaryKeySelective(price);
        BaseResponse toReturn = BaseResponse.buildSuccessResponse("ok");
        if (effectedRow == 0) {
            logger.error(String.format("error in update product price: [%s]", toJSON(request)));
            toReturn = BaseResponse.buildClientErrorResponse("更新信息失败");
        }
        price = productPriceReadMapper.selectByPrimaryKey(price.getId());
        //更新价格后同步产品
        Product product = new Product();
        product.setId(price.getProduct_id());
        product.setProduct_price(price.getProduct_price());
        product.setOverseas_price(price.getOverseas_price());
        product.setSource_channel(price.getSource());
        product.setPrice_on_sale(price.getPrice_on_sale());
        product.setDate_updated(new Date());
        productWriteMapper.updateByPrimaryKeySelective(product);
        return toReturn;
    }

    public PageViewDto<ProductPrice> listProductPrice(BaseQueryRequest queryCondition) {
        ProductPriceExample example = new ProductPriceExample();

        if (!StringUtils.isBlank(queryCondition.getPageRequest().getSearch())) {
            example.createCriteria().andProduct_name_cnLike("%"+queryCondition.getPageRequest().getSearch()+"%");
        }

        int totalCount = productPriceReadMapper.countByExample(example);

        PageRequest pageRequest = queryCondition.getPageRequest();
        example.setPageCount(pageRequest.getLimit());
        example.setPageIndex(pageRequest.getOffset() / pageRequest.getLimit() + 1);
        List<ProductPrice> result = productPriceReadMapper.selectByExample(example);
        PageViewDto<ProductPrice> toReturn = new PageViewDto<ProductPrice>();
        toReturn.setDataList(result);
        toReturn.setTotalNumber(totalCount);
        return toReturn;
    }

    @Transactional
    public BaseResponse batchUpload(BaseRequest<InputStream> request) {
        //parse excel file
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(request.getData());
            HSSFSheet sheet = workbook.getSheet("products");
            int lastRowNum = sheet.getLastRowNum();
            for (int i = 0; i < lastRowNum; i++) {
                HSSFRow row = sheet.getRow(i);
                Product product = new Product();
                product.setProduct_name_cn(row.getCell(0).getStringCellValue());
                product.setProduct_name_en(row.getCell(1).getStringCellValue());
                product.setBrand_name_cn(row.getCell(2).getStringCellValue());
                product.setBrand_name_en(row.getCell(3).getStringCellValue());
                //todo: add other row mapping
                productWriteMapper.insertSelective(product);
            }
        } catch (IOException e) {
            logger.error("error in batch upload", e);
        }
        //save data into db
        return null;
    }

    public ProductDto getById(BaseAPIRequest<Long> request) {
        Long productId=request.getData();
        Product po = productReadMapper.selectByPrimaryKey(productId);
        if (po == null) {
            logger.error("not found product with id: [" + productId + "]");
            throw new MyBizException(BaseResponse.buildClientErrorResponse("产品信息不存在!"));
        }
        if (!po.getIs_online()) {
            logger.error("product off_line with id: [" + productId + "]");
            throw new MyBizException(BaseResponse.buildClientErrorResponse("商品已下架!"));
        }
        ProductDto dto = ProductDto.toDto(po);
        evalProductFields(dto);
        evalSalesProperty(dto);

        if (request.getUser() != null) {
            int cnt = cartBusiness.detailsCount(request.getUser());
            dto.setCartNumber(cnt);
        }

        return dto;
    }

    public BaseResponse<List<ProductDto>> getMultipuleGoodDetail(BaseAPIRequest<String[]> request) {
        String[] ids = request.getData();
        List<Long> productIdList = new ArrayList<Long>();
        for (String id : ids) {
            productIdList.add(Long.parseLong(id));
        }
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andIdIn(productIdList);
        List<Product> poList = productReadMapper.selectByExample(productExample);

        List<ProductDto> dtoList = fromList(poList);
        return BaseResponse.buildSuccessResponse(dtoList);
    }


    public List<ProductDto> fromList(List<Product> poList) {
        List<ProductDto> dtoList = new ArrayList<ProductDto>();
        if (poList != null) {
            for (Product po : poList) {
                ProductDto dto = ProductDto.toDto(po);
                evalProductFields(dto);
                dtoList.add(dto);
            }
        }
        return dtoList;
    }

    /**
     * load all product and attribute settings
     * compare and sync to product
     *
     * @return
     */
    public BaseResponse syncProductAttribute(BaseRequest<List<Long>> request) {
        ProductAttributeExample example = new ProductAttributeExample();
        List<ProductAttribute> attrList = productAttributeReadMapper.selectByExample(example);
        Map<Long, List<ProductAttribute>> attrMap = new HashMap<Long, List<ProductAttribute>>();
        //把productAttribute根据product_category_id转换成Map, key是product_category_id, values是key对应的数据的集合
        for (ProductAttribute attr : attrList) {
            if (!attrMap.containsKey(attr.getProduct_category_id())) {
                attrMap.put(attr.getProduct_category_id(),new ArrayList<ProductAttribute>());
            }
                attrMap.get(attr.getProduct_category_id()).add(attr);
        }


        ProductExample productExample = new ProductExample();
        List<Long> ids = request.getData();
        /*if (!CollectionUtils.isEmpty(ids)) {
            productExample.createCriteria().andIdIn(ids);
        }*/
        productExample.createCriteria().andIdIn(ids);
        List<Product> products = productReadMapper.selectByExample(productExample);
        for (Product product : products) {
            try {
                logger.info("start to update product attribute" + product.getId());
                syncCategoryAttribute(product, attrMap);
                product.setDate_updated(new Date());
                productWriteMapper.updateByPrimaryKeySelective(product);
                logger.info("complete update product attribute:" + product.getId());
            } catch (Exception e) {
                logger.error("error in sync attribute for product:" + product.getId(), e);
            }
        }
        return BaseResponse.buildSuccessResponse("success");
    }


    private void syncCategoryAttribute(Product product, Map<Long, List<ProductAttribute>> attrMap) {
        //not sync if product category is not set
        if (product.getProduct_category_l1_id() == null || product.getProduct_category_l2_id() == null) {
            return;
        }
        //convert from list to map for easy element locate
        List<ProductAttribute> mainList = new ArrayList<ProductAttribute>();
        if (isNotEmpty(product.getProduct_attr())) {
            mainList = new Gson().fromJson(product.getProduct_attr(), new TypeToken<List<ProductAttribute>>() {
            }.getType());
        }
        List<ProductAttribute> newList = attrMap.get(product.getProduct_category_l1_id());
        if (newList == null) {
            newList = new ArrayList<ProductAttribute>();
        }
        List<ProductAttribute> subAttrList = attrMap.get(product.getProduct_category_l2_id());
        if (subAttrList == null) {
            subAttrList = new ArrayList<ProductAttribute>();
        }
        List tempList = new ArrayList(newList);
//        Collections.copy(tempList,newList);
        tempList.addAll(subAttrList);
        mergeAttrList(mainList, tempList);

        String product_attr = toJSONWithNull(tempList);
        product.setProduct_attr(product_attr);
        //product.setProduct_properties(product_attr);
    }

    /**
     * 将原来属性的值同步到新的属性列表中
     *
     * @param mainList
     * @param newList
     */
    private void mergeAttrList(List<ProductAttribute> mainList, List<ProductAttribute> newList) {
        Map<Long, ProductAttribute> mainListMap = new HashMap<Long, ProductAttribute>();
        for (ProductAttribute productAttribute : mainList) {
            mainListMap.put(productAttribute.getId(), productAttribute);
        }

        for (ProductAttribute productAttribute : newList) {
            if (mainListMap.containsKey(productAttribute.getId())) {
                ProductAttribute attribute = mainListMap.get(productAttribute.getId());
                productAttribute.setAttr_value(attribute.getAttr_value());
            }
        }
    }

    public List<ProductCategory> listMainCategory() {
        ProductCategoryExample pcExample = new ProductCategoryExample();
        pcExample.createCriteria().andParent_category_idIsNull();
        List<ProductCategory> list =  productCategoryReadMapper.selectByExample(pcExample);
        return list;
    }
}
