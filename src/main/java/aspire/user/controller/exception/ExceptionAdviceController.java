package aspire.user.controller.exception;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: andy.lv
 * @Date: created on 2018/3/6
 * @Description:
 */
@ControllerAdvice
public class ExceptionAdviceController {


    public static class NotLoginException extends AccessDeniedException {
        public NotLoginException(String msg) {
            super(msg);
        }
    }

    public static class NotEnoughAccessRight extends AccessDeniedException {

        public NotEnoughAccessRight(String msg) {
            super(msg);
        }
    }

    public static class AuthenticatedResponse {

        private static final AuthenticatedResponse NOT_LOGIN = new AuthenticatedResponse("101", "没有登录"),
        NOT_ENOUGH_ACCESS_RIGHT = new AuthenticatedResponse("102", "权限不足")
        ;

        private String message;
        private String code;
        private AuthenticatedResponse (String code, String msg) {
            this.code = code;
            this.message = msg;
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

    @ExceptionHandler(NotLoginException.class)
    @ResponseBody
    public AuthenticatedResponse notLogin() {
        return AuthenticatedResponse.NOT_LOGIN;
    }

    @ExceptionHandler(NotEnoughAccessRight.class)
    @ResponseBody
    public AuthenticatedResponse notEnoughAccessRight() {
        return AuthenticatedResponse.NOT_ENOUGH_ACCESS_RIGHT;
    }
}
