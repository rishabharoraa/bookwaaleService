package com.bookwaale.service.book;

import com.bookwaale.service.author.Author;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {

    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private Long id;

    // TODO: add ISBN-13 support to books

    // name of the book
    private String title;

    // author
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author Author;

    private Long pages;
    private Date publicationDate;


    // TODO: add these properties
    // private Language language
    // private Publisher publisher
    // ----------------------------
    // private Long gazes
    // private byte rating
}
