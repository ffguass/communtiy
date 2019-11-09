package com.community1.springbootcommunity.exception;

/**
 * @ClassName CustomizeErrorCode
 * @Description: TODO
 * @Author gmf
 * @Date 2019/11/8
 * @Version V1.0
 **/
public enum  CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND("问题不见了！！！");

    public String getMessage() {
        return message;
    }

    private String message;

    CustomizeErrorCode(String message){
        this.message = message;
    }
}
