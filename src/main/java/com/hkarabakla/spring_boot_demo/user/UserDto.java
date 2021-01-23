package com.hkarabakla.spring_boot_demo.user;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private UUID id;
    @NotBlank(message = "Name for the user is mandatory")
    private String name;
    @NotBlank(message = "Surname for the user is mandatory")
    private String surname;

    public User toUser() {
        return User.builder()
                .id(this.id)
                .name(this.name)
                .surname(this.surname)
                .build();
    }
}
