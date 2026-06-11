package io.github.joseGuilhermeG.libraryapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(
    name = "author",
    schema = "public"
)
@Getter
@Setter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Author {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(length = 100,nullable = false)
    private String name;
    @Column(name = "born_date", nullable = false)
    private LocalDate bornDate;
    @Column(nullable = false)
    private String nationality;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Book> books;


}
