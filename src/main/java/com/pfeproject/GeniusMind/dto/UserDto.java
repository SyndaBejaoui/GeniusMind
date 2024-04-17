package com.pfeproject.GeniusMind.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


    private String fullName;


    private String email;

    private String password;


    private List<RoleDto> roles;
}
