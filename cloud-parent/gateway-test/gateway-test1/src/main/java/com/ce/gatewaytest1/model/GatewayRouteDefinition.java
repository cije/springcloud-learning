package com.ce.gatewaytest1.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 路由定义模型
 *
 * @author c__e
 * @date 2021/4/28 9:44
 */
@Data
public class GatewayRouteDefinition {
    /**
     * 路由的id
     */
    private String id;
    /**
     * 路由断言集合配置
     */
    private List<GatewayPredicateDefinition> predicates = new ArrayList<>();
    /**
     * 路由过滤器配置
     */
    private List<GatewayFilterDefinition> filters = new ArrayList<>();
    /**
     * 路由规则转发的目标uri
     */
    private String uri;
    /**
     * 路由执行的顺序
     */
    private int order = 0;

}
