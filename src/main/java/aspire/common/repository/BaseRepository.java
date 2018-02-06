package aspire.common.repository;

import aspire.common.exception.AspireException;
import aspire.common.model.BaseModel;
import aspire.common.spring.SpringContextUtils;
import org.apache.commons.lang.StringUtils;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Table;
import org.jooq.UpdatableRecord;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: andy.lv
 * @Date: created on 2018/2/5
 * @Description:
 */
public class BaseRepository {

    public static final BaseRepository INSTANCE = new BaseRepository();

    protected BaseRepository() {

    }

    private static class DSLContextHolder {
        private static final DSLContext DSL_CONTEXT = instance();

        private static DSLContext instance() {
            return SpringContextUtils.getBean("dsl", DSLContext.class);
        }
    }

    protected static DSLContext dsl() {
        return DSLContextHolder.DSL_CONTEXT;
    }

    /**
     * Added by andy.lv on 20171109
     * @param models
     */
    public void batchInsert(List<? extends BaseModel> models) {
        if(!models.isEmpty()) {
            Table<UpdatableRecord> t = models.get(0).table();
            List<Record> records = new ArrayList<>(models.size());
            for(BaseModel m : models)
                records.add(dsl().newRecord(t, m));
            try {
                dsl().loadInto(t).bulkAll().loadRecords(records).fields(t.fields()).execute();
            } catch (IOException e) {
                throw new AspireException(AspireException.Error.INTERNAL_SERVER_ERROR, "batch insert exception");
            }
        }
    }

    /**
     * Added by andy.lv on 20171109
     */
    public void insert(BaseModel model) {
        UpdatableRecord r = dsl().newRecord(model.table(), model);
        r.insert();
    }

    /**
     * Added by andy.lv on 20171109
     */
    public void update(BaseModel model) {
        UpdatableRecord r = dsl().newRecord(model.table(), model);
        r.update();
    }

    /**
     * Added by andy.lv on 20171109
     */
    public void delete(BaseModel model) {
        UpdatableRecord r = dsl().newRecord(model.table(), model);
        r.delete();
    }

    private <T extends BaseModel> T createModel(Class<T> returnType) {
        try {
            return returnType.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new AspireException(e);
        }
    }

    public <T extends BaseModel> T fetchEntry(Class<T> returnType, String id) {
        if(StringUtils.isEmpty(id))
            throw new AspireException(AspireException.Error.PARAM_ERROR, "id can not be null");
        T model = createModel(returnType);
        T t = dsl().select(model.table().fields()).from(model.table()).where(model.table().field(model.table().getPrimaryKey().getFieldsArray()[0].getName(), String.class).eq(id)).fetchOneInto(returnType);
        if(t == null)
            throw new AspireException(AspireException.Error.PARAM_ERROR, "can not found the record by pk->" + id);
        return t;
    }
}
