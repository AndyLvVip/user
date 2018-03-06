package aspire.user.repository.factory;

import aspire.common.repository.BaseRepository;
import aspire.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: andy.lv
 * @Date: created on 2018/3/6
 * @Description:
 */
@Component
public class Repositories {

    private static UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository repository) {
        userRepository = repository;
    }
    public static UserRepository userRepository() {
        return userRepository;
    }


    private static BaseRepository baseRepository;
    @Autowired
    public void setBaseRepository(BaseRepository repository) {
        baseRepository = repository;
    }

    public static BaseRepository baseRepository() {
        return baseRepository;
    }
}
