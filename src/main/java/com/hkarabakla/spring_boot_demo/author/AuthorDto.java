package com.hkarabakla.spring_boot_demo.author;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class AuthorDto {
    private UUID id;
    private String name;

    public Author toAuthor() {
        return Author.builder()
                .id(this.id)
                .name(this.name)
                .build();
    }
}
