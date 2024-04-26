package by.charniuk.homelibrary.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    @JsonProperty("isPaperBook")
    private boolean isPaperBook;
    private String author;
    private String title;
    private int year;
    @Column(unique = true)
    private String description;
}
