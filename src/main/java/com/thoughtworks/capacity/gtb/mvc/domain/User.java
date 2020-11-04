package com.thoughtworks.capacity.gtb.mvc.domain;

import com.thoughtworks.capacity.gtb.mvc.util.ErrorMessage;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class User {
    private Integer id;

    @NotNull(message = ErrorMessage.EMPTY_USERNAME)
    @Pattern(regexp = "[\\w\\d_]{3,10}", message = ErrorMessage.INVALID_USERNAME)
    private String username;

    @NotNull(message = ErrorMessage.EMPTY_PASSWORD)
    @Size(min = 5, max = 12, message = ErrorMessage.INVALID_PASSWORD)
    private String password;

    @Email(message = ErrorMessage.INVALID_EMAIL)
    private String email;
}
