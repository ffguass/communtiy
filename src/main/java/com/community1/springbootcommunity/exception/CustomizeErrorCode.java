package com.community1.springbootcommunity.exception;

/**封装error
 * @ClassName CustomizeErrorCode
 * @Description: TODO
 * @Author gmf
 * @Date 2019/11/8
 * @Version V1.0
 **/
public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND(2001, "问题不见了！！！"),
    TARGET_PARAM_NOT_FOUND(2002, "你啥都没有选择"),
    NO_LOGIN(2003,"你还没上线呢，亲"),
    SYS_ERROR(2004,"你还没上线,请登录"),
    TYPE_PARAM_WRONG(2005,"评论不存在,有错误"),
    COMMENT_NOT_FOUND(2006,"回复的评论消失了,换一个?"),
    CONTENT_IS_EMPTY(2007,"输入内容不能为空") ;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    private Integer code;
    private String message;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }
}
