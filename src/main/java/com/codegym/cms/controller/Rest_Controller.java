package com.codegym.cms.controller;

import com.codegym.cms.model.Category;
import com.codegym.cms.model.Note;
import com.codegym.cms.service.ICategoryService;
import com.codegym.cms.service.IinoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Rest_Controller {
    @Autowired
    private IinoteService iinoteService;

    @Autowired
    private ICategoryService iCategoryService;

    @RequestMapping( value = "/list-note",method = RequestMethod.GET)
    public ResponseEntity<List<Note>> listAllNote(){
        List<Note> noteList = iinoteService.findAll();
        if (noteList.isEmpty()){
            return new ResponseEntity<List<Note>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Note>>(noteList,HttpStatus.OK);
    }

    @GetMapping(value = "/getNote", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Note> noteResponseEntity(){
        long id=3;
        Note note = iinoteService.findById(id);
        return new ResponseEntity<Note>(note,HttpStatus.OK);
    }









}
