package com.community1.springbootcommunity.dto;

import com.community1.springbootcommunity.model.User;
import lombok.Data;

/**
 * @ClassName CommentDTO
 * @Description: TODO
 * @Author gmf
 * @Date 2019/11/19
 * @Version V1.0
 **/
@Data
public class CommentDTO {

    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private Integer commentCount;
    private String content;
    private User user;


}
