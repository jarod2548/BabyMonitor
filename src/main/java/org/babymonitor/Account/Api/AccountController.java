package org.babymonitor.Account.API;

import org.babymonitor.Account.DTO.LoginDTO;
import org.babymonitor.Account.Service.LoginService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final LoginService loginService;

    public AccountController(LoginService loginService)
    {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO)
    {
        return loginService.login(loginDTO);
    }
}