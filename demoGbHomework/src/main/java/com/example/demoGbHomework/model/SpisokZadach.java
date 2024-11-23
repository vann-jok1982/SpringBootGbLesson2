package com.example.demoGbHomework.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="spisokzadach")
public class SpisokZadach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "opisanie")
    private String opisanie;
    @Column(name = "status")
    private String status;
    @Column(name = "data")
    private String data;
}
