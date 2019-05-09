package com.codegym.cms.repository;

import com.codegym.cms.model.Note;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface iNoteRepository extends PagingAndSortingRepository<Note,Long> {
}
