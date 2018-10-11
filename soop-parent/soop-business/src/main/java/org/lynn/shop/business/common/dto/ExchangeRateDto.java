package org.lynn.soop.business.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import static org.apache.commons.lang.StringUtils.isEmpty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRateDto {

    private String success;
    private ResultClass result;

    public boolean isSuccess() {
        boolean toReturn = false;
        if (!isEmpty(success) && success.equals("1")) {
            toReturn = true;
        }
        return toReturn;
    }

    public String getSuccess() {
        return success;
    }

    public ResultClass getResult() {
        return result;
    }

    public static class ResultClass {
        private String status;
        private String rate;

        public String getStatus() {
            return status;
        }

        public String getRate() {
            return rate;
        }
    }
}
