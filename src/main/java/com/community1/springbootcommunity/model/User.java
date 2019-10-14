package com.community1.springbootcommunity.model;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;/*建立几个参数存储用户信息*/
    private String avatarUrl;
}
