package com.lms.repository.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.models.users.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer> {

	default AppUser findUserAccount(String userName) {
		AppUser appUser = null;
		for (AppUser usr : findAll()) {
			if (usr.getUserName().equals(userName)) {
				appUser = usr;
				break;
			}
		}
		return appUser;
	}
}
