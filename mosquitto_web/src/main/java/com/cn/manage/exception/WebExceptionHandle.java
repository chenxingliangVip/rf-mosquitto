package com.cn.manage.exception;

import org.apache.ibatis.javassist.tools.web.BadHttpRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.net.ConnectException;
import java.net.SocketException;
import java.sql.SQLException;

import static com.cn.manage.exception.GlobalExceptionUtil.covert;

/**
 * Created with IntelliJ IDEA. User: admin Date: 2018/9/6 Time: 15:09 To change this template use
 * File | Settings | File Templates. Description:
 */
@Aspect
@Component
public class WebExceptionHandle {

  private static final Logger LOGGER = LoggerFactory.getLogger(WebExceptionHandle.class);

  @SuppressWarnings("rawtypes")
  @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
  public Object execute(ProceedingJoinPoint pjp) throws Throwable {
    try {
      return pjp.proceed();
      // 网络连接错误
    } catch (ConnectException e) {
      LOGGER.error("connect exception: ", e);
      return covert(GlobalExceptionUtil.COMMON_REQUEST_FAIL, e);
      // 网络错误
    } catch (SocketException e) {
      LOGGER.error("socket exception: ", e);
      return covert(GlobalExceptionUtil.COMMON_NETWORK_EXCEPTION, e);
      // bad request
    } catch (BadHttpRequest e) {
      LOGGER.error("socket exception: ", e);
      return covert(GlobalExceptionUtil.COMMON_PARAMS_EXCEPTION, e);
      // sql报错
    } catch (SQLException e) {
      LOGGER.error("sql exception: ", e);
      return covert(GlobalExceptionUtil.COMMON_DATABASE_EXCEPTION, e);
      // 调取远程接口异常
    } catch (RestClientException e) {
      LOGGER.error("rest client exception: ", e);
      return covert(GlobalExceptionUtil.COMMON_INTERFACE_EXCEPTION, e);
      // 业务逻辑错误
    } catch (Exception e) {
      LOGGER.error("other exception: ", e);
      return covert(GlobalExceptionUtil.DEFAULT_SERVER_ERROR, e);
    }
  }
}
