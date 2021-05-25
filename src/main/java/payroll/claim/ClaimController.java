package payroll.claim;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import payroll.person.Person;
import payroll.person.PersonNotFoundException;
import payroll.person.PersonRepository;

@RestController
public class ClaimController {

	private final ClaimRepository repository;

	@Autowired
	PersonRepository personRepo;

	ClaimController(ClaimRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/person/{id}/claims")
	List<Claim> PersonClaims(@PathVariable Long id, @RequestParam(required = false) String status) {
		Person person = personRepo.findById(id)
				.orElseThrow(() -> new PersonNotFoundException("Person with id = " + id + " is not found."));
		if (status == null) {
			return repository.findByPerson(person);
		} else {
			return repository.findByPersonAndStatus(person,status);
		}
	}

	@GetMapping("/claim/{id}")
	Claim one(@PathVariable Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ClaimNotFoundException("Claim with id = " + id + " is not found."));
	}

	@GetMapping("/claim/{id}/person")
	Person person(@PathVariable Long id) {
		Claim claim = repository.findById(id)
				.orElseThrow(() -> new ClaimNotFoundException("Claim with id = " + id + " is not found."));
		return claim.getPerson();
	}

	@PostMapping("/claim")
	Claim newClaim(@RequestBody Claim claim) {
//		long personId = claim.getPersonId();
//		Person person = personRepo.findById(personId)
//				.orElseThrow(() -> new PersonNotFoundException("Person with id = " + personId + " is not found."));
//		claim.setPerson(person);
		return repository.save(claim);
	}

	@PostMapping("/person/{id}/claim")
	Claim newClaim(@PathVariable Long id, @RequestBody Claim claim) {
		Person person = personRepo.findById(id)
				.orElseThrow(() -> new PersonNotFoundException("Person with id = " + id + " is not found."));
		claim.setPerson(person);
		return repository.save(claim);
	}

	@PutMapping("/claim/{id}")
	Claim updateClaim(@RequestBody Claim newClaim, @PathVariable Long id) {

		return repository.findById(id).map(claim -> {
			claim.setStatus(newClaim.getStatus());
			return repository.save(claim);
		}).orElseThrow(() -> new ClaimNotFoundException("Claim with id = " + id + " is not found."));
	}

	@DeleteMapping("/claim/{id}")
	void deleteClaim(@PathVariable Long id) {
		repository.deleteById(id);
	}
}