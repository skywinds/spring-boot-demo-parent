package com.sas.sbdth.interceptor;

import com.sas.sbdth.commons.PageInfo;
import com.sas.sbdth.commons.UserAccessDataHolder;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.sas.sbdth.commons.WebNamingConstant.*;

@Component
public class ParameterInitializeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String paraPage = request.getParameter(PARA_PAGE);
        int index = NumberUtils.toInt(paraPage, 1);
        String paraSize = request.getParameter(PARA_PAGE_SIZE);
        int size = NumberUtils.toInt(paraSize, DEFAULT_PAGE_SIZE);
        PageInfo page = new PageInfo(index, size, 0);
        UserAccessDataHolder.setPage(page);
        UserAccessDataHolder.setUUID(this.createRequestUUID());
        // printThreadLocalInfo("PreHandle After Set PageInfo");
        request.setAttribute(PAGE_BEAN, page);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserAccessDataHolder.unbind();
    }

    private String createRequestUUID() {
        StringBuilder uuidBuilder = new StringBuilder()
                .append(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()))
                .append("_").append(Math.round(100000 + Math.random() * (999999 - 100000)));
        return uuidBuilder.toString();
    }
}
