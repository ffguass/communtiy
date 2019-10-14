package com.community1.springbootcommunity.dto;

import lombok.Data;

@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;/*建立参数存储access_token信息。需要getset方法*/

}
