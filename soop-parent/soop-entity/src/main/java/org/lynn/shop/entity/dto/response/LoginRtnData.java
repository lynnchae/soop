package org.lynn.soop.entity.dto.response;

import java.util.List;

/**
 * Created by gaoguoxiang on 2016/7/20
 */
public class LoginRtnData {
    private String token;
    private String uid;
    private String username;
    private String nickname;
    private String job_number;
    private String type_id;
    private String type_name;
    private String team_id;
    private String team_sub_id;
    private String tianrun;
    private List<LoginRtnAuthList> auth_list;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getJob_number() {
        return job_number;
    }

    public void setJob_number(String job_number) {
        this.job_number = job_number;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getTeam_sub_id() {
        return team_sub_id;
    }

    public void setTeam_sub_id(String team_sub_id) {
        this.team_sub_id = team_sub_id;
    }

    public String getTianrun() {
        return tianrun;
    }

    public void setTianrun(String tianrun) {
        this.tianrun = tianrun;
    }

    public List<LoginRtnAuthList> getAuth_list() {
        return auth_list;
    }

    public void setAuth_list(List<LoginRtnAuthList> auth_list) {
        this.auth_list = auth_list;
    }

    @Override
    public String toString() {
        return "LoginRtnData{" +
                "token='" + token + '\'' +
                ", uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", job_number='" + job_number + '\'' +
                ", type_id='" + type_id + '\'' +
                ", type_name='" + type_name + '\'' +
                ", team_id='" + team_id + '\'' +
                ", team_sub_id='" + team_sub_id + '\'' +
                ", tianrun='" + tianrun + '\'' +
                ", auth_list=" + auth_list +
                '}';
    }
}
