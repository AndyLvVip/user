package aspire.common.factory;

import aspire.common.model.BaseModel;

/**
 * @Author: andy.lv
 * @Date: created on 2018/2/5
 * @Description:
 */
public interface ModelFactory<T extends BaseModel> {

    T create();

}
