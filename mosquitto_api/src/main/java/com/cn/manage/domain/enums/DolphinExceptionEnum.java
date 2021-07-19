package com.cn.manage.domain.enums;


import org.springframework.util.StringUtils;

public enum DolphinExceptionEnum {
  /** COMMON 此处主要是兼容BizException中定义的异常码以及定义系统通用的一些异常 */
  COMMON_SERVER_EXCEPTION("DEFAULT_SERVER_ERROR", "系统异常", "查看日志并联系管理员处理."),
  COMMON_BUSINESS_EXCEPTION("50001", "业务错误", "查看日志并联系管理员处理."),
  COMMON_CACHE_EXCEPTION("50002", "缓存错误", "查看日志并联系管理员处理."),
  COMMON_CHECK_EXCEPTION("50003", "检查错误", "查看日志并联系管理员处理."),
  COMMON_DATABASE_EXCEPTION("50004", "数据库错误", "查看日志并联系管理员处理."),
  COMMON_INTERFACE_EXCEPTION("50005", "接口错误", "查看日志并联系管理员处理."),
  COMMON_NETWORK_EXCEPTION("50006", "网络错误", "请检查网络是否已连接或者服务配置是否正确."),
  COMMON_OTHER_EXCEPTION("50007", "其他错误", "查看日志并联系管理员处理."),
  COMMON_PARAMS_EXCEPTION("50008", "参数错误", "请检查发送请求的参数合法性."),
  COMMON_HANDLER_NOT_FOUND(
      "ETL_HANDLER_NOT_FOUND", "根据插件的名称获取插件处理器 实例为空,请检查插件实例名称是否正确!", "刷新页面后,再次尝试"),
  // -- 参数传递为空校验
  COMMON_PARAMS_EMPTY("COMMON_PARAMS_EMPTY", "参数为空或者参数传递不合法 !", "请核对参数或者重新填写后重试 !"),
  // http 请求失败
  COMMON_REQUEST_FAIL("COMMON_REQUEST_FAIL", "请求接口失败", "请检查接口地址、参数是否正确后重新尝试"),

  COMMON_SOLR_FAIL("COMMON_SOLR_FAIL", "请求solr接口失败", "请检查solr服务器是否正常启动,以及solr地址是否配置正确"),
  COMMON_HAWK_FAIL("COMMON_HAWK_FAIL", "请求hawk接口失败", "请检查hawk服务器是否正常启动,以及hawk地址是否配置正确"),
  HERMS_QUERY_FAIL("HERMS_QUERY_FAIL", "请求herms接口失败", "请检查herms服务器是否正常启动,以及herms地址是否配置正确"),
  ;

  /** 系统默认异常code */
  public static final String DEFAULT_SERVER_ERROR_CODE = "DEFAULT_SERVER_ERROR";

  private String errCode;

  private String errorReason;

  private String errorSolution;

  DolphinExceptionEnum() {
    if (StringUtils.isEmpty(this.errCode)) {
      this.errCode = DEFAULT_SERVER_ERROR_CODE;
    }
  }

  DolphinExceptionEnum(String errCode, String errorReason, String errorSolution) {
    this.errCode = errCode;
    if (StringUtils.isEmpty(this.errCode)) {
      this.errCode = DEFAULT_SERVER_ERROR_CODE;
    }
    this.errorReason = errorReason;
    this.errorSolution = errorSolution;
  }

  public String getErrCode() {
    return errCode;
  }

  public void setErrCode(String errCode) {
    this.errCode = errCode;
  }

  public String getErrorReason() {
    return errorReason;
  }

  public void setErrorReason(String errorReason) {
    this.errorReason = errorReason;
  }

  public String getErrorSolution() {
    return errorSolution;
  }

  public void setErrorSolution(String errorSolution) {
    this.errorSolution = errorSolution;
  }
}
