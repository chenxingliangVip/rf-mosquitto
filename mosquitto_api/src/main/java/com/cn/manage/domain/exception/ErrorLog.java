package com.cn.manage.domain.exception;

import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA. User: admin Date: 2018/9/10 Time: 9:12 To change this template use
 * File | Settings | File Templates. Description:
 */
public class ErrorLog implements Serializable {

  /** 记录时间 */
  private String logTime;

  /** 记录类型 */
  private String logType;

  /** 错误记录消息 */
  private String logMsg;

  public ErrorLog() {}

  public ErrorLog(String logMsg) {
    this.logTime = getLogTime();
    this.logType = LOG_TYPE.ERROR;
    this.logMsg = logMsg;
  }

  public ErrorLog(String logTime, String logType, String logMsg) {
    this.logTime = logTime;
    this.logType = logType;
    this.logMsg = logMsg;
  }

  public String getLogTime() {
    return logTime;
  }

  public void setLogTime(String logTime) {
    this.logTime = logTime;
  }

  /**
   * 默认为错误类型
   *
   * @return
   */
  public String getLogType() {
    if (StringUtils.isEmpty(this.logType)) {
      return LOG_TYPE.ERROR;
    }
    return logType;
  }

  public void setLogType(String logType) {
    this.logType = logType;
  }

  public String getLogMsg() {
    return logMsg;
  }

  public void setLogMsg(String logMsg) {
    this.logMsg = logMsg;
  }

  /** 日志类型 */
  public interface LOG_TYPE {
    String ERROR = "ERROR";
    String WARN = "WARN";
    String INFO = "INFO";
  }
}
