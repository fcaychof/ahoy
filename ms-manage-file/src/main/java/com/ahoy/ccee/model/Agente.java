package com.ahoy.ccee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "agente")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Agente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String codigo;

    private String nameFile;


}
