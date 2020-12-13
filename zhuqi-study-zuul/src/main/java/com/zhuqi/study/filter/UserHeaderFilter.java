package com.zhuqi.study.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author zhuqi
 * @date create at 2019/5/22 10:59
 */
@Component
public class UserHeaderFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(UserHeaderFilter.class);

    @Override
    public String filterType() {
        return "pre";
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
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();

        final String name = ctx.getRequest().getParameter("username");

        /**
         * 下面这行代码如果name里面以 “渊”或者"昊"字结尾，那请求就会报400。
         */
        ctx.addZuulRequestHeader("username", name);
        return null;
    }

}
