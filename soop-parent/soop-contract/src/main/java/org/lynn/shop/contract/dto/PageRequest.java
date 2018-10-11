package org.lynn.soop.contract.dto;

public class PageRequest {
    private int limit;
    private int offset;
    private String search;
    private String sort;
    private String order;

    public int getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }

    public String getSearch() {
        return search;
    }

    public String getSort() {
        return sort;
    }

    public String getOrder() {
        return order;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
