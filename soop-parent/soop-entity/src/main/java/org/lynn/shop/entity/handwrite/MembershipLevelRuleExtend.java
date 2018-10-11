package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.MembershipLevelRule;
import org.lynn.soop.entity.handwrite.originEntityBuilder.MembershipLevelRuleOriginBuilder;

public class MembershipLevelRuleExtend extends MembershipLevelRule {

    public static MembershipLevelRuleExtend generateFromOriginEntity(MembershipLevelRule origin) {
        return MembershipLevelRuleOriginBuilder.buildOrigin(origin);
    }
}