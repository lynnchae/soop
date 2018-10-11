package org.lynn.soop.contract.dto;


import org.lynn.soop.contract.BaseDto;
import com.sun.istack.internal.NotNull;

/**
 * Created by chenwen on 4/23/16.
 */
public class NamableDto extends BaseDto {

    @NotNull
    private String nameCN;

    private String nameEN;


    public String getNameCN() {
        return nameCN;
    }

    public void setNameCN(String nameCN) {
        this.nameCN = nameCN;
    }

    public String getNameEN() {
        return nameEN;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }
}
