package com.dextra.demotest.services;

import com.dextra.demotest.models.People;
import com.dextra.demotest.models.PeopleStatus;
import com.dextra.demotest.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListPeopleByStatusService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public ListPeopleByStatusService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<People> execute(PeopleStatus peopleStatus) {
        return peopleRepository.findByStatus(peopleStatus);
    }
}
