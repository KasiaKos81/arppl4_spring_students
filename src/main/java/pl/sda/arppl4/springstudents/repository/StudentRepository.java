package pl.sda.arppl4.springstudents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.arppl4.springstudents.model.Student;

public interface StudentRepository extends JpaRepository <Student, Long> {


}
