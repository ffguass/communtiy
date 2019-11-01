package com.community1.springbootcommunity.dto;

import lombok.Data;

@Data
public class GithubUser {
    private String name;
    private Long id;/*防止后续不够*/
    private String bio;/*简介*/
    private String avatar_Url;

    @Override
    public String toString() {
        return "GithubUser{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", bio='" + bio + '\'' +
                '}';
    }
}
