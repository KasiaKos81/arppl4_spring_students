package pl.sda.arppl4.springstudents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.arppl4.springstudents.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    public boolean existsBySubjectName(String subject);
}
