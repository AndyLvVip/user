package aspire.user.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
