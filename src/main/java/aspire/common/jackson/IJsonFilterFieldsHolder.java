package aspire.common.jackson;

import java.util.Map;
import java.util.Set;

public interface IJsonFilterFieldsHolder {

    Map<Class<?>, Set<String>> includedFieldsMap();

    Map<Class<?>, Set<String>> excludedFieldsMap();
}
