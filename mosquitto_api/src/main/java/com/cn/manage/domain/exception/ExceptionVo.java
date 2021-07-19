package com.cn.manage.domain.exception;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA. User: admin Date: 2018/9/7 Time: 17:38 To change this template use
 * File | Settings | File Templates. Description:
 */
public class ExceptionVo implements Serializable {

  public static final String WEB_TYPE = "1";

  public static final String BACK_TYPE = "2";

  /** 错误原因 */
  private String errorReason;

  /** 解决方式 */
  private String errorSolution;

  /** web端或者是后端造成异常 */
  private String causeType;

  /** 代码错误的位置(默认1是web端，2是后端) */
  private String position;

  /** 错误堆栈信息 */
  private List<ErrorLog> errorLog;

  private String code;

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

  public String getCauseType() {
    return causeType;
  }

  public void setCauseType(String causeType) {
    this.causeType = causeType;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public List<ErrorLog> getErrorLog() {
    return errorLog;
  }

  public void setErrorLog(List<ErrorLog> errorLog) {
    this.errorLog = errorLog;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
