package org.lynn.soop.contract.product.dto;

import com.google.gson.annotations.SerializedName;
import org.lynn.soop.contract.dto.NamableDto;
import org.lynn.soop.entity.Product;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.lynn.soop.util.DataHelper.notSet;
import static org.lynn.soop.util.DataHelper.null2Empty;

import org.codehaus.jackson.annotate.JsonProperty;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import org.lynn.soop.contract.dto.NamableDto;
import org.lynn.soop.entity.Product;
import org.lynn.soop.entity.ProductAttribute;

/**
 * Created by chenwen on 4/22/16.
 */
public class ProductDto extends NamableDto {

    @JsonProperty("brandCN")
    @SerializedName("brandCN")
    @NotNull
    private String brandNameCN;
    @JsonProperty("brandEN")
    @SerializedName("brandEN")
    private String brandNameEN;
    private Long brandId;

    @NotNull
    private String categoryL1;
    @JsonProperty("classId")
    @SerializedName("classId")
    private Long categoryL1Id;

    @NotNull
    private String categoryL2;
    @JsonProperty("subClassId")
    @SerializedName("subClassId")
    private Long categoryL2Id;

    private String categoryL3;
    private Long categoryL3Id;

    private String sourceChannel;
    private String source;
    private Integer recommendIndex;

    private Boolean is_online;
    private String is_new;
    private Boolean is_hot;

    private String productImages;

    @JsonProperty("grossWeight")
    @SerializedName("grossWeight")
    private Integer productWeight;

    @JsonProperty("price")
    @SerializedName("price")
    private Integer productPrice;

    @JsonProperty("marketPrice")
    @SerializedName("marketPrice")
    private Integer overseasPrice;

    private Integer stockCount;

    @JsonProperty("subName")
    @SerializedName("subName")
    private String productSubName;

    private String specs;
    private String productAttr;

    private Boolean delivery_free;

    private int cartNumber;

    private String product_properties;
    
    private Long goods_id;
    
    private String productImagesList;

	public String getProductImagesList() {
		return productImagesList;
	}

	public void setProductImagesList(String productImagesList) {
		this.productImagesList = productImagesList;
	}

	public Boolean getIs_zero_interest() {
		return is_zero_interest;
	}

	public void setIs_zero_interest(Boolean is_zero_interest) {
		this.is_zero_interest = is_zero_interest;
	}

	public Boolean getIs_zero_downpayment() {
		return is_zero_downpayment;
	}

	public void setIs_zero_downpayment(Boolean is_zero_downpayment) {
		this.is_zero_downpayment = is_zero_downpayment;
	}

	private Boolean is_zero_interest;
    
    private Boolean is_zero_downpayment;

    public Long getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(Long goods_id) {
		this.goods_id = goods_id;
	}

	public String getProduct_properties(){
        return product_properties;
    }

    public void setProduct_properties(String product_properties){
        this.product_properties = product_properties;
    }


    public Boolean getDelivery_free() {
        return delivery_free;
    }

    public void setDelivery_free(Boolean delivery_free) {
        this.delivery_free = delivery_free;
    }

    public Map<String, String> specialProperties = new LinkedHashMap<String, String>();
    public List<String> images = new ArrayList<String>();
    public List<String> imagesMore = new ArrayList<String>();
    
    public List<SalesProperty> sales_property = new ArrayList<SalesProperty>();
    
    public static class PropertyInfo implements Serializable{
		private static final long serialVersionUID = 1L;
		public Long id;
		public String txt;
		public Long checked;
    	
    	public PropertyInfo(Long id, String txt, Long checked){
    		this.id = id;
    		this.txt = txt;
    		this.checked = checked;
    	}
    }
    
	public static class SalesProperty implements Serializable {
		private static final long serialVersionUID = 1L;
		public String name;
		public List<PropertyInfo> list;

		public SalesProperty(String name, List<PropertyInfo> list) {
			this.name = name;
			this.list = list;
		}
	}

    public boolean isRecommend;

    private int routine_id;

    public int getRoutine_id() {
        return routine_id;
    }

    public void setRoutine_id(int routine_id) {
        this.routine_id = routine_id;
    }


    public int getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(int cartNumber) {
        this.cartNumber = cartNumber;
    }

    /**
     * 货源地
     */
    public Supply supply;;
    /**
     * 产品售卖属性
     */
    public List<SellAttribute> sellAttributes = new ArrayList<SellAttribute>();

    public LogisticsLine logisticsLine;

    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public static ProductDto from(Product product) {
        ProductDto dto = new ProductDto();
        fromPO2DTO(product, dto);
        return dto;
    }


    public static class Supply {
        public long supplyId = 0;
        public String supplyName = "";
        public String delivery = "";
        public String tip;
        
        public Supply(long supplyId, String supplyName, String delivery, String tip) {
            this.supplyId = supplyId;
            this.supplyName = supplyName;
            this.delivery = delivery;
            this.tip = tip;
        }
    }

    public static class SellAttribute {
        public String tag;
        public String msg;

        public SellAttribute(String tag, String msg) {
            this.tag = tag;
            this.msg = msg;
        }


        public static final SellAttribute SELL_NEW = new SellAttribute("1", "当季新品");
        public static final SellAttribute SELL_HOT = new SellAttribute("2", "品牌热卖");
    }

    public static class LogisticsLine {
        public String tag = "";
        public String exp = "";   //todo test data

        public LogisticsLine(String tag, String exp) {
            this.tag = tag;
            this.exp = exp;
        }
    }


    public enum Attr {
        HOT      //热销
        , NEW   //新品
        ,NORMAL; // 正常

        public static Attr parse(String tag) {
            if (tag.equals("1")) {
                return NEW;
            } else if (tag.equals("2")) {
                return HOT;
            }
            throw new RuntimeException("tag not supported : " + tag);
        }
    }


    public static ProductDto toDto(Product po) {
        ProductDto dto = new ProductDto();
        fromPO2DTO(po, dto);
        return dto;
    }

    public static void fromPO2DTO(Product po, ProductDto dto) {
        dto.setId(po.getId());
        dto.setNameCN(po.getProduct_name_cn());
        dto.setNameEN(po.getProduct_name_en());
        dto.setBrandNameCN(po.getBrand_name_cn());
        dto.setBrandNameEN(po.getBrand_name_en());
        dto.setBrandId(po.getBrand_id());
        dto.setCategoryL1(po.getProduct_category_l1());
        dto.setCategoryL1Id(po.getProduct_category_l1_id());
        dto.setCategoryL2(po.getProduct_category_l2());
        dto.setCategoryL2Id(po.getProduct_category_l2_id());
        dto.setCategoryL3(po.getProduct_category_l3());
        dto.setCategoryL3Id(po.getProduct_category_id());
        dto.setSourceChannel(po.getSource_channel());
        dto.setSource(po.getSource());
        dto.setRecommendIndex(po.getRecommend_index());
        dto.setIs_online(po.getIs_online());
        dto.setIs_new(po.getIs_new());
        dto.setIs_hot(po.getIs_hot());
        dto.setProductImages(po.getProduct_images());
        dto.setProductImagesList(po.getProduct_image_list());
        dto.setProductWeight(po.getProduct_weight());
        if (!notSet(po.getPrice_on_sale())) {
            dto.setProductPrice(po.getPrice_on_sale());
        } else {
//            dto.setProductPrice(multiple(po.getProduct_price(), Contants.product.DEFAULT_PROFIT_RATE));
        }
        dto.setOverseasPrice(po.getOverseas_price());
        dto.setStockCount(po.getStock_count());
        dto.setProductSubName(null2Empty(po.getProduct_sub_name()));
        dto.setSpecs(po.getSpecs());
        dto.setProductAttr(po.getProduct_attr());
        dto.setProduct_properties(po.getProduct_properties());

        if (po.getRoutine_id() != null) {
            dto.setRoutine_id(po.getRoutine_id());
        }

        dto.setDelivery_free(po.getDelivery_free());
        dto.setIs_zero_downpayment(po.getIs_zero_downpayment());
        dto.setIs_zero_interest(po.getIs_zero_interest());
        dto.setGoods_id(po.getGoods_id());
        dto.setMerchants_code(po.getMerchants_code());
    }
    
    public static void evalProductFields(ProductDto p) {
		if (p.getProductAttr() != null) {
			try {
				List<ProductAttribute> attibutes = new Gson().fromJson(p.getProductAttr(),new TypeToken<List<ProductAttribute>>() {}.getType());
				p.specialProperties = new HashMap<String, String>();
				for (ProductAttribute attibute : attibutes) {
					p.specialProperties.put(attibute.getAttr_type(), attibute.getAttr_value());
				}
			} catch (RuntimeException e) {
			}
			p.setProductAttr("");
		}
        if (p.getProductImagesList() != null) {
            try {
                p.images = new Gson().fromJson(p.getProductImagesList(), new TypeToken<List<String>>() {
                }.getType());
            } catch (RuntimeException e) {
            }
        }
		if (p.getProductImages() != null) {
			try {
				p.imagesMore = new Gson().fromJson(p.getProductImages(), new TypeToken<List<String>>() {
				}.getType());
			} catch (RuntimeException e) {
			}
		}
        
        if (p.getIs_new() != null && p.getIs_new().equals("1")) {
            p.isRecommend = true;
            p.sellAttributes.add(ProductDto.SellAttribute.SELL_NEW);
        }
        if (p.getIs_hot() != null && p.getIs_hot()) {
            p.sellAttributes.add(ProductDto.SellAttribute.SELL_HOT);
        }
    }


    public String getBrandNameCN() {
        return brandNameCN;
    }

    public void setBrandNameCN(String brandNameCN) {
        this.brandNameCN = brandNameCN;
    }

    public String getBrandNameEN() {
        return brandNameEN;
    }

    public void setBrandNameEN(String brandNameEN) {
        this.brandNameEN = brandNameEN;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getCategoryL1() {
        return categoryL1;
    }

    public void setCategoryL1(String categoryL1) {
        this.categoryL1 = categoryL1;
    }

    public Long getCategoryL1Id() {
        return categoryL1Id;
    }

    public void setCategoryL1Id(Long categoryL1Id) {
        this.categoryL1Id = categoryL1Id;
    }

    public String getCategoryL2() {
        return categoryL2;
    }

    public void setCategoryL2(String categoryL2) {
        this.categoryL2 = categoryL2;
    }

    public Long getCategoryL2Id() {
        return categoryL2Id;
    }

    public void setCategoryL2Id(Long categoryL2Id) {
        this.categoryL2Id = categoryL2Id;
    }

    public String getCategoryL3() {
        return categoryL3;
    }

    public void setCategoryL3(String categoryL3) {
        this.categoryL3 = categoryL3;
    }

    public Long getCategoryL3Id() {
        return categoryL3Id;
    }

    public void setCategoryL3Id(Long categoryL3Id) {
        this.categoryL3Id = categoryL3Id;
    }

    public String getSourceChannel() {
        return sourceChannel;
    }

    public void setSourceChannel(String sourceChannel) {
        this.sourceChannel = sourceChannel;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getRecommendIndex() {
        return recommendIndex;
    }

    public void setRecommendIndex(Integer recommendIndex) {
        this.recommendIndex = recommendIndex;
    }

    public Boolean getIs_online() {
        return is_online;
    }

    public void setIs_online(Boolean is_online) {
        this.is_online = is_online;
    }

    public String getIs_new() {
        return is_new;
    }

    public void setIs_new(String is_new) {
        this.is_new = is_new;
    }

    public Boolean getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(Boolean is_hot) {
        this.is_hot = is_hot;
    }

    public String getProductImages() {
        return productImages;
    }

    public void setProductImages(String productImages) {
        this.productImages = productImages;
    }

    public Integer getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(Integer productWeight) {
        this.productWeight = productWeight;
    }

    public Integer getOverseasPrice() {
        return overseasPrice;
    }

    public void setOverseasPrice(Integer overseasPrice) {
        this.overseasPrice = overseasPrice;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public String getProductSubName() {
        return productSubName;
    }

    public void setProductSubName(String productSubName) {
        this.productSubName = productSubName;
    }

    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    public String getProductAttr() {
        return productAttr;
    }

    public void setProductAttr(String productAttr) {
        this.productAttr = productAttr;
    }


    // Mark 2017.1.12 返回租房标签

    public String getBuy_tip_text() {
        return buy_tip_text;
    }

    public void setBuy_tip_text(String buy_tip_text) {
        this.buy_tip_text = buy_tip_text;
    }

    public String getBuy_tip_flag() {
        return buy_tip_flag;
    }

    public void setBuy_tip_flag(String buy_tip_flag) {
        this.buy_tip_flag = buy_tip_flag;
    }

    public String getMerchants_code() {
        return merchants_code;
    }

    public void setMerchants_code(String merchants_code) {
        this.merchants_code = merchants_code;
    }
    /**
     * 购前提示文本
     */
    private String buy_tip_text;
    /**
     * 购前提示开关 0关闭  1开启
     */
    private String buy_tip_flag;

    /**
     * 商户号
     */
    private String merchants_code;
}
