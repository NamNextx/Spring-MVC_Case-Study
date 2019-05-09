package com.codegym.cms.service;

import com.codegym.cms.model.Note;

import java.util.List;

public interface IinoteService {
    List<Note> findAll();
    Note findById(Long id);
    void remove(Long id);
    void save(Note note);
}
