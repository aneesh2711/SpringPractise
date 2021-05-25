package payroll.person;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

	List<Person> findByFnameIgnoreCase(String fname);
	List<Person> findByLnameIgnoreCase(String lname);
	List<Person> findByFnameAndLnameIgnoreCase(String fname, String lname);

	Optional<Person> findByMedId(String medId);
}