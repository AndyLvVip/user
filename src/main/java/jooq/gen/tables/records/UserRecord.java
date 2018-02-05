/*
 * This file is generated by jOOQ.
*/
package jooq.gen.tables.records;


import java.time.LocalDateTime;

import javax.annotation.Generated;

import jooq.gen.tables.User;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record13;
import org.jooq.Row13;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserRecord extends UpdatableRecordImpl<UserRecord> implements Record13<String, String, String, String, String, String, LocalDateTime, String, String, Boolean, LocalDateTime, String, Integer> {

    private static final long serialVersionUID = 917628946;

    /**
     * Setter for <code>user.id</code>.
     */
    public void getId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>user.id</code>.
     */
    public String setId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>user.username</code>.
     */
    public void getUsername(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>user.username</code>.
     */
    public String setUsername() {
        return (String) get(1);
    }

    /**
     * Setter for <code>user.password</code>.
     */
    public void getPassword(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>user.password</code>.
     */
    public String setPassword() {
        return (String) get(2);
    }

    /**
     * Setter for <code>user.phone</code>.
     */
    public void getPhone(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>user.phone</code>.
     */
    public String setPhone() {
        return (String) get(3);
    }

    /**
     * Setter for <code>user.familyName</code>.
     */
    public void getFamilyName(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>user.familyName</code>.
     */
    public String setFamilyName() {
        return (String) get(4);
    }

    /**
     * Setter for <code>user.givenName</code>.
     */
    public void getGivenName(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>user.givenName</code>.
     */
    public String setGivenName() {
        return (String) get(5);
    }

    /**
     * Setter for <code>user.createdOn</code>.
     */
    public void getCreatedOn(LocalDateTime value) {
        set(6, value);
    }

    /**
     * Getter for <code>user.createdOn</code>.
     */
    public LocalDateTime setCreatedOn() {
        return (LocalDateTime) get(6);
    }

    /**
     * Setter for <code>user.createdBy</code>.
     */
    public void getCreatedBy(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>user.createdBy</code>.
     */
    public String setCreatedBy() {
        return (String) get(7);
    }

    /**
     * Setter for <code>user.email</code>.
     */
    public void getEmail(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>user.email</code>.
     */
    public String setEmail() {
        return (String) get(8);
    }

    /**
     * Setter for <code>user.isObsolete</code>.
     */
    public void getIsObsolete(Boolean value) {
        set(9, value);
    }

    /**
     * Getter for <code>user.isObsolete</code>.
     */
    public Boolean setIsObsolete() {
        return (Boolean) get(9);
    }

    /**
     * Setter for <code>user.updatedOn</code>.
     */
    public void getUpdatedOn(LocalDateTime value) {
        set(10, value);
    }

    /**
     * Getter for <code>user.updatedOn</code>.
     */
    public LocalDateTime setUpdatedOn() {
        return (LocalDateTime) get(10);
    }

    /**
     * Setter for <code>user.updatedBy</code>.
     */
    public void getUpdatedBy(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>user.updatedBy</code>.
     */
    public String setUpdatedBy() {
        return (String) get(11);
    }

    /**
     * Setter for <code>user.version</code>.
     */
    public void getVersion(Integer value) {
        set(12, value);
    }

    /**
     * Getter for <code>user.version</code>.
     */
    public Integer setVersion() {
        return (Integer) get(12);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record13 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row13<String, String, String, String, String, String, LocalDateTime, String, String, Boolean, LocalDateTime, String, Integer> fieldsRow() {
        return (Row13) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row13<String, String, String, String, String, String, LocalDateTime, String, String, Boolean, LocalDateTime, String, Integer> valuesRow() {
        return (Row13) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return User.USER.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return User.USER.USERNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return User.USER.PASSWORD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return User.USER.PHONE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return User.USER.FAMILYNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return User.USER.GIVENNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDateTime> field7() {
        return User.USER.CREATEDON;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return User.USER.CREATEDBY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return User.USER.EMAIL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field10() {
        return User.USER.ISOBSOLETE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDateTime> field11() {
        return User.USER.UPDATEDON;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field12() {
        return User.USER.UPDATEDBY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field13() {
        return User.USER.VERSION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return setId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return setUsername();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return setPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return setPhone();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return setFamilyName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return setGivenName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime component7() {
        return setCreatedOn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return setCreatedBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component9() {
        return setEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component10() {
        return setIsObsolete();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime component11() {
        return setUpdatedOn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component12() {
        return setUpdatedBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component13() {
        return setVersion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return setId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return setUsername();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return setPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return setPhone();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return setFamilyName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return setGivenName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime value7() {
        return setCreatedOn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return setCreatedBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return setEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value10() {
        return setIsObsolete();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime value11() {
        return setUpdatedOn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value12() {
        return setUpdatedBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value13() {
        return setVersion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value1(String value) {
        getId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value2(String value) {
        getUsername(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value3(String value) {
        getPassword(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value4(String value) {
        getPhone(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value5(String value) {
        getFamilyName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value6(String value) {
        getGivenName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value7(LocalDateTime value) {
        getCreatedOn(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value8(String value) {
        getCreatedBy(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value9(String value) {
        getEmail(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value10(Boolean value) {
        getIsObsolete(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value11(LocalDateTime value) {
        getUpdatedOn(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value12(String value) {
        getUpdatedBy(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value13(Integer value) {
        getVersion(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord values(String value1, String value2, String value3, String value4, String value5, String value6, LocalDateTime value7, String value8, String value9, Boolean value10, LocalDateTime value11, String value12, Integer value13) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserRecord
     */
    public UserRecord() {
        super(User.USER);
    }

    /**
     * Create a detached, initialised UserRecord
     */
    public UserRecord(String id, String username, String password, String phone, String familyname, String givenname, LocalDateTime createdon, String createdby, String email, Boolean isobsolete, LocalDateTime updatedon, String updatedby, Integer version) {
        super(User.USER);

        set(0, id);
        set(1, username);
        set(2, password);
        set(3, phone);
        set(4, familyname);
        set(5, givenname);
        set(6, createdon);
        set(7, createdby);
        set(8, email);
        set(9, isobsolete);
        set(10, updatedon);
        set(11, updatedby);
        set(12, version);
    }
}
