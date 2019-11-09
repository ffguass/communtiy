package com.community1.springbootcommunity.advice;

import com.community1.springbootcommunity.exception.CustomizeException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName CustomizeExceptionHandler
 * @Description: TODO
 * @Author gmf
 * @Date 2019/11/8
 * @Version V1.0
 **/
@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler(Exception.class)
    ModelAndView handle(Throwable e , Model model) {
        /*HttpStatus status = getStatus(request);*/

        if(e instanceof CustomizeException){
            model.addAttribute("message",e.getMessage());
        }else{
            model.addAttribute("message","服务器在南极");
        }
        return new ModelAndView("error");
    }

}
