package com.ce.zuulproxy.filter;

import cn.hutool.log.Log;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义过滤器
 * <p>
 * Zuul中有以下几种典型的过滤器类型。
 * <ul>
 *   <li>pre：在请求被路由到目标服务前执行，比如权限校验、打印日志等功能；</li>
 *   <li>routing：在请求被路由到目标服务时执行，这是使用Apache HttpClient或Netflix Ribbon构建和发送原始HTTP请求的地方；</li>
 *   <li>post：在请求被路由到目标服务后执行，比如给目标服务的响应添加头信息，收集统计数据等功能；</li>
 *   <li>error：请求在其他阶段发生错误时执行。</li>
 * </ul>
 *
 * @author c__e
 * @date 2021/4/15 16:49
 */
@Component
public class PreLogFilter extends ZuulFilter {
    private final Log log = Log.get();

    /**
     * 过滤器类型，有pre、routing、post、error四种。
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤器执行顺序，数值越小优先级越高。
     */
    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    /**
     * 是否进行过滤，返回true会执行过滤。
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 自定义的过滤器逻辑，当shouldFilter()返回true时会执行。
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String host = request.getRemoteHost();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        log.info("Remote host:{},method:{},uri:{}", host, method, uri);
        return null;
    }
}
