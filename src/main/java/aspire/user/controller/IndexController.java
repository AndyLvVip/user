package aspire.user.controller;

import aspire.common.base.DbArrayList;
import aspire.user.model.UserModel;
import com.fasterxml.jackson.annotation.JsonFilter;
import jooq.gen.tables.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IndexController {

    @RequestMapping("/")
    public Object index() {
        return "Welcome to Aspire User Service";
    }

    @RequestMapping("/authenticated")
    @Secured("149_23")
    public Object authenticated() {
        return "User authenticated!";
    }


    @JsonFilter("AspireResponse")
    public static class CorporateModel {
        private String name;
        private Integer age;
        private Double price;
        private List<UserModel> users;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public List<UserModel> getUsers() {
            return users;
        }

        public void setUsers(List<UserModel> users) {
            this.users = users;
        }
    }

    @RequestMapping("userList")
    public Object userList() {
        CorporateModel corporateA = new CorporateModel();
        corporateA.setAge(10);
        corporateA.setPrice(20.1);
        corporateA.setName("Corporate A");
        UserModel user = UserModel.fetchEntryByUserName("andy");
        List<UserModel> users = new ArrayList<>();
        users.add(user);
        corporateA.setUsers(users);
        return corporateA;
    }
}
