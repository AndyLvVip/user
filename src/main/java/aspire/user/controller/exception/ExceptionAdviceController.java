package aspire.user.controller.exception;

import aspire.common.interceptor.response.AspireResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOG = LoggerFactory.getLogger(ExceptionAdviceController.class);

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public AspireResponse accessDenied(AccessDeniedException ex) {
        LOG.error(ex.getMessage(), ex);
        return AspireResponse.ACCESS_DENIED;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public AspireResponse globalException(Exception ex) {
        LOG.error(ex.getMessage(), ex);
        return AspireResponse.INTERNAL_SERVER_ERROR;
    }

}
