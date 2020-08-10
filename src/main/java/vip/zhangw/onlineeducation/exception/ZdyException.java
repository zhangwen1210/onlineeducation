package vip.zhangw.onlineeducation.exception;

/**
 * @program: onlineeducation->ZdyException
 * @description:自定义异常类
 * @author: zhangwen
 * @create: 2020-08-08 10:24
 **/
public class ZdyException extends RuntimeException {
    private Integer code;
    private String msg;
    public ZdyException(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
