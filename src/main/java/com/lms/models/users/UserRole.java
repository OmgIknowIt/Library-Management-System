package com.lms.models.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user_role", //
		uniqueConstraints = { //
				@UniqueConstraint(name = "USER_ROLE_UK", columnNames = { "user_id", "role_id" }) })
public class UserRole {

	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	private AppUser appUser;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id", nullable = false)
	private AppRole appRole;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public AppRole getAppRole() {
		return appRole;
	}

	public void setAppRole(AppRole appRole) {
		this.appRole = appRole;
	}

}