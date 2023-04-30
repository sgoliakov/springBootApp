package org.example.springBootApp.logic.repositories;

import org.example.springBootApp.logic.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
    List<Person> findAllByName(String name);

    List<Person> findAllByNameOrderByAge(String name);

    List<Person> findAllByMail(String mail);

    List<Person> findByNameStartingWith(String startingWith);

    List<Person> findByNameOrMail(String name, String mail);

    @Query("select p from Person p where p.id =: myId") //=: myId - имя для индекса
    List<Person> myQuery(@Param("myId") int id);
}
