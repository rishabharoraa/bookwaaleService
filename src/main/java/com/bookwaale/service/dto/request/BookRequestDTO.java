package com.bookwaale.service.dto.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BookRequestDTO {
    private String title;
    private Set<String> languages;
    private Long pages;
    private Long authorId;
    private Date publicationDate;
}
