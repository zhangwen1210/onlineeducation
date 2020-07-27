package vip.zhangw.onlineeducation.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vip.zhangw.onlineeducation.util.JsonData;

/**
 * @program: onlineeducation->CustomException
 * @description: 处理全局异常,@RestControllerAdvice标记这是一个异常处理类
 * @author: zhangwen
 * @create: 2020-07-24 13:09
 **/
//@RestControllerAdvice
@ControllerAdvice
public class CustomException {

    @ExceptionHandler(value = Exception.class)
    public String handleException(){
        //return JsonData.buildError("服务器出了点问题。",-1);
        return "error";
    }
}
