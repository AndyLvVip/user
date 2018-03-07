package aspire.common.interceptor;

import aspire.common.interceptor.response.AspireResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

/**
 * @Author: andy.lv
 * @Date: created on 2018/3/7
 * @Description:
 */
@Aspect
@Service
public class GlobalInterceptor {
    @Around("within(aspire.user.controller.*) && (" +
                "@target(org.springframework.web.bind.annotation.RestController) || " +
                "(@annotation(org.springframework.web.bind.annotation.RequestMapping) && @annotation(org.springframework.web.bind.annotation.ResponseBody))" +
            ")")
    public Object wrapResponse(final ProceedingJoinPoint jp) throws Throwable {
        Object realResult = jp.proceed(jp.getArgs());
        return AspireResponse.ok(realResult);
    }
}
