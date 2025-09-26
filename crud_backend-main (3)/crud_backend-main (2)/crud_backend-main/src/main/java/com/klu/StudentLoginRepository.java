package com.klu;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentLoginRepository extends JpaRepository<StudentLogin, Integer> {
	Optional<StudentLogin> findByUsernameAndPassword(String username, String password);
}
