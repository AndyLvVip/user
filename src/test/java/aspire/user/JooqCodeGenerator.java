package aspire.user;

import org.jooq.util.GenerationTool;
import org.junit.Test;

/**
 * @Author: andy.lv
 * @Date: created on 2018/2/5
 * @Description:
 */
public class JooqCodeGenerator {

    @Test
    public void gen() throws Exception {
        String path = this.getClass().getResource("/jooq-config.xml").toURI().getPath();
        String[] args = new String[]{path};
        GenerationTool.main(args);
    }
}
