package payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import payroll.claim.Claim;
import payroll.claim.ClaimRepository;
import payroll.person.Person;
import payroll.person.PersonRepository;

@Configuration
class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(PersonRepository personRepo, ClaimRepository claimRepo) {

		return args -> {
			Person p1 = new Person("Aneesh", "Gan", "12345");
			Person p2 = new Person("Avinash", "Gan", "12346");
			Person p3 = new Person("Lohi", "Chu", "12375");
			Person p4 = new Person("Aneesh", "Chu", "12348");
			log.info("Preloading " + personRepo.save(p1));
			log.info("Preloading " + personRepo.save(p2));
			log.info("Preloading " + personRepo.save(p3));
			log.info("Preloading " + personRepo.save(p4));

			log.info("Preloading " + claimRepo.save(new Claim("Closed",p1)));
			log.info("Preloading " + claimRepo.save(new Claim("Open",p1)));
			log.info("Preloading " + claimRepo.save(new Claim("Open",p1)));
			log.info("Preloading " + claimRepo.save(new Claim("Closed",p2)));
			log.info("Preloading " + claimRepo.save(new Claim("Open",p2)));
			log.info("Preloading " + claimRepo.save(new Claim("Closed",p3)));
			log.info("Preloading " + claimRepo.save(new Claim("Closed",p3)));
			log.info("Preloading " + claimRepo.save(new Claim("Open",p3)));
			log.info("Preloading " + claimRepo.save(new Claim("Open",p3)));
			log.info("Preloading " + claimRepo.save(new Claim("Closed",p4)));
			log.info("Preloading " + claimRepo.save(new Claim("Open",p4)));
			log.info("Preloading " + claimRepo.save(new Claim("Open",p4)));
			log.info("Preloading " + claimRepo.save(new Claim("Open",p4)));
			
		};
	}
}