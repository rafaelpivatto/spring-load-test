package com.dextra.demotest.repositories;

import com.dextra.demotest.models.People;
import com.dextra.demotest.models.PeopleStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeopleRepository extends JpaRepository<People, String> {

    List<People> findByStatus(PeopleStatus status);
}
