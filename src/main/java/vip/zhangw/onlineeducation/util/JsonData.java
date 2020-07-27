package vip.zhangw.onlineeducation.util;

/**
 * @program: onlineeducation->JsonData
 * @description: 统一开发接口返回规范
 * @author: zhangwen
 * @create: 2020-07-23 20:20
 **/
public class JsonData {
    private int code;
    private Object data;
    private String msg;
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public JsonData(){

    }
    public JsonData(int code, Object data){
        this.code = code;
        this.data = data;
    }
    public JsonData(int code, Object data, String msg){
        this.code = code;
        this.data =data;
        this.msg = msg;
    }
    public static JsonData buildSuccess(Object data){
        return new JsonData(0,data);
    }
    public static JsonData buildError(String msg){
        return new JsonData(-1,"",msg);
    }
    public static JsonData buildError(String msg,int code){
        return new JsonData(code,"",msg);
    }
}
