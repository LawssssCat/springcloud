package com.spring.sp011.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.spring.sp01.util.JsonResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AccessFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		// 对指定的 serviceid 过滤，如果要过滤所有服务，直接返回true
		RequestContext context = RequestContext.getCurrentContext();
		Object serviceId = context.get(FilterConstants.SERVICE_ID_KEY);
		if ("item-service".equals(serviceId)) {
			return true;
		}
		return false;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		String token = request.getParameter("token");
		log.info("token={}", token);
		if (token == null) {
			// 此设置会阻止请求被路由到后台微服务
			context.setSendZuulResponse(false);
			// 向哭护短的响应
			int code = HttpStatus.OK.value();
			context.setResponseStatusCode(code);
			String body = JsonResult.err().code(JsonResult.NOT_LOGIN).toString();
			context.setResponseBody(body);
		}

		// zull 过滤器返回的数据设计为以后扩展使用
		// 目前该返回值没有被使用
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		// 该过滤器顺序要 > 5，才能得到 serviceId
		return FilterConstants.PRE_DECORATION_FILTER_ORDER+1;
	}

}
