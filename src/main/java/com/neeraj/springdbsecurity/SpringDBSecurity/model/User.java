package com.neeraj.springdbsecurity.SpringDBSecurity.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int id;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="name")
	private String name;
	@Column(name="last_name")
	private String lname;
	@Column(name="active_status")
	private int active;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(User user) {
		this.id=user.getId();
		this.name=user.getFname();
		this.lname=user.getLname();
		this.email=user.getEmail();
		this.password=user.getPassword();
		this.active=user.getActive();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFname() {
		return name;
	}
	public void setFname(String fname) {
		this.name = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	

}
