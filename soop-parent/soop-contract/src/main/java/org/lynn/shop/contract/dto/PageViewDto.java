package org.lynn.soop.contract.dto;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenwen on 4/22/16.
 */
public class PageViewDto<T> extends ExampleViewDto {

    private int pageIndex = 1;
    private int pageSize = 15;

    @JsonProperty("total")
    private long totalNumber;
    @JsonProperty("rows")
    private List<T> dataList;

    private long totalPageNumber;

    public static PageViewDto empty() {
        PageViewDto toReturn = new PageViewDto();
        toReturn.totalNumber = 0;
        toReturn.dataList = new ArrayList();
        return toReturn;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(long totalNumber) {
        this.totalNumber = totalNumber;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public long getTotalPageNumber() {
        return totalPageNumber;
    }

    public void setTotalPageNumber(long totalPageNumber) {
        this.totalPageNumber = totalPageNumber;
    }
}
