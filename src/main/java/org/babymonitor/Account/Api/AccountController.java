package org.babymonitor.Account.API;

import org.babymonitor.Account.DTO.LoginDTO;
import org.babymonitor.Account.Model.Account;
import org.babymonitor.Account.Service.AccountService;
import org.babymonitor.Account.Service.LoginService;
import org.babymonitor.config.CookieService;
import org.babymonitor.config.JWTService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    private AccountService accountService;
    private final LoginService loginService;
    private final JWTService jwtService;
    private final CookieService cookieService;

    public AccountController(LoginService loginService,
                             AccountService AccountService,
                             JWTService JWTService,
                             CookieService CookieService)
    {
        this.loginService = loginService;
        this.accountService = AccountService;
        this.jwtService = JWTService;
        this.cookieService = CookieService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO)
    {
        Account model = loginDTO.convert();
        Account data = loginService.login(model);

        String token = jwtService.generateToken(data);

        return ResponseEntity.ok().header("Set-Cookie",
                        cookieService.createJwtCookie(token)
                                .toString())
                .body("Login Succesful");
    }
}