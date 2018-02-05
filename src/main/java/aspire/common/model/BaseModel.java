package aspire.common.model;

import aspire.common.repository.BaseRepository;
import org.jooq.Table;
import org.jooq.UpdatableRecord;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: andy.lv
 * @Date: created on 2018/2/5
 * @Description:
 */
public abstract class BaseModel implements Serializable {

    public abstract <R extends UpdatableRecord> Table<R> table();

    public void batchInsert(List<? extends BaseModel> models) {
        BaseRepository.INSTANCE.batchInsert(models);
    }

    public void insert() {
        BaseRepository.INSTANCE.insert(this);
    }

    public void update() {
        BaseRepository.INSTANCE.update(this);
    }

    public void delete() {
        BaseRepository.INSTANCE.delete(this);
    }

    public <T extends BaseModel> T fetchEntry(Class<T> returnType, String id) {
        return BaseRepository.INSTANCE.fetchEntry(returnType, id);
    }

}
