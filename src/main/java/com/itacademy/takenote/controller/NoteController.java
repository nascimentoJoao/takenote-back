package com.itacademy.takenote.controller;

import com.itacademy.takenote.exception.ResourceNotFoundException;
import com.itacademy.takenote.model.Note;
import com.itacademy.takenote.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class NoteController {

	@Autowired
	NoteRepository noteRepository;
	
	@RequestMapping(value="/notes", method=RequestMethod.GET)
	public List<Note> getAllNotes(){
		return noteRepository.findAll();
	}
	
	@RequestMapping(value="/notes", method=RequestMethod.POST)
	public Note createNote(@Valid @RequestBody Note note) {
		//System.out.println(note.toString());
		return noteRepository.save(note);
	}
	
	@GetMapping("/notes/{id}")
	public Note getNoteById(@PathVariable(value = "id") Long noteId) {
		return noteRepository.findById(noteId)
				.orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
	}
	
	@PutMapping("/notes/{id}")
	public Note updateNote(@PathVariable(value = "id") Long noteId,
			@Valid @RequestBody Note noteDetails) {
		Note note = noteRepository.findById(noteId)
				.orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
		
		note.setTitle(noteDetails.getTitle());
		note.setContent(noteDetails.getContent());
		
		Note updatedNote = noteRepository.save(note);
		return updatedNote;
	}
	
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId){
		Note note = noteRepository.findById(noteId)
				.orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
		
		noteRepository.delete(note);
		
		return ResponseEntity.ok().build();
		
	}
	
	
	/**
	 * @GetMapping("/addresses")
	public void showAddresses(){
		try {
		InetAddress localhost = InetAddress.getByName("CIWRKST06E0C02.cipucrs.pucrs.br");
		System.out.println("IP Addr: "+ localhost.getHostAddress());
		InetAddress[] allMyIps = InetAddress.getAllByName(localhost.getCanonicalHostName());
		
		if(allMyIps != null && allMyIps.length > 1) {
			System.out.println("Todos os endereços IP!");
			for(int i = 0; i < allMyIps.length; i++) {
				System.out.println(
						allMyIps[i].getHostName() 
								+ 
						" -> " 
								+ 
						allMyIps[i].getHostAddress()
						);
			}
		}
		
		}catch(UnknownHostException e) {
			System.out.println("Um erro ocorreu! " + e.getMessage());
		}
	}
	**/
	
}
