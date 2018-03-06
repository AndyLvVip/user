package aspire.user.repository;

import aspire.common.repository.BaseRepository;
import aspire.user.model.UserModel;
import org.springframework.stereotype.Repository;

import static jooq.gen.tables.User.USER;

@Repository
public class UserRepository extends BaseRepository {

    public UserModel fetchEntryByUserName(String username) {
        return dsl().select(USER.fields())
                .from(USER)
                .where(USER.USERNAME.eq(username)).fetchOneInto(UserModel.class);
    }
}
