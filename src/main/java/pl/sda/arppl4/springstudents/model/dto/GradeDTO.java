package pl.sda.arppl4.springstudents.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GradeDTO {

    private Long gradeId;
    private Integer value;

}
