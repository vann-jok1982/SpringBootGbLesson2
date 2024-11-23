package com.example.demoGbHomework.service;

import com.example.demoGbHomework.model.SpisokZadach;
import com.example.demoGbHomework.repositories.SpisokZadachRepozitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SpisokZadachServise {
    private final SpisokZadachRepozitory spisokZadachRepozitory;
    @Autowired
    public SpisokZadachServise(SpisokZadachRepozitory spisokZadachRepozitory) {
        this.spisokZadachRepozitory = spisokZadachRepozitory;
    }

    public List<SpisokZadach> findAll(){ // Считывание данных с БД
        return spisokZadachRepozitory.findAll();
    }
    public SpisokZadach findOne(int id){ // Поиск по ID
        Optional<SpisokZadach> foundSpisokZadach= spisokZadachRepozitory.findById(id);
        return foundSpisokZadach.orElse(null);
    }
    @Transactional
    public void save(SpisokZadach spisokZadach){ // Сщхранение в БД
        spisokZadachRepozitory.save(spisokZadach);
    }
    @Transactional
    public void update(int id, SpisokZadach updateSpisokZadach){ // Изменения в БД
        updateSpisokZadach.setId(id);
        spisokZadachRepozitory.save(updateSpisokZadach);
    }
    @Transactional
    public void delete(int id){ //удаление по ID
        spisokZadachRepozitory.deleteById(id);
    } //Удаление из БД
}
