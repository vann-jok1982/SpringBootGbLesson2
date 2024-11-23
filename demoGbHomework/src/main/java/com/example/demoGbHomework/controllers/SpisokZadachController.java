package com.example.demoGbHomework.controllers;

import com.example.demoGbHomework.model.SpisokZadach;
import com.example.demoGbHomework.service.SpisokZadachServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/spisokzadach")
public class SpisokZadachController {
    @Autowired
    SpisokZadachServise spisokZadachServise;
    @GetMapping()  // все задачи
    public String printSpisok(Model model){
        model.addAttribute("spisok",spisokZadachServise.findAll());
        return "spisok_zadach";
    }
    @GetMapping("/save")   // Добавление задачи
    public String showForm(Model model) {
           model.addAttribute("formData", new SpisokZadach());
        return "save"; // 
    }

    @PostMapping("/save")   // пост метод для добавления задачи
    public String submitForm(@ModelAttribute SpisokZadach spisokZadach) {
        spisokZadach.setStatus("не начата");
        Date date=new Date();
        spisokZadach.setData(date.toString());
        spisokZadachServise.save(spisokZadach);
        return "redirect:/spisokzadach"; // имя шаблона для отображения результата
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("zadacha", spisokZadachServise.findOne(id));
        return "show";
    }
    @GetMapping("/delete/{id}")   // отображение задачи по id
    public String delete(@PathVariable("id") int id){
        spisokZadachServise.delete(id);
        return "redirect:/spisokzadach";
    }
    @GetMapping("/vprocesse/{id}")  // изменение статуса на в процессе
    public String vProcesse(@PathVariable("id") int id){
        SpisokZadach updateZadacha=spisokZadachServise.findOne(id);
        updateZadacha.setStatus("в процессе");
        spisokZadachServise.update(id,updateZadacha);
        return "redirect:/spisokzadach";
    }
    @GetMapping("/zavershena/{id}")  // изменение статуса на завершена
    public String zavershena(@PathVariable("id") int id){
        SpisokZadach updateZadacha=spisokZadachServise.findOne(id);
        updateZadacha.setStatus("завершена");
        spisokZadachServise.update(id,updateZadacha);
        return "redirect:/spisokzadach";
    }
    @GetMapping("/postatusu/vprocesse")  // вызвать список по статусу < в процессе >
    public String SpisokPoStatusuVprocesse(Model model){
        model.addAttribute("spisok",spisokZadachServise.findAll().stream().filter(spisokZadach -> spisokZadach.getStatus().equals("в процессе")));
        return "spisok_zadach";
    }
    @GetMapping("/postatusu/zavershena")  // вызвать список по статусу < завершина >
    public String SpisokPoStatusuZavershena(Model model){
        model.addAttribute("spisok",spisokZadachServise.findAll().stream().filter(spisokZadach -> spisokZadach.getStatus().equals("завершена")));
        return "spisok_zadach";
    }
    @GetMapping("/postatusu/nenachata")  // вызвать список по статусу < не начата >
    public String SpisokPoStatusuNeNachata(Model model){
        model.addAttribute("spisok",spisokZadachServise.findAll().stream().filter(spisokZadach -> spisokZadach.getStatus().equals("не начата")));
        return "spisok_zadach";
    }
}
