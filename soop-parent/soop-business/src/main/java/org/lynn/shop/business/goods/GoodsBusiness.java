package org.lynn.soop.business.goods;

import org.lynn.soop.business.BaseBusiness;
import org.lynn.soop.contract.BaseRequest;
import org.lynn.soop.contract.BaseResponse;
import org.lynn.soop.contract.dto.BaseQueryRequest;
import org.lynn.soop.contract.dto.PageRequest;
import org.lynn.soop.contract.dto.PageViewDto;
import org.lynn.soop.entity.Goods;
import org.lynn.soop.entity.GoodsExample;
import org.lynn.soop.repository.persistence.mybatis.handwrite.read.GoodsReadMapper;
import org.lynn.soop.repository.persistence.mybatis.handwrite.write.GoodsWriteMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.lynn.soop.util.JsonHelper.toJSON;

/**
 * Copyright @ 2013QIANLONG.
 * All right reserved.
 * Class Name : org.lynn.soop.business.goods
 * Description :
 * Author : cailinfeng
 * Date : 2016/7/12
 */
@Component
public class GoodsBusiness extends BaseBusiness {

    @Autowired
    private GoodsWriteMapper goodsWriteMapper;

    @Autowired
    private GoodsReadMapper goodsReadMapper;

    @Transactional
    public BaseResponse updateGoods(BaseRequest<Goods> request) {
        Goods goods = request.getData();
        boolean createNew = goods.getId() == null;
        int result;

        //校验名称是否已经存在
        String goodsName = StringUtils.trim(goods.getName());
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria  goodsExampleCriteria= goodsExample.createCriteria();
        goodsExampleCriteria.andNameEqualTo(goodsName);
        if (createNew) {
            List list = goodsReadMapper.selectByExample(goodsExample);
            if( list != null && list.size() > 0){
                return BaseResponse.buildClientErrorResponse("更新信息失败,已存在相同的货品！");
            }
            result = goodsWriteMapper.insertSelective(goods);
        } else {
            goodsExampleCriteria.andIdNotEqualTo(goods.getId());
            List list = goodsReadMapper.selectByExample(goodsExample);
            if( list != null && list.size() > 0){
                return BaseResponse.buildClientErrorResponse("更新信息失败,已存在相同的货品！");
            }
            goods.setDate_updated(new Date());
            result = goodsWriteMapper.updateByPrimaryKeySelective(goods);
        }
        BaseResponse toReturn;
        if (result > 0) {
            toReturn = BaseResponse.buildSuccessResponse("ok");
        } else {
            logger.error(String.format("error in update goods: [%s]", toJSON(request)));
            toReturn = BaseResponse.buildClientErrorResponse("更新信息失败");
        }
        return toReturn;
    }

    public PageViewDto<Goods> listGoods(BaseQueryRequest queryCondition) {
        GoodsExample example = new GoodsExample();
        if (!StringUtils.isBlank(queryCondition.getPageRequest().getSearch()))  {
            example.createCriteria().andNameLike("%"+queryCondition.getPageRequest().getSearch()+"%");
        }
        int totalCount = goodsReadMapper.countByExample(example);

        example.setOrderByClause("id asc");
        PageRequest pageRequest = queryCondition.getPageRequest();
        example.setPageCount(pageRequest.getLimit());
        example.setPageIndex(pageRequest.getOffset() / pageRequest.getLimit() + 1);
        pageRequest.setOrder(" order by id asc ");
        List<Goods> result = goodsReadMapper.selectByExample(example);
        PageViewDto<Goods> toReturn = new PageViewDto<Goods>();
        toReturn.setDataList(result);
        toReturn.setTotalNumber(totalCount);
        return toReturn;
    }
}
