package com.totalizator.dao.repository;

import com.totalizator.dao.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IRoleRepository extends JpaRepository<Role, Long> {
}
