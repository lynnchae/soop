package org.lynn.soop.contract.product.dto;


import org.lynn.soop.contract.BaseDto;

import java.util.List;

/**
 * Created by chenwen on 5/03/16.
 */
public class IndexGoodsRespDto extends BaseDto {

    /** 热门商品 */
    private List<ProductDto> recommend;

    /** 营养保健类商品 */
    private List<ProductDto> health;

    /** 母婴用品类商品 */
    private List<ProductDto> maternal;

    /** 时尚美妆类商品 */
    private List<ProductDto> fashion;

    /** 购物车商品数量, 如果用户未登陆，值为0 */
    private int cartNumber;


    public List<ProductDto> getRecommend() {
        return recommend;
    }

    public void setRecommend(List<ProductDto> recommend) {
        this.recommend = recommend;
    }

    public List<ProductDto> getHealth() {
        return health;
    }

    public void setHealth(List<ProductDto> health) {
        this.health = health;
    }

    public List<ProductDto> getMaternal() {
        return maternal;
    }

    public void setMaternal(List<ProductDto> maternal) {
        this.maternal = maternal;
    }

    public List<ProductDto> getFashion() {
        return fashion;
    }

    public void setFashion(List<ProductDto> fashion) {
        this.fashion = fashion;
    }

    public int getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(int cartNumber) {
        this.cartNumber = cartNumber;
    }


    //todo 配置
    /** 营养保健类ID */
    public static long healthCategoryId = 1;
    /** 母婴用品类ID */
    public static long maternalCategoryId = 1;
    /** 时尚美妆类ID */
    public static long fashionCategoryId = 1;

}
