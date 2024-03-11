package com.example.instructor.models;

import jakarta.persistence.*;

@Entity
@Table(name="user1",uniqueConstraints = {
		@UniqueConstraint(columnNames = "email"),
		@UniqueConstraint(columnNames = "mobilenumber"),
		
})
public class Register 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true,nullable = false)
	private String email;
	
	@Column(unique = true,nullable = false)
	private String mobilenumber;
	@Column(unique = false,nullable = false)
	private String password;
	@Column(unique = false,nullable = true)
	private String pincode;
	@Column(unique = false,nullable = true)
	private String city;
	@Column(unique = false,nullable = true)
	private String country;
	@Column(unique = false,nullable = true)
	private String state;
	@Column(unique = false,nullable = true)
	private String first_name;
	@Column(unique = false,nullable = true)
	private String last_name;
	public Register(int id, String email, String first_name, String last_name, String mobilenumber, String password,
			String pincode, String city, String country, String state) {
		super();
		this.id = id;
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobilenumber = mobilenumber;
		this.password = password;
		this.pincode = pincode;
		this.city = city;
		this.country = country;
		this.state = state;
	}
	public Register() {
		super();
	}
	@Override
	public String toString() {
		return "Register [id=" + id + ", email=" + email + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", mobilenumber=" + mobilenumber + ", password=" + password + ", pincode=" + pincode + ", city="
				+ city + ", country=" + country + ", state=" + state + "]";
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
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
	 
	    
	    

	
	
    
	
}

