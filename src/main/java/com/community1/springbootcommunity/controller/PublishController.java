package com.community1.springbootcommunity.controller;

import com.community1.springbootcommunity.mapper.QuestionMapper;
import com.community1.springbootcommunity.model.Question;
import com.community1.springbootcommunity.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {
    @Autowired
    private QuestionMapper questionMapper;

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(value = "title",required = false) String title,
            @RequestParam(value = "description",required = false) String description,
            @RequestParam(value = "tag",required = false) String tag,
           /* @RequestParam(value = "id", required = false) Long id,*/
            HttpServletRequest request,
            Model model
    ){
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);
        if(StringUtils.isBlank(title)){
            model.addAttribute("error","标题不能为空");
            return "/";
        }
        if(StringUtils.isBlank(description)){
            model.addAttribute("error","问题补充不能为空");
            return "/";
        }
        if(StringUtils.isBlank(tag)){
            model.addAttribute("error","标签不能为空");
            return "/";
        }
        User user = (User) request.getSession().getAttribute("user");
        if(user == null ){
            model.addAttribute("error","用户未登录");
            return "/publish";
        }

        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
      /*  question.setId(id);*/
        question.setCreator(user.getId());
        question.setGmt_Create(System.currentTimeMillis());
        question.setGmt_Modified(question.getGmt_Create());
        questionMapper.create(question);
        return "redirect:/ ";
    }
}
