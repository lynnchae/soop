package org.lynn.soop.contract.member.dto;



import org.lynn.soop.contract.BaseDto;
import org.lynn.soop.contract.order.dto.AcceptOrderDTO;

import java.util.List;

/**
 * Created by chenwen on 5/09/16.
 */
public class MyShowDto extends BaseDto {

    private UserDto user;

    private List<AcceptOrderDTO> orderList;
    private int orderNum;

    private List<UserAddressDto> addressList;
    private int addressNum;

    //TODO 身份证列表数 idCardNum ???


    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public List<AcceptOrderDTO> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<AcceptOrderDTO> orderList) {
        this.orderList = orderList;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public List<UserAddressDto> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<UserAddressDto> addressList) {
        this.addressList = addressList;
    }

    public int getAddressNum() {
        return addressNum;
    }

    public void setAddressNum(int addressNum) {
        this.addressNum = addressNum;
    }
}
