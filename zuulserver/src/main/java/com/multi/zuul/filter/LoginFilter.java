package com.multi.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.FORM_BODY_WRAPPER_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
/**
 * @author by multi.xp
 * @version V1.0
 * @date 2019/12/4 21:08
 * @description:
 */
@Component
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        // 在zuul内置过滤器后执行
        return FORM_BODY_WRAPPER_FILTER_ORDER + 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 获取上下文(Request域)
        RequestContext cxt = RequestContext.getCurrentContext();
        // 获取Request
        HttpServletRequest cxtRequest = cxt.getRequest();
        // 获取请求参数
        String token = cxtRequest.getParameter("access-token");
        if (!"admin".equals(token)) {
            // 未登录拦截
            cxt.setSendZuulResponse(false);
            // 返回错误状态码
            cxt.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        // 什么都不做放行
        return null;
    }
}
