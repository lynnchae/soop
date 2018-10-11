package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.UserAddress;
import org.lynn.soop.entity.handwrite.originEntityBuilder.UserAddressOriginBuilder;

public class UserAddressExtend extends UserAddress {

    public enum SpecialRegion {
        xinjiang(29, "新疆"),

        neimenggu(28, "内蒙古"),
        xizang(30, "西藏"),
        ningxia(14, "宁夏");
        private int code;
        private String displayName;

        SpecialRegion(Integer code, String displayName) {
            this.code = code;
            this.displayName = displayName;
        }

        public Integer getCode() {
            return code;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public static UserAddressExtend generateFromOriginEntity(UserAddress origin) {
        return UserAddressOriginBuilder.buildOrigin(origin);
    }

    public String getFullAddressDetail() {
        return String.format("%s%s%s%s", this.getProvince(), this.getCity(), this.getDistrict(), this.getDetail_address());
    }

    /**
     * 如果特殊区域出现在省或市里面
     *
     * @return
     */
    public boolean isSpecialRegion() {
        Integer province_id = getProvince_id();
        boolean isSpecial = false;
        SpecialRegion[] specialRegions = SpecialRegion.values();
        if (province_id != null) {
            for (SpecialRegion specialRegion : specialRegions) {
                if (specialRegion.code == province_id) {
                    isSpecial = true;
                    break;
                }
            }
        } else {
            String province = getProvince();
            for (SpecialRegion specialRegion : specialRegions) {
                if (province.contains(specialRegion.displayName)) {
                    isSpecial = true;
                    break;
                }
            }
        }
        return isSpecial;
    }
}