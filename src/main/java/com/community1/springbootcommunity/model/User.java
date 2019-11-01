package com.community1.springbootcommunity.model;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String account_Id;
    private String token;
    private Long gmt_Create;
    private Long gmt_Modified;/*建立几个参数存储用户信息*/
    private String avatar_Url;
}
