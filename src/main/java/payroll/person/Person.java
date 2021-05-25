package payroll.person;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import payroll.claim.Claim;

@Entity
@Table(name = "PERSON")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PERSON_ID")
	private Long personId;

	@Column(name = "FIRST_NAME")
	private String fname;

	@Column(name = "LAST_NAME")
	private String lname;

	@Column(name = "MEDICAL_ID", unique = true)
	private String medId;

	@OneToMany(mappedBy = "person",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private Set<Claim> claims;

	Person() {
	}

	public Person(String fname, String lname, String medId) {

		this.fname = fname;
		this.lname = lname;
		this.medId = medId;
	}

	public Long getPersonId() {
		return personId;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getMedId() {
		return medId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setMedId(String medId) {
		this.medId = medId;
	}

	public Set<Claim> getClaims() {
		return claims;
	}

	public void setClaims(Set<Claim> claims) {
		this.claims = claims;
	}

//	@Override
//	public boolean equals(Object o) {
//
//		if (this == o)
//			return true;
//		if (!(o instanceof Person))
//			return false;
//		Person employee = (Person) o;
//		return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name)
//				&& Objects.equals(this.role, employee.role);
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(this.id, this.name, this.role);
//	}

	@Override
	public String toString() {
		return "Person{" + "id=" + this.personId + ", name=\'" + this.fname + " " + this.lname + "\', Medical Id=\'"
				+ this.medId + "\'}";
	}
}