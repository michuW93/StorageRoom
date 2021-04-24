package security.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @PostMapping("/user")
    public void endpointForUser() {}

    @PostMapping("/admin")
    public void endpointForAdmin() {}

}
