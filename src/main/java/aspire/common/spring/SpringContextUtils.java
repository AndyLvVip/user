package aspire.common.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @Author: andy.lv
 * @Date: created on 2018/2/5
 * @Description:
 */
@Component(SpringContextUtils.BEAN_NAME)
public class SpringContextUtils {

    public static final String BEAN_NAME = "springContext";
    private static ApplicationContext applicationContext;
    private static final Logger LOG = LoggerFactory.getLogger(SpringContextUtils.class);
    public static final String INIT_AS_SINGLETON_LABEL = "[INIT_AS_SINGLETON]->";

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static <T> T getBean(String name, Class<T> requiredType) {
        return applicationContext.getBean(name, requiredType);
    }

    public static <T> T getBean(Class<T> requiredType) {
        return applicationContext.getBean(requiredType);
    }

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext){
        LOG.debug(INIT_AS_SINGLETON_LABEL + this.getClass().getSimpleName());
        SpringContextUtils.applicationContext = applicationContext;
    }
}
