package com.alzohar.webSecurity.webservice.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "websecurity_empl")
public class Employee {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "emplid_generator")
	@SequenceGenerator(name = "emplid_generator", initialValue = 1, allocationSize = 1, sequenceName = "emplid_seq")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "department")
	private String Department;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "age")
	private int Age;

	@Column(name = "contact_no")
	private long contactNo;

	@Column(name = "address")
	private String Address;

	@Column(name = "created_at")
	private Date createdAt;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "employee_project_mapping", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "project_id"))

	public Date getCreatedAt() {
		return createdAt = new Date();
	}

	public String getName() {
		return name;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
}
