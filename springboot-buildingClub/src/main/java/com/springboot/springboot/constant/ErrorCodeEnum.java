package com.springboot.springboot.constant;

public enum ErrorCodeEnum {
    // 系统
    SUCCESS("0", "成功"), ERROR("-1", "系统错误"),
    DEFINE_ERROR("-2", "自定义错误，根据返回对象值进行判断"),
    UNAUTHORIZED("401", "未认证"), NO_ROLE("403", "权限不够"),
    IDENTIFY_CODE_ERROR("1001", "验证码错误"),
    IDENTIFY_CODE_EXPIRED("1002", "验证码过期"),
    NOT_FOUND("404", "未找到资源"),
    PARAMETER_WRONG("405", "参数有误"),
    RESOURCE_EXISTED("201", "资源已存在"),
    NUMBER_EXCEED_LIMIT("1001", "数量超出规定限制"),
    PHONE_WRONG("1003", "手机号不正确"),
    NOT_FOUND_UNION_ID("1004", "用户未授权获取uinonId"),
    // 带着场景的成功码，表示成功同时产生其他的符合的特殊条件(比如创建成功且是第一次创建),如果单纯指成功建议使用上面那个
    SUCCESS_WITH_SCENE("1", "成功,并同时伴随着场景"),
    STOCK_NOT_ENOUGH("1005", "库存不足"),
    GET_REDIS_LOCK_TIME_OUT("1006", "获取锁超时"),
    NOT_MEMBER("1007", "不是会员"),

    // 登陆
	LOGIN_PASSWORD_ERROR("300001", "密码不正确"),
	LOGIN_ACCOUNT_ERROR("300002", "账号不存在, 请先注册");

    private String code;
    private String message;

    private ErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private ErrorCodeEnum(String code, String additionCode, String message) {
        this.code = code;
        this.message = message;

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
