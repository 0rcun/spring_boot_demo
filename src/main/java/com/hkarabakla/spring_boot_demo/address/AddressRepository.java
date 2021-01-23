package com.hkarabakla.spring_boot_demo.address;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AddressRepository extends CrudRepository<Address, UUID> {
}
