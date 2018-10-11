package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.MembershipLevelRule;
import org.lynn.soop.entity.handwrite.MembershipLevelRuleExtend;

public class MembershipLevelRuleOriginBuilder extends MembershipLevelRule {

    public static MembershipLevelRuleExtend buildOrigin(MembershipLevelRule origin) {
        MembershipLevelRuleExtend returnValue=new MembershipLevelRuleExtend();
        returnValue.setId(origin.getId());
        returnValue.setName(origin.getName());
        returnValue.setLevel(origin.getLevel());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setPoint_floor(origin.getPoint_floor());
        returnValue.setPoint_ceiling(origin.getPoint_ceiling());
        returnValue.setDiscount_percentage(origin.getDiscount_percentage());
        returnValue.setUser_group(origin.getUser_group());
        return returnValue;
    }
}