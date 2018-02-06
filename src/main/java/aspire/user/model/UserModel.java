package aspire.user.model;

import aspire.common.model.BaseModel;
import org.jooq.Table;
import org.jooq.UpdatableRecord;

import static jooq.gen.Tables.USER;

/**
 * @Author: andy.lv
 * @Date: created on 2018/2/6
 * @Description:
 */
public class UserModel extends BaseModel {

    private String username;

    private String password;

    private String phone;

    private String familyName;

    private String givenName;

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

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
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
}
