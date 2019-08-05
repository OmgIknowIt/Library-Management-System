package com.lms.repository.users;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.models.users.UserRole;

@Repository
public interface RoleRepository extends JpaRepository<UserRole, Integer> {

	default List<String> getRoleNames(Integer userId) {
		List<UserRole> roles = findAll();
		List<String> userRoles = new ArrayList<String>();
		for (UserRole role : roles) {
			if(role.getId().equals(userId)) {
				userRoles.add(role.getAppRole().getRoleName());
			}
		}
		return userRoles;
	}
}
