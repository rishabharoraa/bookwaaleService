package com.bookwaale.service.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "author")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Author {

    @Id
    @SequenceGenerator(name = "author_sequence", sequenceName = "author_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_sequence")
    private Long id;

    // name of the author
    private String name;

    // small description of the author
    private String description;

    // books the author has written
    @OneToMany(
            mappedBy = "author"
    )
    private Set<Book> books;

    public Author(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Author(String name) {
        this.name = name;
    }

    @JsonBackReference
    public Set<Book> getBooks() {
        return books;
    }
}
