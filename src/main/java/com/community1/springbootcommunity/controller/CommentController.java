package com.community1.springbootcommunity.controller;

import com.community1.springbootcommunity.dto.CommentDTO;
import com.community1.springbootcommunity.mapper.CommentMapper;
import com.community1.springbootcommunity.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName CommentController
 * @Description: TODO
 * @Author gmf
 * @Date 2019/11/10
 * @Version V1.0
 **/
public class CommentController {

    @Autowired
    private CommentMapper commentMapper;

    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    public Object post(@RequestBody CommentDTO commentDTO){
        Comment comment = new Comment();
        comment.setParentId(commentDTO.getParentId());
        comment.setContent(commentDTO.getContent());
        comment.setType(commentDTO.getType());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setCommentator(1);
        commentMapper.insert(comment);
        return null;


    }
}
