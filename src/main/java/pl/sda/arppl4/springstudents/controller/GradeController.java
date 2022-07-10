package pl.sda.arppl4.springstudents.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.arppl4.springstudents.model.Grade;
import pl.sda.arppl4.springstudents.model.dto.CreateGradeRequest;
import pl.sda.arppl4.springstudents.service.GradeService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/grades")

public class GradeController {

    private final GradeService gradeService;

    @PostMapping("/addGrade")
    @ResponseStatus(HttpStatus.CREATED)
    public void addGrade(@RequestParam Long studentId, @RequestParam Long subjectId, @RequestBody CreateGradeRequest request) {
        log.info("This method allows to add Grade");
        gradeService.addGrade(studentId, subjectId, request);
    }

    @GetMapping("/getAllGrades")
    public List<Grade> getGradeList(@RequestParam Long studentId){
        log.info("This method allows to display the list of Grades");
        gradeService.getAllGrades(studentId);


    }
}
