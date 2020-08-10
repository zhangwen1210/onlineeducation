package vip.zhangw.onlineeducation.util;

/**
 * @program: onlineeducation->JsonData
 * @description: 统一开发接口返回规范
 * @author: zhangwen
 * @create: 2020-07-23 20:20
 **/
public class JsonData {
    /**
     * 状态码，0表示成功，1表示处理中，-1表示失败
     */
    private int code;

    /**
     *业务数据
     */
    private Object data;

    /**
     *错误信息描述
     */
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

    /**
     *成功的，不用返回业务数据
     * @param
     * @return
     */
    public static JsonData buildSuccess(){
        return new JsonData(0,null, null);
    }

    /**
     *成功的，返回业务数据及状态码 0
     * @param data
     * @return
     */
    public static JsonData buildSuccess(Object data){
        return new JsonData(0, data,null);
    }

    /**
     *失败，返回错误描述
     * @param msg
     * @return
     */
    public static JsonData buildError(String msg){
        return new JsonData(-1,null,msg);
    }

    /**
     *失败，自定义错误码，需要和前端统一约定
     * @param msg
     * @param code
     * @return
     */
    public static JsonData buildError(String msg,int code){
        return new JsonData(code,null,msg);
    }
}
