package hibernate_employee.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Employee {
	@Id
	private int id;
	private String name;
	@Column(unique=true)
	private long phone;
	private double salary;
	private String designation;
	@Column(unique=true)
	private String email;
	

}
