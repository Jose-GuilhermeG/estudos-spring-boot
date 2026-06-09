package io.github.joseGuilhermeG.libraryapi.models;

import io.github.joseGuilhermeG.libraryapi.models.Enums.BookType;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "book")
@Data
public class Book {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 20 , nullable = false)
    private String isbn;

    @Column(length = 150,nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDate publish_date;

    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private BookType type;

    @Column(precision = 18 , scale = 2,nullable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
}
