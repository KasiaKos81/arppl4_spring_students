package pl.sda.arppl4.springstudents.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.arppl4.springstudents.model.Grade;
import pl.sda.arppl4.springstudents.model.Student;
import pl.sda.arppl4.springstudents.model.Subject;
import pl.sda.arppl4.springstudents.model.dto.StudentDTO;
import pl.sda.arppl4.springstudents.model.dto.SubjectDTO;
import pl.sda.arppl4.springstudents.repository.SubjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Slf4j
@Service

public class SubjectService {

    private final SubjectRepository subjectRepository;


    public List<SubjectDTO> getAllSubjects(){
        List<Subject> subjectList = subjectRepository.findAll();

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        for (Subject subject : subjectList) {
            subjectDTOList.add(subject.mapToSubjectDTO());
        }

        return subjectDTOList;
    }



    // Neostrada         -> neostrada
    // N eO sT rA d a    -> neostrada
    public void addSubject(SubjectDTO dto) {
        List<Subject> allSubjects = subjectRepository.findAll();
        String nazwaNowegoPrzedmiotuBezSpacji = dto.getSubjectName().replaceAll(" ", "");
        for (Subject przedmiocik : allSubjects) {
            String nazwaPrzedmiotuWBazieDanychBezSpacji= przedmiocik.getSubjectName().replaceAll(" ", "");
            if(nazwaPrzedmiotuWBazieDanychBezSpacji.equalsIgnoreCase(nazwaNowegoPrzedmiotuBezSpacji)){
                return;
            }
        }
        subjectRepository.save(new Subject(dto.getSubjectName()));
    }

    public void deleteById(Long identyfikator) {
        Optional<Subject> subjectOptional = subjectRepository.findById(identyfikator);
        if (subjectOptional.isPresent()) {
            Subject subjectDoDelete = subjectOptional.get();
            Set<Grade> setOfGrades = subjectOptional.get().getGrades();
            if (!setOfGrades.isEmpty()) {
                System.out.println("Subject cannot be deleted");
            } else {
                subjectRepository.deleteById(identyfikator);
                System.out.println("Subject is deleted from database");
            }
        } else {
            System.out.println("404 subject with given id not found");
        }
    }

    public void addAllSubjects(List<SubjectDTO> subjectList) {
        for (SubjectDTO subjekcik : subjectList) {
            addSubject(subjekcik);
//            subjectRepository.save(new Subject(subjekcik.getSubjectName()));
        }

    }
}
