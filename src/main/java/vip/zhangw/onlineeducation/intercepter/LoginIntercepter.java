package vip.zhangw.onlineeducation.intercepter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import vip.zhangw.onlineeducation.util.JsonData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @program: onlineeducation->LoginIntercepter
 * @description: 登录拦截器
 * @author: zhangwen
 * @create: 2020-07-27 17:08
 **/
public class LoginIntercepter implements HandlerInterceptor {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("LoginIntercepter preHandle======");
        String token = request.getHeader("token");
        if (token == null || "".equals(token)){
            token = request.getParameter("token");
        }
        if (StringUtils.isEmpty(token)){
            // 没有token，尚未登录
            JsonData jsonData = JsonData.buildError("尚未登录！", -2);
            String jsonStr = objectMapper.writeValueAsString(jsonData);
            renderJson(response, jsonStr);
            return false;
        }else {
            // 判断 token 是否合法
            /*User user = UserServiceImpl.sessionMap.get(token);
            if (user != null){
                //token验证通过
                return true;
            }else {
                // 有token 但是不合法，无法根据token获取对应用户信息
                JsonData jsonData = JsonData.buildError("token不合法！", -3);
                String jsonStr = objectMapper.writeValueAsString(jsonData);
                renderJson(response, jsonStr);
                return false;
            }*/
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("LoginIntercepter postHandle======");

    }

    /**
     * 渲染json字符串回前端
     * @param response
     * @param json
     */
    public void renderJson(HttpServletResponse response, String json){
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
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
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("LoginIntercepter afterCompletion======");
    }
}
