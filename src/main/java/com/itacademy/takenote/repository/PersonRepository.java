package com.itacademy.takenote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.itacademy.takenote.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer>{

}
