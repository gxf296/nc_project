package com.itcast.common.enums;

import lombok.Getter;

@Getter
public enum ResponseEnum {

    //一定要将选择项放在最上
    AGE_NOT_NULL(500, "年龄不能为空"),
    SUCCESS(200, "操作成功！"),
    ERROR(401, "操作失败401！"),

    INVALID_FILE_TYPE(400, "无效的文件类型！"),
    INVALID_PARAM_ERROR(400, "无效的请求参数！"),
    INVALID_PHONE_NUMBER(400, "无效的手机号码"),
    INVALID_VERIFY_CODE(400, "验证码错误！"),
    INVALID_USERNAME_PASSWORD(400, "无效的用户名和密码！"),
    INVALID_SERVER_ID_SECRET(400, "无效的服务id和密钥！"),
    INVALID_NOTIFY_PARAM(400, "回调参数有误！"),
    INVALID_NOTIFY_SIGN(400, "回调签名有误！"),

    DATA_TRANSFER_ERROR(500, "数据转换异常！"),
    INSERT_OPERATION_FAIL(500, "新增操作失败！"),
    UPDATE_OPERATION_FAIL(500, "更新操作失败！"),
    DELETE_OPERATION_FAIL(500, "删除操作失败！"),
    FILE_UPLOAD_ERROR(500, "文件上传失败！"),
    DIRECTORY_WRITER_ERROR(500, "目录写入失败！"),
    FILE_WRITER_ERROR(500, "文件写入失败！"),
    SEND_MESSAGE_ERROR(500, "短信发送失败！"),
    CODE_IMAGE_ERROR(500, "验证码错误！"),

    USER_MOBILE_EXISTS(500, "该手机号已经被注册！"),
    USER_NOT_REGISTER(500, "当前用户还未进行注册！"),
    USER_NOT_JOIN_COMPANY(500, "请加入企业后再使用该功能！"),
    USER_NOT_COMPANY_ADMIN(500, "您不是企业管理员！"),
    USER_NOT_MATCH_ATTGROUP(500, "未查询到用户考勤组,请先配置！"),
    USER_NOT_FOUND(500, "没有查询到用户！"),

    COMPANY_ADMIN_NOT_EXISTS(500, "没有找到对应企业管理员！"),
    COMPANY_NOT_FOUND(500, "企业不存在！"),
    WROK_NUM_EXISTS(500, "当前工号已经存在！"),

    PUNCH_INVALID_AREA(500, "打卡地点不在考勤点范围内！"),
    PUNCH_INVALID_DAY(500, "非工作日无需打卡！"),
    PUNCH_ALREADY(500, "已经打卡，无需重复打卡！"),
    SIGN_DATA_NULL(404, "未检索到签到数据！"),

    MESSAGE_PARAMS_LOST(500, "查询参数缺失！"),

    UNAUTHORIZED(401, "登录失效或未登录！"),
    FOBIDDEN(403, "禁止访问！"),
    SIGNDATA_NOT_FOUND(500, "当前检索条件没有签到数据！"),

    ROLE_NOT_FOUND(403, "角色列表不存在！"),
    SYS_PERMISSSION_NOT_FOUND(403, "当前企业无权限");

    private int code;
    private String message;

    ResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
