package com.hkarabakla.spring_boot_demo.address;

import com.hkarabakla.spring_boot_demo.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue
    private UUID id;
    private String street;
    private String no;
    private String city;
    private String zipcode;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
