package pl.sda.arppl4.springstudents.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.sda.arppl4.springstudents.model.dto.SubjectDTO;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String subjectName;

    @OneToMany(mappedBy = "subject", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    private Set<Grade> grades;

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public SubjectDTO mapToSubjectDTO() {
        return new SubjectDTO(
                id,
                subjectName
        );
    }

}
