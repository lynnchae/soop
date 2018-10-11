package org.lynn.soop.contract.product.dto;


import org.lynn.soop.contract.dto.NamableDto;
import org.lynn.soop.entity.ProductBrand;

/**
 * Created by chenwen on 4/22/16.
 */
public class ProductBrandDto extends NamableDto {

    /* ***************** DB field list *************** */
    // nothing

    /* ***************** page show list *************** */
    private long countOfCategory;
    private long countOfProduct;


    public static ProductBrand fromDto(ProductBrandDto dto) {
        ProductBrand po = new ProductBrand();
        po.setId(dto.getId());
        po.setBrand_name_cn(dto.getNameCN());
        po.setBrand_name_en(dto.getNameEN());
        return po;
    }

    public static ProductBrandDto toDto(ProductBrand po) {
        ProductBrandDto dto = new ProductBrandDto();
        dto.setId(po.getId());
        dto.setNameCN(po.getBrand_name_cn());
        dto.setNameEN(po.getBrand_name_en());
        return dto;
    }


    public long getCountOfCategory() {
        return countOfCategory;
    }

    public void setCountOfCategory(long countOfCategory) {
        this.countOfCategory = countOfCategory;
    }

    public long getCountOfProduct() {
        return countOfProduct;
    }

    public void setCountOfProduct(long countOfProduct) {
        this.countOfProduct = countOfProduct;
    }
}
