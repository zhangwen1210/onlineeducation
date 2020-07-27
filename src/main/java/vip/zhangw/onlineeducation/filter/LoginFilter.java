package vip.zhangw.onlineeducation.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;
import vip.zhangw.onlineeducation.domain.User;
import vip.zhangw.onlineeducation.service.impl.UserServiceImpl;
import vip.zhangw.onlineeducation.util.JsonData;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: onlineeducation->LoginFilter
 * @description:登录过滤器
 * @author: zhangwen
 * @create: 2020-07-25 09:24
 **/
//@WebFilter(filterName = "LoginFilter", urlPatterns = "/api/v1/pri/*")
public class LoginFilter implements Filter {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init LoginFilter...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter LoginFilter...");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String token = request.getHeader("token");
        if (token == null || "".equals(token)){
            token = request.getParameter("token");
        }
        if (StringUtils.isEmpty(token)){
            // 没有token，尚未登录
            JsonData jsonData = JsonData.buildError("尚未登录！", -2);
            String jsonStr = objectMapper.writeValueAsString(jsonData);
            renderJson(response, jsonStr);
        }else {
            // 判断 token 是否合法
            User user = UserServiceImpl.sessionMap.get(token);
            if (user != null){
                //token验证通过
                filterChain.doFilter(servletRequest, servletResponse);
            }else {
                // 有token 但是不合法，无法根据token获取对应用户信息
                JsonData jsonData = JsonData.buildError("token不合法！", -3);
                String jsonStr = objectMapper.writeValueAsString(jsonData);
                renderJson(response, jsonStr);
            }
        }
    }

    /**
     * 渲染json字符串回前端
     * @param response
     * @param json
     */
    public void renderJson(HttpServletResponse response, String json){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        try {
            PrintWriter printWriter = response.getWriter();
            printWriter.print(json);
            printWriter.flush();
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        System.out.println("destroy LoginFilter...");
    }
}
