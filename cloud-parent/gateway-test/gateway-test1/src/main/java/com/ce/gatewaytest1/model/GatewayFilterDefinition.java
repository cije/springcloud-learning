package com.ce.gatewaytest1.model;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 过滤器定义模型
 *
 * @author c__e
 * @date 2021/4/28 9:48
 */
@Data
public class GatewayFilterDefinition {
    /**
     * Filter Name
     **/
    private String name;
    /**
     * 对应的路由规则
     */
    private Map<String, String> args = new LinkedHashMap<>();
}
