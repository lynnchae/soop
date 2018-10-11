package org.lynn.soop.business.member;

import org.lynn.soop.business.BaseBusiness;
import org.lynn.soop.contract.member.dto.CartDetailsDto;
import org.lynn.soop.contract.member.dto.UsersooppingCartDto;
import org.lynn.soop.entity.Product;
import org.lynn.soop.entity.UsersooppingCart;
import org.lynn.soop.entity.UsersooppingCartExample;
import org.lynn.soop.repository.persistence.mybatis.handwrite.read.ProductReadMapper;
import org.lynn.soop.repository.persistence.mybatis.handwrite.read.UsersooppingCartReadMapper;
import org.lynn.soop.repository.persistence.mybatis.handwrite.write.UsersooppingCartWriteMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class CartBusiness extends BaseBusiness {

    @Resource
    private UsersooppingCartReadMapper usersooppingCartReadMapper;
    @Resource
    private UsersooppingCartWriteMapper usersooppingCartWriteMapper;
    @Resource
    private ProductReadMapper productReadMapper;


    public Long cudProduct(long userId, long productId, int unitPrice, boolean isDelete, int number, Boolean isAdd) {
        Product product = productReadMapper.selectByPrimaryKey(productId);
        if (product == null) {
            throw new RuntimeException("无效产品信息：" + productId);
        }
        UsersooppingCartExample e = new UsersooppingCartExample();
        UsersooppingCartExample.Criteria c = e.createCriteria();
        c.andUser_idEqualTo(userId);
        c.andProduct_idEqualTo(productId);

        if (isDelete) {
            usersooppingCartWriteMapper.deleteByExample(e);
            return null;
        }

        Long cartId;
        List<UsersooppingCart> list = usersooppingCartReadMapper.selectByExample(e);
        if (CollectionUtils.isEmpty(list)) {
            UsersooppingCart newOne = new UsersooppingCart();
            newOne.setUser_id(userId);
            newOne.setProduct_id(productId);
            newOne.setProduct_price(unitPrice);
            newOne.setQuantity(number);
            //newOne.setDate_expired();  //todo 购物车过期时间
            usersooppingCartWriteMapper.insert(newOne);
            cartId = newOne.getId();
        } else {
            Assert.isTrue(list.size() == 1);
            UsersooppingCart updateOne = list.get(0);
            /**
             * 增加模式
             */
            if (isAdd) {
                Integer quantity = updateOne.getQuantity();
                if (quantity == null) {
                    quantity = 0;
                }
                quantity += number;
                updateOne.setQuantity(quantity);
            } else {
                updateOne.setQuantity(number);
            }
            //newOne.setDate_expired();  //todo 购物车过期时间
            usersooppingCartWriteMapper.updateByPrimaryKey(updateOne);
            cartId = updateOne.getId();
        }
        return cartId;
    }

    public CartDetailsDto details(long userId) {
        UsersooppingCartExample e = new UsersooppingCartExample();
        UsersooppingCartExample.Criteria c = e.createCriteria();
        c.andUser_idEqualTo(userId);

        List<UsersooppingCart> poList = usersooppingCartReadMapper.selectByExample(e);

        Long totalAmountPaid = 0L;
        List<UsersooppingCartDto> dtoList = new ArrayList<UsersooppingCartDto>();
        if (!CollectionUtils.isEmpty(poList)) {
            for (UsersooppingCart cart : poList) {
                Product p = productReadMapper.selectByPrimaryKey(cart.getProduct_id());
                Assert.notNull(p);

                UsersooppingCartDto d = new UsersooppingCartDto();
                UsersooppingCartDto.fromPO2DTO(p, d);
                UsersooppingCartDto.evalProductFields(d);

                d.setQuantity(cart.getQuantity());

                totalAmountPaid += cart.getProduct_price();
                dtoList.add(d);
            }
        }

        CartDetailsDto dto = new CartDetailsDto();
        dto.setGoodsList(dtoList);
        dto.evalTotalInfo(totalAmountPaid);

        return dto;
    }

    public int detailsCount(long userId) {
        UsersooppingCartExample e = new UsersooppingCartExample();
        UsersooppingCartExample.Criteria c = e.createCriteria();
        c.andUser_idEqualTo(userId);

        int total = 0;
        List<UsersooppingCart> usersooppingCarts = usersooppingCartReadMapper.selectByExample(e);
        for (UsersooppingCart usersooppingCart : usersooppingCarts) {
            total += usersooppingCart.getQuantity();
        }
        return total;
    }

}
