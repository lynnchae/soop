package org.lynn.soop.contract.product.dto;


import org.lynn.soop.contract.dto.NamableDto;
import org.lynn.soop.entity.ProductCategory;

/**
 * Created by chenwen on 4/22/16.
 */
public class ProductCategoryDto extends NamableDto {

    /* ***************** DB field list *************** */
    private String description;
    private Integer duties;     //TODO 税? 表结构还没有这个字段!
    private Long parentId;

    /* ***************** page show list *************** */
    private long countOfProduct;


    public static ProductCategory fromDto(ProductCategoryDto dto) {
        ProductCategory po = new ProductCategory();
        po.setId(dto.getId());
        po.setCategory_name(dto.getNameCN());
        po.setDescription(dto.getDescription());
        po.setDuties(dto.getDuties());
        po.setParent_category_id(dto.getParentId());
        return po;
    }

    public static ProductCategoryDto toDto(ProductCategory po) {
        ProductCategoryDto dto = new ProductCategoryDto();
        dto.setId(po.getId());
        dto.setNameCN(po.getCategory_name());
        dto.setDescription(po.getDescription());
        dto.setDuties(po.getDuties());
        dto.setParentId(po.getParent_category_id());
        return dto;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getDuties() {
        return duties;
    }

    public void setDuties(Integer duties) {
        this.duties = duties;
    }

    public long getCountOfProduct() {
        return countOfProduct;
    }

    public void setCountOfProduct(long countOfProduct) {
        this.countOfProduct = countOfProduct;
    }
}
