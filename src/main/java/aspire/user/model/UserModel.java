package aspire.user.model;

import aspire.common.model.BaseModel;
import aspire.user.repository.UserRepository;
import aspire.user.repository.factory.Repositories;
import com.fasterxml.jackson.annotation.JsonFilter;
import org.jooq.Table;
import org.jooq.UpdatableRecord;

import static jooq.gen.Tables.USER;

/**
 * @Author: andy.lv
 * @Date: created on 2018/2/6
 * @Description:
 */
@JsonFilter("AspireResponse")
public class UserModel extends BaseModel {

    private String username;

    private String password;

    private String phone;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    private String nickname;

    private String email;

    private Boolean isObsolete;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsObsolete() {
        return isObsolete;
    }

    public void setIsObsolete(Boolean obsolete) {
        isObsolete = obsolete;
    }

    @Override
    public <R extends UpdatableRecord> Table<R> table() {
        return (Table<R>) USER;
    }

    public static UserModel fetchEntry(String id) {
        return fetchEntry(UserModel.class, id);
    }

    @Override
    public void insert(String createdBy) {
        setIsObsolete(false);
        super.insert(createdBy);
    }

    public static UserModel fetchEntryByUserName(String username) {
        return Repositories.userRepository().fetchEntryByUserName(username);
    }
}
