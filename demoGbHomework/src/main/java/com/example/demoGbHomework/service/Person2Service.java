package com.example.demoGbHomework.service;

import com.example.demoGbHomework.model.Person2;
import com.example.demoGbHomework.repositories.Person2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class Person2Service {
    private final Person2Repository person2Repository;
    @Autowired
    public Person2Service(Person2Repository person2Repository) {
        this.person2Repository = person2Repository;
    }
    public List<Person2> findAll(){ // Считывание данных с БД
        return person2Repository.findAll();
    }
    public Person2 findOne(int id){ // Поиск по ID
        Optional<Person2> foundPerson= person2Repository.findById(id);
        return foundPerson.orElse(null);
    }
    @Transactional
    public void save(Person2 person2){ // Сщхранение в БД
        person2Repository.save(person2);
    }
    @Transactional
    public void update(int id, Person2 updatePerson2){ // Изменения в БД
        updatePerson2.setId(id);
        person2Repository.save(updatePerson2);
    }
    @Transactional
    public void delete(int id){ //удаление по ID
        person2Repository.deleteById(id);
    }
}
