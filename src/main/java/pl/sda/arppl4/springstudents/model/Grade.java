package pl.sda.arppl4.springstudents.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import pl.sda.arppl4.springstudents.model.dto.GradeDTO;
import pl.sda.arppl4.springstudents.model.dto.SubjectDTO;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor


public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private Integer value;

    @CreationTimestamp
    private LocalDateTime dateAdded;

    @ManyToOne
    @ToString.Exclude
    @JsonBackReference
    private Student student;

    @ManyToOne
    @ToString.Exclude
    @JsonBackReference
    private Subject subject;

    public GradeDTO mapToGradeDTO() {
        return new GradeDTO(
                id,
                value

        );
    }

}
