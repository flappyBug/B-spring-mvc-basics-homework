package com.thoughtworks.capacity.gtb.mvc.api;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import com.thoughtworks.capacity.gtb.mvc.util.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RestController
@Validated
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    void register(@RequestBody @Valid User user) {
        userService.register(user);
    }

    @GetMapping("/login")
    User login(@RequestParam @Pattern(regexp = "[\\w\\d_]{3,10}", message = ErrorMessage.INVALID_USERNAME) String username,
               @RequestParam @Size(min = 5, max = 12, message = ErrorMessage.INVALID_PASSWORD) String password) {
        return userService.login(username, password);
    }
}
