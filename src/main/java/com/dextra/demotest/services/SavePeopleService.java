package com.dextra.demotest.services;

import com.dextra.demotest.models.People;
import com.dextra.demotest.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavePeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public SavePeopleService(PeopleRepository peopleRepository) {

        this.peopleRepository = peopleRepository;
    }

    public People execute(People people) {

        return peopleRepository.save(people);
    }
}
