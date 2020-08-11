package vip.zhangw.onlineeducation.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
//@ControllerAdvice
@RestControllerAdvice
public class CustomException {

    private final static Logger logger = LoggerFactory.getLogger(CustomException.class);

    @ExceptionHandler(value = Exception.class)
    public JsonData handleException(Exception e){
        logger.error("[ 系统异常 ]{} " + e.getMessage());
        if( e instanceof ZdyException ){
            ZdyException zdyException = (ZdyException) e;
            return JsonData.buildError(zdyException.getMsg(),zdyException.getCode());
        }else {
            return JsonData.buildError("全局异常，未知错误");
        }
    }

}
