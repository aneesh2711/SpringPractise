package payroll.person;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	private final PersonRepository repository;

	PersonController(PersonRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/persons")
	List<Person> all(@RequestParam(required = false) String fname, @RequestParam(required = false) String lname) {

		if (fname == null && lname == null) {
			return repository.findAll();
		} else if (fname != null && lname == null) {
			return repository.findByFnameIgnoreCase(fname);
		} else if (lname != null && fname == null) {
			return repository.findByLnameIgnoreCase(lname);
		} else {
			return repository.findByFnameAndLnameIgnoreCase(fname,lname);
		}
	}

	@PostMapping("/person")
	Person newPerson(@RequestBody Person newPerson) {
		return repository.save(newPerson);
	}
	
	@GetMapping("/person")
	Person one(@RequestParam String medId) {
		return repository.findByMedId(medId).orElseThrow(() -> new PersonNotFoundException("Person with Medical Id = "+medId+ " is not found."));
	}

	@GetMapping("/person/{id}")
	Person one(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new PersonNotFoundException("Person with id = "+id+ " is not found."));
	}

	@PutMapping("/person/{id}")
	Person replacePerson(@RequestBody Person newPerson, @PathVariable Long id) {

		return repository.findById(id).map(person -> {
			person.setFname(newPerson.getFname());
			person.setLname(newPerson.getLname());
			person.setMedId(newPerson.getMedId());
			return repository.save(person);
		}).orElseGet(() -> {
			System.out.println(id);
			newPerson.setPersonId(id);
			System.out.println(newPerson.getPersonId());
			return repository.save(newPerson);
		});
	}

	@DeleteMapping("/person/{id}")
	void deletePerspn(@PathVariable Long id) {
		repository.deleteById(id);
	}
}