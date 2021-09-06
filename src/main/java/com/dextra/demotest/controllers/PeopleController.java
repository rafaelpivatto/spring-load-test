package com.dextra.demotest.controllers;

import com.dextra.demotest.models.People;
import com.dextra.demotest.models.PeopleStatus;
import com.dextra.demotest.services.ListPeopleByStatusService;
import com.dextra.demotest.services.SavePeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private SavePeopleService savePeopleService;

    @Autowired
    private ListPeopleByStatusService listPeopleByStatusService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<People> savePerson(@RequestBody People person) {

        return new ResponseEntity<People>(savePeopleService.execute(person), HttpStatus.CREATED);
    }

    @GetMapping(produces = "application/json")
    public List<People> listByStatus(@RequestParam(value = "status", defaultValue = "ACTIVE") PeopleStatus personStatus) {

        return listPeopleByStatusService.execute(personStatus);
    }

}
