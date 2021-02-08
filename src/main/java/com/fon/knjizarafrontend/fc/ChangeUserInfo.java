package com.fon.knjizarafrontend.fc;

import com.fon.knjizarafrontend.dto.CityDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChangeUserInfo {

    private Long userId;

    private String username;

    private String oldPassword;

    private String password;

    private String name;

    private String lastName;

    private String email;

    private String phone;

    private String address;

    private CityDTO city;

    private String role;
}
