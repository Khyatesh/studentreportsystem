package com.klu;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent, Integer> {
	Optional<Parent> findByUsernameAndPassword(String username, String password);
}
