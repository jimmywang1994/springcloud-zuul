package com.ww.springcloudzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class RouteFilter extends ZuulFilter {
    private static Logger logger= LoggerFactory.getLogger(LogFilter2.class);

    @Override
    public String filterType() {
        return "route";
    }

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
        logger.info("routeFilter...method={},url={}",request.getMethod(),request.getRequestURL().toString());
        return null;
    }
}
