package com.ejemplo.mvc.negocio;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "User")
public class User {
	
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	
	@Id
	private Long id;
	private String name;
	private String teamName;
	private Long salary;
	
	public User(Long id, String name, String teamName, Long salary) {
		super();
		this.id = id;
		this.name = name;
		this.teamName = teamName;
		this.salary = salary;
	}
	public User() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", teamName=" + teamName + ", salary=" + salary + "]";
	}
	
}
