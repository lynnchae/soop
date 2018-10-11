package org.lynn.soop.contract.dto;

import org.codehaus.jackson.annotate.JsonProperty;

public class BaseQueryRequest {


    @JsonProperty("page")
    private PageRequest pageRequest;

    public PageRequest getPageRequest() {
        return pageRequest;
    }

    public void setPageRequest(PageRequest pageRequest) {
        this.pageRequest = pageRequest;
    }
}
