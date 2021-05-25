package payroll;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TREATMENT")
class Treatment {

	
	private @Id @GeneratedValue Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "COST")
	private double cost;

	Treatment() {
	}

	Treatment(String name, String type, double cost) {

		this.name = name;
		this.type = type;
		this.cost = cost;
	}

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getType() {
		return this.type;
	}
	
	public Double getCost() {
		return this.cost;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void setcost(double cost) {
		this.cost = cost;
	}

//	@Override
//	public boolean equals(Object o) {
//
//		if (this == o)
//			return true;
//		if (!(o instanceof Treatment))
//			return false;
//		Treatment treatment = (Treatment) o;
//		return Objects.equals(this.id, treatment.id) && Objects.equals(this.name, treatment.name)
//				&& Objects.equals(this.role, employee.role);
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(this.id, this.name, this.role);
//	}
//
//	@Override
//	public String toString() {
//		return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.role + '\'' + '}';
//	}
}