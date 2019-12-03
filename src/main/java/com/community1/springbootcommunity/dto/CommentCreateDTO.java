package com.community1.springbootcommunity.dto;

import lombok.Data;

/**
 * @ClassName CommentDTO
 * @Description: TODO
 * @Author gmf
 * @Date 2019/11/10
 * @Version V1.0
 **/
@Data
public class CommentCreateDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
