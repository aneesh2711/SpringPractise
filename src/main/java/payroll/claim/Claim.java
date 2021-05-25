package payroll.claim;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import payroll.person.Person;

@Entity
@Table(name = "CLAIMS")
public class Claim {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLAIM_ID")
	private  Long claimId;
	
	@Column(name = "STATUS")
	private String status;
	
//	@Column(name = "PERSON_ID")
//	private long personId;
	
    @Temporal(value=TemporalType.DATE)
    @CreationTimestamp
    @Column(name="CREATED_DATE")
    private Date creationDate;
	
    @Temporal(value=TemporalType.DATE)
    @UpdateTimestamp
    @Column(name="UPDATED_DATE")
    private Date updationDate;
    

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSON_ID",referencedColumnName = "PERSON_ID", nullable = false)
	@JsonBackReference
	private Person person;

//    public long getPersonId() {
//		return personId;
//	}
//
//	public void setPersonId(long personId) {
//		this.personId = personId;
//	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	Claim() {
	}

    public Claim(String status,Person person) {
		this.status = status;
		this.person = person;
	}

	
	public Long getClaimId() {
		return claimId;
	}

	public void setClaimId(Long claimId) {
		this.claimId = claimId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdationDate() {
		return updationDate;
	}

	public void setUpdationDate(Date updationDate) {
		this.updationDate = updationDate;
	}

	

//	@Override
//	public boolean equals(Object o) {
//
//		if (this == o)
//			return true;
//		if (!(o instanceof Personal))
//			return false;
//		Personal employee = (Personal) o;
//		return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name)
//				&& Objects.equals(this.role, employee.role);
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(this.id, this.name, this.role);
//	}
//
	@Override
	public String toString() {
		return "Claim{" + "id=" + this.claimId + ", status='" + this.status + '\'' + ", person='" + this.person.getPersonId() + '\'' + '}';
	}
//


}