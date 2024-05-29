package com.fpoly.hello1.buoi56.entity;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
    @NotBlank(message = "sai")
    private String name;
    @NotBlank(message = "sai")
    private String address;
    @NotNull(message = "sai")
    @Min(1)
    @Max(100)
    private Integer age;
    @NotBlank(message = "sai")
    private String position;
    @NotEmpty(message = "sai")
    private String hobbies;
    @NotNull(message = "sai")
    private Country country;
}
