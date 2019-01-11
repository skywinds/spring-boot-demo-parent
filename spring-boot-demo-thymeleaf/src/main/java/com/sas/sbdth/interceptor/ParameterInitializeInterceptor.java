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
        System.out.println("请求路径：" + request.getServletPath());
        System.out.println("preHandle start");
        // 初始化用户登陆信息
        initlizeUserAccessData(request);
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

    /**
     * 初始化用户登陆信息：包含分页信息，和UUID信息 and so on
     *
     * @param request
     */
    private void initlizeUserAccessData(HttpServletRequest request) {
        // 页码
        int index = NumberUtils.toInt(request.getParameter(PARA_PAGE), 1);
        // 每页行数
        int size = NumberUtils.toInt(request.getParameter(PARA_PAGE_SIZE), DEFAULT_PAGE_SIZE);

        PageInfo page = new PageInfo(index, size, 0);
        UserAccessDataHolder.setPage(page);
        UserAccessDataHolder.setUUID(this.createRequestUUID());
        request.setAttribute(PAGE_BEAN, page);
    }

}
