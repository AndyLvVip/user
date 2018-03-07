package aspire.common.interceptor.response;

/**
 * @Author: andy.lv
 * @Date: created on 2018/3/7
 * @Description:
 */
public class AspireResponse {

    public static final AspireResponse
            ACCESS_DENIED = new AspireResponse("403", "Access Denied"),
            ITERNAL_SERVER_ERROR = new AspireResponse("500", "Internal Server Error")
                    ;

    private String message;
    private String code;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private Object data;
    private AspireResponse(String code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public static AspireResponse ok(Object data) {
        AspireResponse resp = new AspireResponse("200", "Success");
        resp.setData(data);
        return resp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
