package aspire.common.jackson;

import aspire.common.interceptor.response.AspireResponse;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;

import java.util.Set;

/**
 * @Author: andy.lv
 * @Date: created on 2018/3/9
 * @Description:
 */
public class AspireJsonFilterProvider extends FilterProvider {

    public static final AspireJsonFilterProvider INSTANCE = new AspireJsonFilterProvider();

    private static final ThreadLocal<AspireResponse> ASPIRE_RESPONSE_THREAD_LOCAL = new ThreadLocal<>();

    @Override
    public BeanPropertyFilter findFilter(Object filterId) {
        throw new UnsupportedOperationException("Unexpected invocation!");
    }

    @Override
    public PropertyFilter findPropertyFilter(Object filterId, Object valueToFilter) {
        System.out.println("AspireJsonFilterProvider.findPropertyFilter: " + this);
        return new SimpleBeanPropertyFilter() {


            @Override
            public void serializeAsField(Object pojo, JsonGenerator jgen, SerializerProvider provider, PropertyWriter writer) throws Exception {
                System.out.println("SimpleBeanPropertyFilter.serializeAsField: " + this);
                if(pojo instanceof AspireResponse && !((AspireResponse) pojo).handled()) {
                    ((AspireResponse) pojo).handled(true);
                    ASPIRE_RESPONSE_THREAD_LOCAL.set((AspireResponse) pojo);
                }

                if (include(pojo, writer)) {
                    writer.serializeAsField(pojo, jgen, provider);
                } else if (!jgen.canOmitFields()) { // since 2.3
                    writer.serializeAsOmittedField(pojo, jgen, provider);
                }
            }

            private boolean include(Object pojo, PropertyWriter writer) {
                if(null != ASPIRE_RESPONSE_THREAD_LOCAL.get().includedFieldMaps()) {
                    Set<String> includedFields = ASPIRE_RESPONSE_THREAD_LOCAL.get().includedFieldMaps().get(pojo.getClass());
                    if(null != includedFields)
                        return includedFields.contains(writer.getName());
                }
                if(null != ASPIRE_RESPONSE_THREAD_LOCAL.get().excludedFieldMaps()) {
                    Set<String> excludedFields = ASPIRE_RESPONSE_THREAD_LOCAL.get().excludedFieldMaps().get(pojo.getClass());
                    if(null != excludedFields)
                        return !excludedFields.contains(writer.getName());
                }
                return true;
            }
        };
    }


}
