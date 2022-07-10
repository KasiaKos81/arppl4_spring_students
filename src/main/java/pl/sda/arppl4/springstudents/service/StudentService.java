package pl.sda.arppl4.springstudents.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.arppl4.springstudents.model.Grade;
import pl.sda.arppl4.springstudents.model.Student;
import pl.sda.arppl4.springstudents.model.dto.StudentDTO;
import pl.sda.arppl4.springstudents.repository.StudentRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Slf4j
@Service

public class StudentService {

    private final StudentRepository studentRepository;


    public List<StudentDTO> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();

        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (Student student : studentList) {
            studentDTOList.add(student.mapToStudentDTO());
        }

        return studentDTOList;
    }

    public void add(Student student) {
        studentRepository.save(student);
    }

    public void deleteById(Long identyfikator) {
        Optional<Student> studentOptional = studentRepository.findById(identyfikator);
        if (studentOptional.isPresent()) {
            Student studentDoDelete = studentOptional.get();
            Set<Grade> setOfGrades = studentOptional.get().getGrades();
            if (!setOfGrades.isEmpty()) {
                System.out.println("Student cannot be deleted");
            } else {
                studentRepository.deleteById(identyfikator);
                System.out.println("Student is deleted from database");
            }

        } else {
            System.out.println("404 student with given id not found");
        }
    }

    public void update(Long identyfiktor, Student student) {
        Optional<Student> studentOptional = studentRepository.findById(identyfiktor);
        if (studentOptional.isPresent()) {
            Student studencik = studentOptional.get();

            if (student.getName() != null) {
                studencik.setName(student.getName());
            }
            if (student.getName() != null) {
                studencik.setSurname(student.getSurname());
            }
            if (student.getBirthDate() != null) {
                studencik.setBirthDate(student.getBirthDate());
            }
            if (student.getIndexNo() != null) {
                studencik.setIndexNo(student.getIndexNo());
            }

            studentRepository.save(studencik);
            return;
        }
        throw new EntityNotFoundException("404 student not found, no such id: " + identyfiktor);
    }


    public void addAllStudents(List<Student> studentList) {
        for (Student studencik : studentList) {
            studentRepository.save(studencik);

        }

    }
}


