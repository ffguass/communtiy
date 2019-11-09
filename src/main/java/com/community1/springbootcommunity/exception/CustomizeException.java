package com.community1.springbootcommunity.exception;

/**
 * @ClassName CustomizeException
 * @Description: TODO
 * @Author gmf
 * @Date 2019/11/8
 * @Version V1.0
 **/
public class CustomizeException extends RuntimeException{
    private String message;

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }

    public CustomizeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
