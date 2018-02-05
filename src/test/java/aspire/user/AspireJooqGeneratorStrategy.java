package aspire.user;

import org.jooq.util.DefaultGeneratorStrategy;
import org.jooq.util.Definition;

/**
 * @Author: andy.lv
 * @Date: created on 2017/11/29
 * @Description:
 */
public class AspireJooqGeneratorStrategy extends DefaultGeneratorStrategy {
    @Override
    public String getJavaGetterName(Definition definition, Mode mode) {
        return new StringBuilder()
                .append("set")
                .append(definition.getOutputName().substring(0, 1).toUpperCase())
                .append(definition.getOutputName().substring(1))
                .toString()
                ;
    }

    @Override
    public String getJavaSetterName(Definition definition, Mode mode) {
        return new StringBuilder()
                .append("get")
                .append(definition.getOutputName().substring(0, 1).toUpperCase())
                .append(definition.getOutputName().substring(1))
                .toString()
                ;
    }
}
