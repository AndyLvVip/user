package aspire.user.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "Welcome to Aspire User Service";
    }

    @RequestMapping("/authenticated")
    @Secured("149_23")
    public String authenticated() {
        return "User authenticated!";
    }
}
