package org.lynn.soop.entity.dto.response;

/**
 * Created by gaoguoxiang on 2016/7/20
 */
public class LoginRtnAuthList {
    private String id;
    private String pid;
    private String name;
    private String module_name;
    private String url;
    private String is_btn_url;
    private String sort;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModule_name() {
        return module_name;
    }

    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIs_btn_url() {
        return is_btn_url;
    }

    public void setIs_btn_url(String is_btn_url) {
        this.is_btn_url = is_btn_url;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "LoginRtnAuthList{" +
                "id='" + id + '\'' +
                ", pid='" + pid + '\'' +
                ", name='" + name + '\'' +
                ", module_name='" + module_name + '\'' +
                ", url='" + url + '\'' +
                ", is_btn_url='" + is_btn_url + '\'' +
                ", sort='" + sort + '\'' +
                '}';
    }
}
