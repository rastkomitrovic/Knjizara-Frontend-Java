package com.fon.knjizarafrontend.fc;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginUser {

    @NotNull(message = "Obavezno polje")
    @Size(min = 2, message = "Korisnicko ime mora sadrzati barem 2 karaktera")
    private String username;

    @NotNull(message = "Obavezno polje")
    @Size(min = 8, message = "Sifra mora sadrzati barem 8 karaktera")
    private String password;
}
