package com.community1.springbootcommunity.controller;

import com.community1.springbootcommunity.cache.TagCache;
import com.community1.springbootcommunity.dto.QuestionDTO;
import com.community1.springbootcommunity.mapper.QuestionMapper;
import com.community1.springbootcommunity.model.Question;
import com.community1.springbootcommunity.model.User;
import com.community1.springbootcommunity.service.QuestionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/publish/{id}")
    public String edit(@PathVariable(name = "id") Long id,
                       Model model){
        QuestionDTO question = questionService.getById(id);
        model.addAttribute("title",question.getTitle());
        model.addAttribute("description",question.getDescription());
        model.addAttribute("tag",question.getTag());
        model.addAttribute("id",question.getId());
        return "publish";
    }

    @GetMapping("/publish")//给前端的接口
    public String publish(Model model) {
        model.addAttribute("tags", TagCache.get());
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(value = "title",required = false) String title,
            @RequestParam(value = "description",required = false) String description,
            @RequestParam(value = "tag",required = false) String tag,
            @RequestParam(value = "id", required = false) Long id,
            HttpServletRequest request,
            Model model
    ){
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);
        model.addAttribute("tags", TagCache.get());
        if(StringUtils.isBlank(title)){
            model.addAttribute("Error","标题不能为空");
            return "publish";
        }
        if(StringUtils.isBlank(description)){
            model.addAttribute("Error","问题补充不能为空");
            return "publish";
        }
        if(StringUtils.isBlank(tag)){
            model.addAttribute("Error","标签不能为空");
            return "publish";
        }
        User user = (User) request.getSession().getAttribute("user");
        if(user == null ){
            model.addAttribute("Error","用户未登录");
            return "publish";
        }

        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setId(id);
        questionService.createOrUpdate(question);
        return "redirect:/";
    }
}
