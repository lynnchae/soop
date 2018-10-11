package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.UserAddress;
import org.lynn.soop.entity.handwrite.UserAddressExtend;

public class UserAddressOriginBuilder extends UserAddress {

    public static UserAddressExtend buildOrigin(UserAddress origin) {
        UserAddressExtend returnValue=new UserAddressExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setUser_id(origin.getUser_id());
        returnValue.setContact_name(origin.getContact_name());
        returnValue.setContact_phone(origin.getContact_phone());
        returnValue.setProvince(origin.getProvince());
        returnValue.setCity(origin.getCity());
        returnValue.setDistrict(origin.getDistrict());
        returnValue.setDetail_address(origin.getDetail_address());
        returnValue.setPost_code(origin.getPost_code());
        returnValue.setId_no_no(origin.getId_no_no());
        returnValue.setId_no_scan_front(origin.getId_no_scan_front());
        returnValue.setId_no_scan_back(origin.getId_no_scan_back());
        returnValue.setIs_default(origin.getIs_default());
        returnValue.setUser_identify_image_id(origin.getUser_identify_image_id());
        returnValue.setProvince_id(origin.getProvince_id());
        return returnValue;
    }
}