package pl.sda.arppl4.springstudents.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.arppl4.springstudents.model.Grade;
import pl.sda.arppl4.springstudents.model.Student;
import pl.sda.arppl4.springstudents.model.Subject;
import pl.sda.arppl4.springstudents.model.dto.CreateGradeRequest;
import pl.sda.arppl4.springstudents.model.dto.StudentDTO;
import pl.sda.arppl4.springstudents.repository.GradeRepository;
import pl.sda.arppl4.springstudents.repository.StudentRepository;
import pl.sda.arppl4.springstudents.repository.SubjectRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service

public class GradeService {

    private final GradeRepository gradeRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    public void addGrade(Long studentId, Long subjectId, CreateGradeRequest request) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        Optional<Subject> optionalSubject = subjectRepository.findById(subjectId);
        if (optionalStudent.isPresent() && optionalSubject.isPresent()) {
            Student student = optionalStudent.get();
            Subject subject = optionalSubject.get();

            Grade gradeNew = new Grade();
            gradeNew.setValue(request.getValue());
            gradeNew.setStudent(student);
            gradeNew.setSubject(subject);

            gradeRepository.save(gradeNew);

        } else {
            throw new EntityNotFoundException("Can't find student or subject");
        }
    }

    public void getAllGrades(Long studentId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if(optionalStudent.isPresent()) {
            Student student = optionalStudent.get();

        }
    }
}
