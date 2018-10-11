package org.lynn.soop.contract.product.dto;


import org.lynn.soop.contract.BaseDto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HomePageResponseDTO extends BaseDto {
    private List<ProductDto> recommend;
    private int cartNumber;
    private Map<String, List<ProductDto>> categoryMap = new LinkedHashMap<String, List<ProductDto>>();
    private List<ProductDto> productList;

    public List<ProductDto> getRecommend() {
        return recommend;
    }

    public void setRecommend(List<ProductDto> recommend) {
        this.recommend = recommend;
    }

    public int getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(int cartNumber) {
        this.cartNumber = cartNumber;
    }

    public Map<String, List<ProductDto>> getCategoryMap() {
        return categoryMap;
    }

    public void addCategory(String categoryName, List<ProductDto> goodsList) {
        this.categoryMap.put(categoryName, goodsList);
    }

    public void setProductList(List<ProductDto> productList){
        this.productList = productList;
    }

    public List<ProductDto> getProductList(){
        return productList;
    }
}
