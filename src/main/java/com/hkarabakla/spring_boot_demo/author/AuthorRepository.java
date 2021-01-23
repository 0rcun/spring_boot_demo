package com.hkarabakla.spring_boot_demo.author;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AuthorRepository extends CrudRepository<Author, UUID> {
}
