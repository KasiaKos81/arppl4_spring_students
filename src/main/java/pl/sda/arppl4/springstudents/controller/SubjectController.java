package pl.sda.arppl4.springstudents.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.arppl4.springstudents.model.Student;
import pl.sda.arppl4.springstudents.model.Subject;
import pl.sda.arppl4.springstudents.model.dto.StudentDTO;
import pl.sda.arppl4.springstudents.model.dto.SubjectDTO;
import pl.sda.arppl4.springstudents.service.StudentService;
import pl.sda.arppl4.springstudents.service.SubjectService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/subject")
@RestController
@Slf4j

public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping("/getAll")
    public java.util.List<SubjectDTO> getAllSubjects() {
        log.info("This method displays list of all subjects");
        List<SubjectDTO> listOfAllSubjects = subjectService.getAllSubjects();
        return listOfAllSubjects;
    }

    @PostMapping("/addSubject")
    @ResponseStatus(HttpStatus.CREATED)
    public void addSubject(@RequestBody SubjectDTO subject) {
        log.info("This method allows to add subject");
        subjectService.addSubject(subject);
    }

    @DeleteMapping("/deleteSubject/{identifier}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSubject(@PathVariable(name="identifier") Long identyfikator){
        log.info("This method allows to delete subject");
        subjectService.deleteById(identyfikator);
    }

    @PostMapping("/addAllSubjects")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudents(@RequestBody List<SubjectDTO> subjectList){
        log.info("This method allows to add list of subjects");
        subjectService.addAllSubjects(subjectList);

    }


}
