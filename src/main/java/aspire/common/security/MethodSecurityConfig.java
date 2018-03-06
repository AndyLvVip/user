package aspire.common.security;

import aspire.user.controller.exception.ExceptionAdviceController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.util.CollectionUtils;

import java.math.BigInteger;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: andy.lv
 * @Date: created on 2018/2/24
 * @Description:
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(MethodSecurityConfig.class);


    private final AtomicInteger counter = new AtomicInteger(0);

    @Override
    protected AccessDecisionManager accessDecisionManager() {
        return new AccessDecisionManager() {
            @Override
            public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {

                if(counter.getAndIncrement() % 2 == 0) {
                    throw new ExceptionAdviceController.NotEnoughAccessRight("权限不够");
                }else {
                    throw new ExceptionAdviceController.NotLoginException("未登录");
                }

//                if(CollectionUtils.isEmpty(authentication.getAuthorities()) || (authentication.getAuthorities().toArray(new SummaryGrantedAuthority[0])[0]).getAuthorityList().size() != 24
//                        || CollectionUtils.isEmpty(collection) || collection.size() < 1)
//                    throw new InsufficientAuthenticationException(authentication.getName() + " is insufficient authentication");
//
//                String requiredAuthority = collection.iterator().next().getAttribute();
//                String menuId = requiredAuthority.split("_")[0];
//                String rightCode = requiredAuthority.split("_")[1];
//                SummaryGrantedAuthority authorityObj = (SummaryGrantedAuthority) authentication.getAuthorities().iterator().next();
//                BigInteger authority = new BigInteger(authorityObj.getAuthorityList().get(Integer.parseInt(rightCode)));
//                if(!authority.testBit(Integer.parseInt(menuId)))
//                    throw new AccessDeniedException(authentication.getName() + " is denied for the access");
            }

            @Override
            public boolean supports(ConfigAttribute configAttribute) {
                return true;
            }

            @Override
            public boolean supports(Class<?> aClass) {
                return true;
            }
        };
    }
}
