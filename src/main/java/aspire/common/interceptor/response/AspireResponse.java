package aspire.common.interceptor.response;

import aspire.user.controller.IndexController;
import aspire.user.model.UserModel;
import com.fasterxml.jackson.annotation.JsonFilter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: andy.lv
 * @Date: created on 2018/3/7
 * @Description:
 */
@JsonFilter("AspireResponse")
public class AspireResponse {

    public static final AspireResponse
            ACCESS_DENIED = new AspireResponse("403", "Access Denied"),
            ITERNAL_SERVER_ERROR = new AspireResponse("500", "Internal Server Error")
                    ;

    private String message;
    private String code;
    private boolean handled = false;

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

    public boolean handled() {
        return handled;
    }

    public void handled(boolean handled) {
        this.handled = handled;
    }


    public Map<Class<?>, Set<String>> includedFieldMaps() {
        Map<Class<?>, Set<String>> map = new HashMap<>();
        Set<String> wrapper = new HashSet<>();
        wrapper.add("code");
        wrapper.add("data");

        map.put(AspireResponse.class, wrapper);
        Set<String> corporate = new HashSet<>();
        corporate.add("name");
        corporate.add("age");
        corporate.add("users");
        map.put(IndexController.CorporateModel.class, corporate);
        return map;
    }

    public Map<Class<?>, Set<String>> excludedFieldMaps() {
        Set<String> user = new HashSet<>();
        user.add("password");
        user.add("id");

        Map<Class<?>, Set<String>> map = new HashMap<>();
        map.put(UserModel.class, user);
        return map;
    }
}
