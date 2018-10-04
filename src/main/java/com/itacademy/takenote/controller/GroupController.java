package com.itacademy.takenote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.itacademy.takenote.model.Group;
import com.itacademy.takenote.repository.GroupRepository;

@RestController
@RequestMapping("/api")
public class GroupController {
	
	@Autowired
	private GroupRepository groupRepository;
	
	/* Adicionar um grupo. */
	
	@PostMapping("/group")
	public Group addGroup(@RequestBody Group group, UriComponentsBuilder uc) {
		
		if(group.getId()!=0 && groupRepository.existsById(group.getId())) {
			
		}
		
		return this.groupRepository.save(group);
	}

}
