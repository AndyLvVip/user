package aspire.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "Welcome to Aspire User Service";
    }

    @RequestMapping("/authenticated")
    public String authenticated() {
        return "User authenticated!";
    }
}
