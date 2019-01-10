package com.sas.sbdcc.model;


import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Data
@Validated
public class UserInfo {

    @NotNull
    private Integer id;

    @NotNull
    private String name;

    private String email;
}
