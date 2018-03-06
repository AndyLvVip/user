package aspire.user.model;

import aspire.common.spring.SpringContextUtils;
import aspire.common.utils.MyStringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.DependsOn;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.*;

/**
 * @Author: andy.lv
 * @Date: created on 2018/2/6
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestUser {

    @Test
    public void insert() {
        UserModel user = new UserModel();
        user.setEmail("abc@efg.com");
        user.setNickname("紫陌红尘");
        user.setPhone("13800138000");
        user.setUsername("andy");
        user.setPassword(DigestUtils.md5Hex("123456"));
        user.insert("andy");
    }

    @Test
    public void fetch() {
        UserModel.fetchEntry("ffeee287f24c4c7182e040a03bf076a7");
    }

    @Test
    public void concurrentFetch() throws InterruptedException {
        int threads = 10;
        CyclicBarrier barrier = new CyclicBarrier(threads);
        ExecutorService service = Executors.newCachedThreadPool();
        for(int i = 0; i < threads; i++) {
            service.submit(() -> {
                for(int j = 0; j < 10000; j++) {
                    try {
                        barrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    fetch();
                }
            });
        }
        service.shutdown();
        service.awaitTermination(10, TimeUnit.MINUTES);
    }
}
