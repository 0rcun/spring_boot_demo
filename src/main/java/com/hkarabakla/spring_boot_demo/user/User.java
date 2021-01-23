package com.hkarabakla.spring_boot_demo.user;

import com.hkarabakla.spring_boot_demo.address.Address;
import com.hkarabakla.spring_boot_demo.order.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String surname;
    @OneToMany(mappedBy = "user")
    private List<Order> orders;
    @OneToOne(mappedBy = "user")
    private Address address;

    public UserDto toUserDto() {
        return UserDto.builder()
                .id(this.id)
                .name(this.name)
                .surname(this.surname)
                .build();
    }
}
