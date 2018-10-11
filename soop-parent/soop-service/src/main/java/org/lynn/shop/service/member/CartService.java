package org.lynn.soop.service.member;

import com.alibaba.dubbo.config.annotation.Service;
import org.lynn.soop.business.member.CartBusiness;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.member.CartServiceContact;
import org.lynn.soop.contract.member.dto.CartDetailsDto;
import org.lynn.soop.service.common.BaseService;

import javax.annotation.Resource;
import java.util.concurrent.Callable;

/**
 * Created by chenwen on 5/05/16.
 */
@Service
public class CartService extends BaseService implements CartServiceContact {

    @Resource
    private CartBusiness cartBusiness;


     
    public BaseResponse<Long> cudProduct(
            final long userId, final long productId, final int unitPrice,
            final boolean isDelete, final int number, final Boolean isAdd) {

        return service("更新购物车", new Callable<Long>() {
             
            public Long call() throws Exception {
                return cartBusiness.cudProduct(userId, productId, unitPrice, isDelete, number, isAdd);
            }
        });
    }

     
    public BaseResponse<CartDetailsDto> details(final long userId) {
        return service("加载购物车", new Callable<CartDetailsDto>() {
             
            public CartDetailsDto call() throws Exception {
                return cartBusiness.details(userId);
            }
        });
    }
}
