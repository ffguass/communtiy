package com.community1.springbootcommunity.controller;

import com.community1.springbootcommunity.dto.CommentCreateDTO;
import com.community1.springbootcommunity.dto.CommentDTO;
import com.community1.springbootcommunity.dto.ResultDTO;
import com.community1.springbootcommunity.enums.CommentTypeEnum;
import com.community1.springbootcommunity.exception.CustomizeErrorCode;
import com.community1.springbootcommunity.model.Comment;
import com.community1.springbootcommunity.model.User;
import com.community1.springbootcommunity.service.CommentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName CommentController
 * @Description: TODO
 * @Author gmf
 * @Date 2019/11/10
 * @Version V1.0
 **/
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ResponseBody//对象序列化成json
    @RequestMapping(value = "/comment", method = RequestMethod.POST)//接收json格式的数据
    public Object post(@RequestBody CommentCreateDTO commentCreateDTO,
                       HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }
        if (commentCreateDTO == null|| StringUtils.isBlank(commentCreateDTO.getContent())) {
            return ResultDTO.errorOf(CustomizeErrorCode.CONTENT_IS_EMPTY);
        }
        Comment comment = new Comment();
        comment.setParentId(commentCreateDTO.getParentId());
        comment.setContent(commentCreateDTO.getContent());
        comment.setType(commentCreateDTO.getType());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setCommentator(user.getId());
        comment.setLikeCount(0L);
        commentService.insert(comment);
        return ResultDTO.okOf();
    }

    @ResponseBody
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    public ResultDTO<List<CommentDTO>> comments(@PathVariable(name = "id") Long id){
        List<CommentDTO> commentDTOS=commentService.listByTargetId(id,CommentTypeEnum.COMMENT);
        return ResultDTO.okOf(commentDTOS);
    }
}
