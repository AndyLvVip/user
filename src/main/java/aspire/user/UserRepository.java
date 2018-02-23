package aspire.user;

import aspire.common.repository.BaseRepository;
import aspire.user.model.UserModel;

import static jooq.gen.tables.User.USER;

public class UserRepository extends BaseRepository {
    public static UserRepository INSTANCE = new UserRepository();

    public UserModel fetchEntryByUserName(String username) {
        return dsl().select(USER.fields())
                .from(USER)
                .where(USER.USERNAME.eq(username)).fetchOneInto(UserModel.class);
    }
}
