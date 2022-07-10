package pl.sda.arppl4.springstudents.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.arppl4.springstudents.model.Student;
import pl.sda.arppl4.springstudents.model.dto.StudentDTO;
import pl.sda.arppl4.springstudents.service.StudentService;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/student")

public class StudentController {

    private final StudentService studentService;

    @GetMapping("/getAll")
    public List<StudentDTO> getAllStudents() {
        log.info("This method displays list of all students");
        List<StudentDTO> listOfAllStudents = studentService.getAllStudents();
        return listOfAllStudents;
    }

    @PostMapping("/addAll")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudents(@RequestBody List<Student> studentList){
        log.info("This method allows to add list of students");
        studentService.addAllStudents(studentList);

    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student){
        log.info("This method allows to post a student " + student);
        studentService.add(student);
    }

    @DeleteMapping("/delete/{identifier}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable(name="identifier") Long identyfikator){
        log.info("This method allows to delete the student from the database using id: " + identyfikator);
        studentService.deleteById(identyfikator);
    }

    @PatchMapping("/update/{identifier}")
    public void updateStudent(@PathVariable(name = "identifier") Long identyfiktor, @RequestBody Student student){
        log.info("This method allows to update student data " + student);
        studentService.update(identyfiktor, student);

    }



}
