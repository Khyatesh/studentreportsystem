package com.klu;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer>{
	 Optional<Teacher> findByUsernameAndPassword(String username, String password);
}
