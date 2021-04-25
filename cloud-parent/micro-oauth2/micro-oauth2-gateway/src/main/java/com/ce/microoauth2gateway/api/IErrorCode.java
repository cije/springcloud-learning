package com.ce.microoauth2gateway.api;

/**
 * 封装API的错误码
 *
 * @author c__e
 * @date 2021/4/25 10:43
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
