package com.codegym.controller;

import com.codegym.model.Note;
import com.codegym.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class RestNoteController {

    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public ResponseEntity<Page<Note>> listAllNotes(Pageable pageable) {
        Page<Note> notes = noteService.findAll(pageable);
        if (notes.getTotalElements() == 0) {
            return new ResponseEntity<Page<Note>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Page<Note>>(notes, HttpStatus.OK);
    }

    @RequestMapping(value = "/notes/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Note> getNote(@PathVariable Long id) {
        System.out.println("Fetching Note with id" + id);
        Note note = noteService.findById(id);
        if (note == null) {
            return new ResponseEntity<Note>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Note>(note, HttpStatus.OK);
    }

    @RequestMapping(value = "/notes", method = RequestMethod.POST)
    public ResponseEntity<Void> createNote(@RequestBody Note note) {
        noteService.save(note);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/notes/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Note> updateNote(@PathVariable("id") Long id, @RequestBody Note note) {
        Note currentNote = noteService.findById(id);

        if (currentNote == null) {
            return new ResponseEntity<Note>(HttpStatus.NOT_FOUND);
        }

        currentNote.setTitle(note.getTitle());
        currentNote.setContent(note.getContent());
        currentNote.setId(note.getId());
        currentNote.setNoteType(note.getNoteType());

        noteService.save(currentNote);
        return new ResponseEntity<Note>(currentNote, HttpStatus.OK);
    }


    @RequestMapping(value = "/notes/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Note> deleteNote(@PathVariable("id") Long id) {
        Note note = noteService.findById(id);
        if (note == null) {
            return new ResponseEntity<Note>(HttpStatus.NOT_FOUND);
        }

        noteService.remove(id);
        return new ResponseEntity<Note>(HttpStatus.NO_CONTENT);
    }
}
