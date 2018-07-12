package org.timer;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description
 * @Author: Administrator
 * @Date : 2018/7/12 17 17
 */
public class AccessFilter extends ZuulFilter{

    private static Logger logger = LoggerFactory.getLogger(AccessFilter.class);
    /**
     *  该函数需要返回一个字符串来代表过滤器的类型，而这个类型就是在HTTP请求过程中定义的各个阶段。在Zuul中默认定义了四种不同生命周期的过滤器类型，具体如下
     *   pre：可以在请求被路由之前调用。
         routing：在路由请求时候被调用。
         post：在routing和error过滤器之后被调用。
         error：处理请求时发生错误时被调用。
     *
     */
    @Override
    public String filterType() {
        return "pre";
    }

    //通过int值来定义过滤器的执行顺序，数值越小优先级越高。
    @Override
    public int filterOrder() {
        return 0;
    }

    //返回一个boolean类型来判断该过滤器是否要执行。我们可以通过此方法来指定过滤器的有效范围。
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //过滤器的具体逻辑
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
        Object accessToken = request.getParameter("accessToken");
        if(accessToken == null){
            logger.warn("accessToken is null");
            ctx.setResponseStatusCode(401);
            ctx.setSendZuulResponse(false);
            return null;
        }
        return null;
    }
}
