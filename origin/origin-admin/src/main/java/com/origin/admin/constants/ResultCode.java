package com.origin.admin.constants;

/**
 * <pre>
 *
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/8/25 16:05
 */
public enum ResultCode {

    /*  */
    SUCCESS(200, "成功"),
    ERROR(101, "失败"),
    SYSTEM_EXCEPTION(-1,"系统异常"),
    SERVICES_ERROR(500, "服务器错误"),
    UNKNOWN_ACCOUNT(301, "用户名错误"),
    INCORRECT_CREDENTIALS(302, "密码错误"),
    REGISTER_FAIL(304, "注册失败"),
    NOT_LOGIN_ERROR(305, "请先登陆"),
    TOKEN_FORMAT_ERROR(306, "Token格式错误"),
    ADMIN_INVALID_NAME(600, "管理员名称不符合规定"),
    ADMIN_INVALID_PASSWORD(601, "管理员密码长度不能小于6"),
    ADMIN_NAME_EXIST(602, "管理员已经存在"),
    // ADMIN_ALTER_NOT_ALLOWED(603,""),
    // ADMIN_DELETE_NOT_ALLOWED(604,""),
    ADMIN_INVALID_ACCOUNT_OR_PASSWORD(605, "用户帐号或密码不正确"),
    ADMIN_LOCK_ACCOUNT(606, "用户帐号已锁定不可用"),
    ADMIN_INVALID_AUTH(607, "认证失败"),
    GOODS_UPDATE_NOT_ALLOWED(610, "商品已经在订单或购物车中，不能修改"),
    GOODS_NAME_EXIST(611, "商品名已经存在"),
    ORDER_CONFIRM_NOT_ALLOWED(620, "当前订单状态不能确认收货"),
    ORDER_REFUND_FAILED(621, "当前订单状态不能退款"),
    ORDER_REPLY_EXIST(622, "订单商品已回复！"),
    ADMIN_INVALID_OLD_PASSWORD(623, "原始密码不正确！"),
    // USER_INVALID_NAME(630,""),
    // USER_INVALID_PASSWORD(631,""),
    // USER_INVALID_MOBILE(632,""),
    // USER_NAME_EXIST(633,""),
    // USER_MOBILE_EXIST(634,""),
    ROLE_NAME_EXIST(640, "角色已经存在"),
    ROLE_SUPER_SUPERMISSION(641, "当前角色的超级权限不能变更"),
    ARTICLE_NAME_EXIST(642,"公告或通知文章已经存在"),
    AUTH_CAPTCHA_FREQUENCY(643,"验证码请求过于频繁"),
    AUTH_CAPTCHA_ERROR(644,"验证码错误"),
    AUTH_CAPTCHA_EXPIRED(645,"验证码过期")
    ;

    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code(){
        return this.code;
    }

    public String message(){
        return this.message;
    }

}
