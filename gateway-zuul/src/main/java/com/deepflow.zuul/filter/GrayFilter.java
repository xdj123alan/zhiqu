package com.deepflow.zuul.filter;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Configuration;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;


@Configuration
public class GrayFilter extends ZuulFilter {

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        // a filter has already forwarded
        // a filter has already determined serviceId
        return !ctx.containsKey(FORWARD_TO_KEY)
                && !ctx.containsKey(SERVICE_ID_KEY);
    }

    @Override
    public Object run()  {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        String mark = request.getHeader("gray_mark");
        if(StringUtils.isNotEmpty(mark)&& "enable".equals(mark)){
            RibbonFilterContextHolder.getCurrentContext().add("host-mark","gray-host");
        }else{
            RibbonFilterContextHolder.getCurrentContext().add("host-mark","running-host");
        }
        return null;
    }

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER -1;
    }
}
