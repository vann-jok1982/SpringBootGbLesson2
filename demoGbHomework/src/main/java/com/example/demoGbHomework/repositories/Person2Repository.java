package com.example.demoGbHomework.repositories;

import com.example.demoGbHomework.model.Person2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Person2Repository extends JpaRepository<Person2,Integer>{
}
