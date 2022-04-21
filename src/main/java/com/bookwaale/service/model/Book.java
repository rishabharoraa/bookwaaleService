package com.bookwaale.service.model;

import com.bookwaale.service.enums.Language;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "book")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Book {

    @Id
    @SequenceGenerator(name = "book_sequence", sequenceName = "book_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence")
    private Long id;

    // TODO: add ISBN-13 support to books

    // name of the book
    private String title;

    // author
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    // number of pages
    private Long pages;

    // date published
    private Date publicationDate;

    // languages the book is available in
    @ElementCollection(targetClass = Language.class)
    @Enumerated(EnumType.STRING)
    private Set<Language> language;

    public Book(String title, Long pages, Date publicationDate, Set<Language> language) {
        this.title = title;
        this.pages = pages;
        this.publicationDate = publicationDate;
        this.language = language;
    }

    public Book(String title,
                Author author,
                Long pages,
                Date publicationDate,
                Set<Language> language) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.publicationDate = publicationDate;
        this.language = language;
    }

    @JsonManagedReference
    public Author getAuthor() {
        return author;
    }

}
