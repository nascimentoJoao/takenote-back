package com.itacademy.takenote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itacademy.takenote.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
