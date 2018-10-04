package com.itacademy.takenote.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.itacademy.takenote.exception.ResourceNotFoundException;
import com.itacademy.takenote.model.Person;
import com.itacademy.takenote.repository.PersonRepository;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

	@Autowired
	PersonRepository personRepository;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Person getOnePerson(@PathVariable(value = "id") Integer id){
		return this.personRepository.findById(id).get();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deletePerson(@PathVariable(value = "id") Integer personId){
		
		Person p = personRepository.findById(personId)
				.orElseThrow(() -> new ResourceNotFoundException("Person", "ID", personId));
		
		personRepository.delete(p);
		
		return ResponseEntity.ok().build();
		
	}
	
	@GetMapping
	public List<Person> getAllPerson(){
		return (List<Person>) this.personRepository.findAll();
	}
	
	@PostMapping
	public Person insertPerson(@RequestBody Person person) {
		return this.personRepository.save(person);
	}
	
	
	
}
