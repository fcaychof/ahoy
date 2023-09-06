package com.ahoy.ccee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "file")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nameFile;

    private String status;

}
