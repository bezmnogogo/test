package com.totalizator.dao.repository;

import com.totalizator.dao.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kasyanov on 6/17/2016.
 */
public interface IRoleRepository extends JpaRepository<Role, Long> {
}
