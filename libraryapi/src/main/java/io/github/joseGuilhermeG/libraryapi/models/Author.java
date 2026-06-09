package io.github.joseGuilhermeG.libraryapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(
    name = "author",
    schema = "public"
)
@Getter
@Setter
public class Author {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(length = 100,nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDate born_date;
    @Column(nullable = false)
    private String nationality;

    @OneToMany(mappedBy = "author")
    private List<Book> books;
}
