package com.zipcodewilmington.bakery.controllers;

import com.zipcodewilmington.bakery.models.Muffin;
import com.zipcodewilmington.bakery.services.MuffinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RequestMapping("/api/v1/muffin")
@Controller
public class MuffinController {
    private MuffinService service;

    @Autowired
    public MuffinController(MuffinService service) {
        this.service = service;
    }

    public ResponseEntity<Iterable<Muffin>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    @GetMapping(path="{id}")
    public ResponseEntity<Muffin> show(@PathVariable("id")Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

        @PostMapping
    public ResponseEntity<Muffin> create(@RequestBody Muffin baker) {
        return new ResponseEntity<>(service.create(baker), HttpStatus.CREATED);
    }
        @PutMapping(path="{id}")
    public ResponseEntity<Muffin> update(@PathVariable("id")Long id, @Valid @NotNull @RequestBody Muffin baker) {
        return new ResponseEntity<>(service.update(id, baker), HttpStatus.OK);
    }
        @DeleteMapping(path="{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable("id")Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
