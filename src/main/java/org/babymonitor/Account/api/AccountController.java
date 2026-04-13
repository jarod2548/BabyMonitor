package org.babymonitor.Account.api;

import org.babymonitor.config.UserPrincipal;
import org.springframework.http.HttpStatus;
import org.babymonitor.Account.model.*;
import org.babymonitor.Account.service.*;
import org.babymonitor.config.CookieService;
import org.babymonitor.config.JWTService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/account")
public class AccountController {

    //
    private final AccountService accountService;
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

    @PostMapping
    public ResponseEntity<String> CreateAccount(@RequestBody @Valid AccountDTO account) {
        Account savedAccount = accountService.createAccount(account.convert());

        if (savedAccount != null) {
            return ResponseEntity.status(201).body("Account created successfully");
        }

        return ResponseEntity.status(500).body("Internal server error");
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
                .body("Login Successful");
    }

    @GetMapping("/auth")
    public ResponseEntity<LoginResponseDTO> authorize(@AuthenticationPrincipal UserPrincipal user){
        if(user == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        LoginResponseDTO response = new LoginResponseDTO(user);
        return ResponseEntity.ok(response);
    }

    @PatchMapping
    public ResponseEntity<String> ChangePassword(@RequestBody @Valid PasswordDTO passwordDTO) {
        Account account = accountService.findAccount(id);

        Account updated = accountService.changePassword(
                account,
                passwordDTO.getOldpassword(),
                passwordDTO.getnewpassword());

        if (updated != null) {
            return ResponseEntity.ok("Password changed successfully");
        }

        return ResponseEntity.badRequest().body("Password change failed");
    }
}
