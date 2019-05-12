package com.codegym.cms.service.impl;

import com.codegym.cms.model.Note;
import com.codegym.cms.repository.iNoteRepository;
import com.codegym.cms.service.IinoteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InoteServiceImpl implements IinoteService {
    @Autowired
    private iNoteRepository iNoteRepository;
    @Override
    public List<Note> findAll() {
        Iterable<Note> result = iNoteRepository.findAll();
        return (List<Note>) result;
    }

    @Override
    public Note findById(Long id) {
        return iNoteRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        iNoteRepository.delete(id);
    }

    @Override
    public void save(Note note) {
        iNoteRepository.save(note);
    }
}
