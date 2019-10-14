package com.community1.springbootcommunity.controller;

import com.community1.springbootcommunity.dto.AccessTokenDTO;
import com.community1.springbootcommunity.dto.GithubUser;
import com.community1.springbootcommunity.mapper.UserMapper;
import com.community1.springbootcommunity.model.User;
import com.community1.springbootcommunity.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @Autowired
    private UserMapper userMapper;


    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletResponse response)/*从request获取code state*/
    {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId/*"8282249c47b5c8ad111e"*/);/*抽离至application.properties*/
        accessTokenDTO.setClient_secret(clientSecret/*"e47e9d943f884aad2482ce358293379f6599ede4"*/);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri/*"http://localhost:8088/callback"*/);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);/*获取user信息，并用githubUser存储*/
        if(githubUser != null && githubUser.getId() != null){
            User user = new User();
            String token = UUID.randomUUID().toString();/*生成识别码，用于社区登录*/
            user.setToken(token);/*将获取的信息set并插入user表中*/
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
            response.addCookie(new Cookie("token",token));
            /*登陆成功，写cookie 和 session*/
            return "redirect:/";
        }else{
            //登陆失败，重新登陆
            return "redirect:/";
        }

    }
}
