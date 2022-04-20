package com.bookwaale.service.author;

import com.bookwaale.service.book.Book;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "author")
public class Author {

    @Id
    @SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_sequence"
    )
    private Long id;

    // name of the author
    private String name;

    // small description of the author
    private String description;

    // books the author has written
    @OneToMany
    private List<Book> books;

    public Author(String name) {
        this.name = name;
    }
}
