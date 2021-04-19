package com.ce.ribbonrule.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * 每个服务被轮询调用5次
 *
 * @author c__e
 * @date 2021/4/19 14:35
 */
public class CustomerRule extends AbstractLoadBalancerRule {
    /**
     * index 当前提供服务的机器号
     * total 总共被调用的次数，目前要求每台被调用5次
     * total = 0 // 当total==5以后，我们指针才能往下走，
     * index = 0 // 当前对外提供服务的服务器地址，
     * total需要重新置为零，但是已经达到过一个5次，我们的index = 1
     */
    private int total = 0;
    private int currentIndex = 0;

    @SuppressWarnings({"ConstantConditions"})
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            // 当前存活的服务
            List<Server> upList = lb.getReachableServers();
            // 获取全部的服务
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }
            if (total < 5) {
                server = upList.get(currentIndex);
                total++;
            } else {
                total = 0;
                currentIndex++;
                if (currentIndex >= upList.size()) {
                    currentIndex = 0;
                }
            }

            if (server == null) {
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return server;
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }
        return server;
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
