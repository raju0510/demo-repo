package com.org.repository;

import com.org.data.Item;

import com.org.persist.Repository_Info_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Repository_Info_Entity,Integer> {
   // Repository_Info findByName(String name);
    @Query("SELECT tyd FROM Repository_Info_Entity tyd"
            + " WHERE tyd.full_name=:full_name")
    Optional<Repository_Info_Entity> findByFullName(String full_name);
}
