package net.nikitos.twit.repository;

import net.nikitos.twit.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role,Integer> {

    Role findByName(String name);
}
