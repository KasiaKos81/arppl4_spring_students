package pl.sda.arppl4.springstudents.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentDTO {

    private Long studentId;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String indexNo;

}
