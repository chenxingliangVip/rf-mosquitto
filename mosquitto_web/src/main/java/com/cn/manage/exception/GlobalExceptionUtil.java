package com.cn.manage.exception;


import com.alibaba.fastjson.JSON;
import com.cn.manage.domain.enums.DolphinExceptionEnum;
import com.cn.manage.domain.exception.ErrorLog;
import com.cn.manage.domain.exception.ExceptionVo;
import com.cn.manage.utils.JsonResponse;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA. User: admin Date: 2019/9/10 Time: 15:33 To change this template use
 * File | Settings | File Templates. Description:
 */
public class GlobalExceptionUtil {

  public static final Map<String, ExceptionVo> errorDictMap = Maps.newHashMap();

  public static final String DEFAULT_SERVER_ERROR = "DEFAULT_SERVER_ERROR";

  public static final String COMMON_PARAMS_EMPTY = "COMMON_PARAMS_EMPTY";

  public static final String COMMON_REQUEST_FAIL = "COMMON_REQUEST_FAIL";

  public static final String ETL_HANDLER_NOT_FOUND = "ETL_HANDLER_NOT_FOUND";

  public static final String COMMON_BUSINESS_EXCEPTION = "50001";

  public static final String COMMON_CACHE_EXCEPTION = "50002";

  public static final String COMMON_CHECK_EXCEPTION = "50003";

  public static final String COMMON_DATABASE_EXCEPTION = "50004";

  public static final String COMMON_INTERFACE_EXCEPTION = "50005";

  public static final String COMMON_NETWORK_EXCEPTION = "50006";

  public static final String COMMON_OTHER_EXCEPTION = "50007";

  public static final String COMMON_PARAMS_EXCEPTION = "50008";

  public static final String COMMON_SOLR_FAIL = "COMMON_SOLR_FAIL";

  public static final String COMMON_HAWK_FAIL = "COMMON_HAWK_FAIL";

  /**
   * 返回错误信息
   *
   * @param code
   * @param e
   * @return
   * @throws IOException
   */
  public static JsonResponse covert(String code, Exception e) throws IOException {
    return new JsonResponse<>(Boolean.FALSE, -1, covertException(code, e));
  }

  /**
   * 转化错误信息
   *
   * @param code
   * @param e
   * @return
   */
  private static String covertException(String code, Exception e) {
    if (errorDictMap.size() == 0) {
      // 获取全局的错误码
      getGolbalErrorDict();
    }
    ExceptionVo info = errorDictMap.get(code);
    if (null == info) {
      info = new ExceptionVo();
    }
    String position = getTraceInfo(e);
    String errorLog = covertStackToStr(e);
    String causeType = judgeErrorType(errorLog, code);
    info.setCauseType(causeType);
    info.setPosition(position);
    List<ErrorLog> errors = Lists.newArrayList();
    errors.add(new ErrorLog(errorLog));
    info.setErrorLog(errors);
    info.setCode(code);
    return JSON.toJSONString(info);
  }

  /**
   * 获取报错的具体位置
   *
   * @param e
   * @return
   */
  private static String getTraceInfo(Exception e) {
    StringBuffer sb = new StringBuffer();
    StackTraceElement[] stacks = e.getStackTrace();
    if (stacks.length > 0) {
      sb.append("类")
          .append(stacks[0].getClassName())
          .append("中")
          .append("方法")
          .append(stacks[0].getMethodName())
          .append("第")
          .append(stacks[0].getLineNumber())
          .append("行报错");
    }
    return sb.toString();
  }

  /** 获取全局的错误码 */
  public static void getGolbalErrorDict() {
    // 获取数据清洗的异常枚举的信息
    DolphinExceptionEnum[] exceptionEnums = DolphinExceptionEnum.values();
    if (exceptionEnums.length < 1) {
      return;
    }
    if (errorDictMap.size() > 0) {
      return;
    }
    for (DolphinExceptionEnum exceptionEnum : exceptionEnums) {
      ExceptionVo info = new ExceptionVo();
      info.setErrorReason(exceptionEnum.getErrorReason());
      info.setErrorSolution(exceptionEnum.getErrorSolution());
      errorDictMap.put(exceptionEnum.getErrCode(), info);
    }
  }

  /**
   * 将异常的堆栈信息转换为字符串
   *
   * @param e
   * @return
   */
  public static String covertStackToStr(Exception e) {
    try (StringWriter sw = new StringWriter();
        PrintWriter writer = new PrintWriter(sw)) {
      e.printStackTrace(writer);
      return sw.toString();
    } catch (IOException io) {
      return "无法获取异常信息 !";
    }
  }

  /**
   * 分析错误类型的发生位置
   *
   * @param errorLog
   * @param code
   * @return
   */
  private static String judgeErrorType(String errorLog, String code) {
    String causeType = "";
    switch (code) {
      case COMMON_INTERFACE_EXCEPTION:
        causeType = ExceptionVo.BACK_TYPE;
        break;
      case COMMON_SOLR_FAIL:
        causeType = ExceptionVo.BACK_TYPE;
        break;
      case COMMON_HAWK_FAIL:
        causeType = ExceptionVo.BACK_TYPE;
        break;
      default:
        causeType = ExceptionVo.WEB_TYPE;
        break;
    }
    // TODO 通过解析errorLog来判断接口的错误类型
    return causeType;
  }
}
