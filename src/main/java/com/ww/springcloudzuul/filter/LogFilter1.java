package com.ww.springcloudzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.bouncycastle.cert.ocsp.Req;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 必须交由spring容器管理
 */
@Component
public class LogFilter1 extends ZuulFilter {
    private static Logger logger= LoggerFactory.getLogger(LogFilter1.class);

    /**
     * 前置过滤
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器优先级 这里设置0，LogFilter2里设置1
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext= RequestContext.getCurrentContext();
        HttpServletRequest request=requestContext.getRequest();
        logger.info("logFilter1...method={},url={}",request.getMethod(),request.getRequestURL().toString());
        return null;
    }
}
