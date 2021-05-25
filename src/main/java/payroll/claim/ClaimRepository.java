package payroll.claim;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import payroll.person.Person;

public interface ClaimRepository extends JpaRepository<Claim, Long> {
	List<Claim> findByPerson(Person person);

	List<Claim> findByPersonAndStatus(Person person, String status);

}